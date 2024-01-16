package com.twitReplico.TwitCloneArtifact.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Document("Users")
public class MianContent {

	@GeneratedValue
	@Column
	private String userId;

	@Column
	private String userImgUrl;

	@Column
	private String userHandle;

	@Column
	private String userName;
	@Column
	private Boolean primeMarker;

}
