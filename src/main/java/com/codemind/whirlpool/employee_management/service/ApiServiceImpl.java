package com.codemind.whirlpool.employee_management.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codemind.whirlpool.employee_management.dto.Comment;
import com.codemind.whirlpool.employee_management.dto.Post;

@Service
public class ApiServiceImpl {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	// F1
	public String getE1(int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/{id}";
		String response = restTemplate.getForObject(url, String.class, id);
		log.info(response);
		return response;
	}

	// F1
	public Post getE2(int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/{id}";
		Post response = restTemplate.getForObject(url, Post.class, id);
		log.info("The Object response :: {}", response);
		return response;
	}

	// F1
	public Post getE3(int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/{id}";
		ResponseEntity<Post> response = restTemplate.getForEntity(url, Post.class, id);
		log.info("The Object response :: {}", response.getBody());
		return response.getBody();
	}

	// F1
	public Post getE4(int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/{id}";
		ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.GET, null, Post.class, id);
		return response.getBody();
	}

	// F2: List of Information
	public List<Post> getE5() {
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
		Post[] postArray = response.getBody();
		List<Post> posts = Arrays.asList(postArray);
		return posts;
	}

	// F3: List of Comments Information
	public List<Comment> getE6(int postid) {
		String url = "https://jsonplaceholder.typicode.com/comments?postId={postid}";
		ResponseEntity<Comment[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Comment[].class, postid);
		Comment[] commentsArray = response.getBody();
		List<Comment> comments = Arrays.asList(commentsArray);
		return comments;
	}

	// F4: POST
	public Post getE7(int postid) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		Post post = new Post(1, "Velocity", "First Message");
		// ResponseEntity<Post> response = restTemplate.exchange(url,post
		// ,HttpMethod.POST, null, Post.class);
		ResponseEntity<Post> response = restTemplate.postForEntity(url, post, Post.class);
		Post data = response.getBody();
		return data;
	}

	// F5: POST
	public Post getE8(int postid) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		Post post = new Post(1, "Velocity-exchange", "Second Message");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Post> httpEntity = new HttpEntity<>(post, headers);

		ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Post.class);

		Post data = response.getBody();
		return data;
	}

}
