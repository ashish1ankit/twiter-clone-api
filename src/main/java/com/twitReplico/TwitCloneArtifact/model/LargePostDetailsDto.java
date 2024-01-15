package com.twitReplico.TwitCloneArtifact.model;

import java.util.List;

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
public class LargePostDetailsDto {

	private Long slId;

	private Long postId;

	private Long postUserId;
	private String postUserName;

	private Boolean postPrimeMarker;
	
	private String postUserImageUrl;

	private String postTitle;

	private String postDesc;

	private List<String> postImageUrlList[];

}
