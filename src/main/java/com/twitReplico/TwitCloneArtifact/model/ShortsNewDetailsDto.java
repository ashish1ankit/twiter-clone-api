package com.twitReplico.TwitCloneArtifact.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortsNewDetailsDto {
	
	private Long slId;

	private Long newsId;
	
	private Long newsUserId;
	
	private String newsTitle;
	
	private String newsDesc;
	
	private String imageUrl;

}
