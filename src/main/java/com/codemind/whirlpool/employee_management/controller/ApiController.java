package com.codemind.whirlpool.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.whirlpool.employee_management.dto.Comment;
import com.codemind.whirlpool.employee_management.dto.Post;
import com.codemind.whirlpool.employee_management.dto.RewardData;
import com.codemind.whirlpool.employee_management.service.ApiServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ApiServiceImpl apiServiceImpl;

	@GetMapping("/v1/G/{id}")
	public ResponseEntity<Post> fetchData(@PathVariable int id) {
		Post response = apiServiceImpl.getE2(id);
		return new ResponseEntity<Post>(response, HttpStatus.OK);
	}

	@GetMapping("/v1/bank/{id}")
	public ResponseEntity<RewardData> fetchData(@PathVariable long id) {
		RewardData response = apiServiceImpl.getCradDetails(id);
		return new ResponseEntity<RewardData>(response, HttpStatus.OK);
	}

	@GetMapping("/v1/G/")
	public ResponseEntity<List<Post>> fetchData() {
		List<Post> response = apiServiceImpl.getE5();
		return new ResponseEntity<List<Post>>(response, HttpStatus.OK);
	}

	@GetMapping("/v1/G/C/{id}")
	public ResponseEntity<List<Comment>> fetchData1(@PathVariable int id) {
		List<Comment> response = apiServiceImpl.getE6(id);
		return new ResponseEntity<List<Comment>>(response, HttpStatus.OK);
	}

	@PostMapping("/v1/P/{id}")
	public ResponseEntity<Post> fetchData2(@PathVariable int id) {
		Post response = apiServiceImpl.getE8(id);
		return new ResponseEntity<Post>(response, HttpStatus.OK);
	}

	@PutMapping("/v1/P/{id}")
	public ResponseEntity<Void> fetchData3(@PathVariable int id, @RequestBody Post post) {
		apiServiceImpl.getE9(id, post);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
