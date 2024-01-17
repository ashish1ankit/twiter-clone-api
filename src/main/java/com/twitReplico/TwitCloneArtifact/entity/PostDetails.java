package com.twitReplico.TwitCloneArtifact.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document("Posts")
public class PostDetails {

	private Long slId;

	private String postId;

	private String postUserId;
	private String postUserName;

	private Boolean postPrimeMarker;

	private String postUserImageUrl;

	private String postTitle;

	private String postDesc;

	private List<String> postImageUrlList[];

}
