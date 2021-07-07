package com.alibaba.cloud.examples.controller;

import com.alibaba.cloud.examples.service.EchoService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {
	@Resource
	private RestTemplate restTemplate;
	@Resource
	private RestTemplate restTemplate1;
	@Resource
	private EchoService echoService;
	@Resource
	private DiscoveryClient discoveryClient;

	private final String SERVICE_PROVIDER = "http://service-provider";

	@GetMapping(value = "/echo-rest/{str}")
	public String rest(@PathVariable String str) {
		return restTemplate.getForObject(SERVICE_PROVIDER + "/echo/" + str, String.class);
	}

	@GetMapping(value = "/index")
	public String index() {
		return restTemplate1.getForObject(SERVICE_PROVIDER, String.class);
	}

	@GetMapping(value = "/test")
	public String test() {
		return restTemplate1.getForObject(SERVICE_PROVIDER + "/test", String.class);
	}

	@GetMapping(value = "/sleep")
	public String sleep() {
		return restTemplate1.getForObject(SERVICE_PROVIDER + "/sleep", String.class);
	}

	@GetMapping(value = "/notFound-feign")
	public String notFound() {
		return echoService.notFound();
	}

	@GetMapping(value = "/divide-feign")
	public String divide(@RequestParam Integer a, @RequestParam Integer b) {
		return echoService.divide(a, b);
	}

	@GetMapping(value = "/divide-feign2")
	public String divide(@RequestParam Integer a) {
		return echoService.divide(a);
	}

	@GetMapping(value = "/echo-feign/{str}")
	public String feign(@PathVariable String str) {
		return echoService.echo(str);
	}

	@GetMapping(value = "/services/{service}")
	public Object client(@PathVariable String service) {
		return discoveryClient.getInstances(service);
	}

	@GetMapping(value = "/services")
	public Object services() {
		return discoveryClient.getServices();
	}

}
