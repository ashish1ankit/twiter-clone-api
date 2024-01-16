package com.twitReplico.TwitCloneArtifact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.LargePostDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.ShortsNewDetailsDto;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@RequestMapping("main-page-header")
@RestController
public class TwitHomeController {

@Autowired
private TwitHomeService homeService;
	
@Autowired
MongoClient mongoClient;

	@GetMapping("get-All-post")
	public ResponseEntity<List<MianContentDto>> fetchAllPostDetails() {
		List<MianContentDto> contents=homeService.fetchAllPostDetails();
		return new ResponseEntity<List<MianContentDto>> (contents, HttpStatus.OK);
	}
	
	@PostMapping("add-post")
	public ResponseEntity<String> postFeedContent(@RequestBody  List<MianContentDto> content ) {
		String message=	homeService.postFeedContent(content);
		return new ResponseEntity<String>(message, HttpStatus.OK)  ;
	}
	
	@GetMapping("search-any")
	public ResponseEntity<List<ShortUserInfoDetailsDto>> fetchAnyUserShortDetails(@RequestParam String unName) {
		List<ShortUserInfoDetailsDto> contents=homeService.fetchAnyUserShortDetails(unName);
		return new ResponseEntity<List<ShortUserInfoDetailsDto>> (contents, HttpStatus.OK);
	}
	
	@PostMapping("on-subscribe")
	public ResponseEntity<String> onSubscribe(@RequestBody  MianContentDto content ) {
		String message=	homeService.onSubscribe(content);
		return new ResponseEntity<String>(message, HttpStatus.OK)  ;
	}
	
	@GetMapping("recomended-users")
	public ResponseEntity<List<ShortUserInfoDetailsDto>> fetchAllRecomendedUserDetails(@RequestParam String unName) {
		List<ShortUserInfoDetailsDto> contents=homeService.fetchAllRecomendedUserDetails(unName);
		return new ResponseEntity<List<ShortUserInfoDetailsDto>> (contents, HttpStatus.OK);
	}
	
	@PostMapping("follow-user")
	public ResponseEntity<String> followUserByUserId(@RequestParam String userIdOwn,@RequestParam String userIdOther) {
		String message=	homeService.followedUserByUserId(userIdOwn,userIdOther);
		return new ResponseEntity<String>(message, HttpStatus.OK)  ;
	}
	
	@GetMapping("recomended-news-userid")
	public ResponseEntity<List<ShortsNewDetailsDto>> fetchAllRecomendedUserNews(@RequestParam String userIdOwn) {
		List<ShortsNewDetailsDto> contents=homeService.fetchAllRecomendedUserNews(userIdOwn);
		return new ResponseEntity<List<ShortsNewDetailsDto>> (contents, HttpStatus.OK);
	}
	
	@GetMapping("recomended-posts-userid")
	public ResponseEntity<List<LargePostDetailsDto>> fetchAllRecomendedUserPosts(@RequestParam String userIdOwn) {
		List<LargePostDetailsDto> contents=homeService.fetchAllRecomendedUserPosts(userIdOwn);
		return new ResponseEntity<List<LargePostDetailsDto>> (contents, HttpStatus.OK);
	}
	
	@GetMapping("recomended-user-post-count")
	public ResponseEntity<Long> fetchAllRecomendedUserPostsCount(@RequestParam String userIdOwn) {
		Long count=homeService.fetchAllRecomendedUserPostsCount(userIdOwn);
		return new ResponseEntity<Long> (count, HttpStatus.OK);
	}
	
//	@GetMapping("databse-name")
//	public ResponseEntity<String> fetchDatabseName() {
//		String name=mongoClient.get;
//		return new ResponseEntity<String> (name, HttpStatus.OK);
//	}
	
}
