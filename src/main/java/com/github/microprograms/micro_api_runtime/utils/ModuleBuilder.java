package com.github.microprograms.micro_api_runtime.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.microprograms.micro_api_runtime.model.Api;
import com.github.microprograms.micro_api_runtime.model.Module;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ImplementingClassMatchProcessor;

public class ModuleBuilder {
	private static final Logger log = LoggerFactory.getLogger(ModuleBuilder.class);

	public static Module build(String... scanSpec) {
		Module module = new Module();
		new FastClasspathScanner(scanSpec) //
				.matchClassesImplementing(Api.class, new ImplementingClassMatchProcessor<Api>() {
					@Override
					public void processMatch(Class<? extends Api> apiClass) {
						String apiName = apiClass.getSimpleName();
						if (module.contains(apiName)) {
							log.error("duplicate api, apiName={}, class={}", apiName, apiClass.getName());
							return;
						}

						try {
							module.putApi(apiName, apiClass.newInstance());
							log.info("api loaded, apiName={}, class={}", apiName, apiClass.getName());
						} catch (InstantiationException | IllegalAccessException e) {
							log.error("can't instance api, apiName={}, class={}", apiName, apiClass.getName());
						}
					}
				}).scan();
		return module;
	}
}
