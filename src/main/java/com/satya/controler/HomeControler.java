package com.satya.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.service.HomeService;

@RestController
@RequestMapping("/")
public class HomeControler {

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public HomeControler(HomeService homeService) {
		super();
		this.homeService = homeService;
	}

	@GetMapping("/home")
	public Map<String, String> helloHome() {
		return homeService.getHomeValue();
	}

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
