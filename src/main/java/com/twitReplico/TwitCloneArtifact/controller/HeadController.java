package com.twitReplico.TwitCloneArtifact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadController {

	@GetMapping("app-name")
	public String fetchAppName() {
		return "Twiter-CLone";
	}
}
