package com.laptrinhweb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {

	@GetMapping("/api/test")
	public ResponseEntity<String> testSpringboot(){
		return ResponseEntity.ok("Suscess");
	}
}
