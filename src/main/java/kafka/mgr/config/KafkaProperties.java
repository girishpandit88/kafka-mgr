package kafka.mgr.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("kafka")
public class KafkaProperties {
	private String bootstrap;

	public String getBootstrap() {
		return bootstrap;
	}

	public void setBootstrap(String bootstrap) {
		this.bootstrap = bootstrap;
	}
}
