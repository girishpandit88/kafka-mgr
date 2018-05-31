package kafka.mgr.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.retry.annotation.CircuitBreaker;
import kafka.mgr.service.KafkaManager;

import javax.inject.Inject;

@Controller("/hello")
@CircuitBreaker(attempts = "5")
public class TopicController {
	@Inject
	KafkaManager kafkaManager;

	@Get("/topics")
	public HttpResponse getTopics() {
		return HttpResponse.ok(kafkaManager.getTopics());
	}

	@Get("/topics/{topicId}")
	public HttpResponse getTopicDetails(String topicId) {
		return HttpResponse.ok(kafkaManager.getTopicDetails(topicId));
	}

	@Get("/topics/details")
	public HttpResponse getAllTopicsDetails() {
		return HttpResponse.ok(kafkaManager.getTopicDetails(kafkaManager.getTopics()));
	}
}
