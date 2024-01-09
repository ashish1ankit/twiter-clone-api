package com.twitReplico.TwitCloneArtifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TwitCloneArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitCloneArtifactApplication.class, args);
	}

}
