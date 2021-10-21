
# 执行版本
version:=1.0.0

# 特性
features:=$(wildcard hydra/features/*)

# mvm package
define maven_build # project
	$(or $(MVN_HOME)/bin/mvn, mvn) --quiet --fail-fast -DskipTests=true --file $(strip $(1))/pom.xml clean $(or $(strip $(2)), package)
endef

# run feature
define hydra_run
	$(or $(JAVA_HOME)/bin/java, java) -verbose:gc -cp $(CURDIR)/murph-x/target/murph-x-$(version).jar;$(CURDIR)/hydra/features/$(strip $(1))/target/$(strip $(1))-$(version).jar -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory -jar $(CURDIR)/hydra/hydra-core/target/hydra-app-$(version).jar
endef

# 编译核心模块
build/core:
	$(call maven_build, murph-x, install)
	$(call maven_build, hydra/hydra-core)

run/etl: build/core
	$(call maven_build, hydra/features/hydra-etl)
	$(call hydra_run, hydra-etl)

java/help:
	$(or $(JAVA_HOME)/bin/java, java) --help

features/list:
	@echo $(features)

