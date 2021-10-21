# 执行版本
version:=1.0.0

option:=-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory

# mvm package
define maven_build # project
	$(or $(MVN_HOME)/bin/mvn, mvn) --quiet --fail-fast -DskipTests=true --file $(strip $(1))/pom.xml clean $(or $(strip $(2)), package)
endef

# run feature
define hydra_run
	$(or $(JAVA_HOME)/bin/java, java) -classpath $(CURDIR)/hydra-face/target/hydra-face-$(version).jar;$(CURDIR)/hydra-core/target/hydra-app-$(version).jar;$(CURDIR)/hydra-plug/$(strip $(1))/target/$(strip $(if $(2), classes, $(1)-$(version).jar)) $(option) io.vertx.core.Launcher run com.murphyl.hydra.Application
endef

build/face:
	$(call maven_build, hydra-face, install)

# 编译核心模块
build/core:
	$(call maven_build, hydra-core)

run/task: build/face build/core
	$(call maven_build, hydra-plug/hydra-task)
	$(call hydra_run, hydra-task)
	
run/rest: build/face build/core
	$(call maven_build, hydra/features/hydra-rest)
	$(call hydra_run, hydra-rest)

java/help:
	$(or $(JAVA_HOME)/bin/java, java) --help