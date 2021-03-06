package com.alibaba.cloud.examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumerReactiveApplication {

	@Bean
	@LoadBalanced
	public WebClient.Builder webClient() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerReactiveApplication.class, args);
	}

	@RestController
	class MyController {

		@Autowired
		private ReactiveDiscoveryClient reactiveDiscoveryClient;

		@Autowired
		private WebClient.Builder webClientBuilder;

		@GetMapping("/all-services")
		public Flux<String> allServices() {
			return reactiveDiscoveryClient.getInstances("service-provider")
					.map(serviceInstance -> serviceInstance.getHost() + ":"
							+ serviceInstance.getPort());
		}

		@GetMapping("/service-call/{name}")
		public Mono<String> serviceCall(@PathVariable("name") String name) {
			return webClientBuilder.build().get()
					.uri("http://service-provider/echo/" + name).retrieve()
					.bodyToMono(String.class);
		}

	}

}
