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

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@RequestMapping("twit-clone")
@RestController
public class TwitHomeController {

@Autowired
private TwitHomeService homeService;
	
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
}
