package com.twitReplico.TwitCloneArtifact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@RequestMapping("twit-clone")
@RestController
public class TwitHomeController {

@Autowired
private TwitHomeService homeService;
	
	@GetMapping("get-All-post")
	public List<MianContentDto> fetchAllPostDetails() {
		List<MianContentDto> contents=homeService.fetchAllPostDetails();
		return contents;
	}
	
	@PostMapping("add-post")
	public String postFeedContent(@RequestBody MianContentDto content ) {
		String message=	homeService.postFeedContent(content);
		return message;
	}
}