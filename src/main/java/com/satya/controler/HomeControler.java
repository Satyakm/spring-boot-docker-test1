package com.satya.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeControler {

	@GetMapping("/home")
	public Map<String,String> helloHome() {
		HashMap<String, String> map = new HashMap<>();
		map.put("msg", "hello world from spring container");
		map.put("version", "v1");
		return map;
	}
}
