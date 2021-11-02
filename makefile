# 执行版本
version:=1.0.0

jars:=$(CURDIR)/target/hydra-app-1.0.0.jar;$(CURDIR)/target/hydra-plug-1.0.0.jar

options:=-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory

# mvm package
define maven_build # project
	$(or $(MVN_HOME)/bin/mvn, mvn) --quiet --fail-fast -DskipTests=true --file $(strip $(1))/pom.xml clean $(or $(strip $(2)), package)
endef

# run feature
define hydra_run
	$(or $(JAVA_HOME)/bin/java, java) -verbose:classes -classpath $(jars);$(strip $(1)) io.vertx.core.Launcher run com.murphyl.hydra.Application
endef

build/face:
	$(call maven_build, hydra-plug, install)

# 编译核心模块
build/core:
	$(call maven_build, hydra-core)

run/task: build/face build/core
	$(call maven_build, plug-ins/hydra-tasker)
	$(call hydra_run, $(CURDIR)/target/hydra-tasker-1.0.0.jar)

run/config-task: build/face build/core
	$(call maven_build, plug-ins/hydra-config)
	$(call maven_build, plug-ins/hydra-tasker)
	$(call hydra_run, $(CURDIR)/target/hydra-tasker-1.0.0.jar;$(CURDIR)/target/hydra-config-1.0.0.jar)

java/help:
	$(or $(JAVA_HOME)/bin/java, java) --help
