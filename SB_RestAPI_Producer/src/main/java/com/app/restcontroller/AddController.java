package com.app.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddController {

	@PostMapping("/{a}/{b}")
	public ResponseEntity<String> add(@PathVariable("a") Integer a,@PathVariable("b") Integer b)
	{
		int sum=a+b;
		return ResponseEntity.ok(" Sum is : "+ sum);
	}
}
