package com.twitReplico.TwitCloneArtifact.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("MianContent")
public class MianContent {

	@Column
	Long userId;
	
	@Column
	String postMessage;
	
}
