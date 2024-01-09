package com.twitReplico.TwitCloneArtifact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.service.HeaderService;

@RequestMapping("twit-clone")
@RestController
public class HeadController {

@Autowired
private HeaderService headerService;
	
	@GetMapping("app-name")
	public String fetchAppName() {
		return "Twiter-CLone";
	}
	
	@PostMapping("add-post")
	public String insertPost(@RequestBody MianContent content ) {
		headerService.addPost(content);
		return "Added success";
	}
}
