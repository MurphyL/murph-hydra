# 执行版本
version:=1.0.0

hydra_deps=$(CURDIR)/murph-x/target/murph-x-$(version).jar;$(CURDIR)/hydra/hydra-core/target/hydra-app-$(version).jar

# mvm package
define maven_build # project
	$(or $(MVN_HOME)/bin/mvn, mvn) --quiet --fail-fast -DskipTests=true --file $(strip $(1))/pom.xml clean $(or $(strip $(2)), package)
endef

# run feature
define hydra_run
	$(or $(JAVA_HOME)/bin/java, java) -verbose:gc --class-path $(hydra_deps);$(CURDIR)/hydra/features/$(strip $(1))/target/$(strip $(if $(2), classes, $(1)-$(version).jar)) -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory io.vertx.core.Launcher run com.murphyl.hydra.Application
endef

# 编译核心模块
build/core:
	$(call maven_build, murph-x, install)
	$(call maven_build, hydra/hydra-core)

run/task: build/core
	$(call maven_build, hydra/features/hydra-task)
	$(call hydra_run, hydra-task)
	
dev/task: build/core
	$(call hydra_run, hydra-task, true)
	
run/rest: build/core
	$(call maven_build, hydra/features/hydra-rest)
	$(call hydra_run, hydra-rest)

java/help:
	$(or $(JAVA_HOME)/bin/java, java) --help