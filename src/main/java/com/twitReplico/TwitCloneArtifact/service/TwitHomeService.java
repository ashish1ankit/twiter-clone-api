package com.twitReplico.TwitCloneArtifact.service;

import java.util.List;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.LargePostDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.ShortsNewDetailsDto;

public interface TwitHomeService{



	List<LargePostDetailsDto> fetchAllPostDetails();

	String postFeedContent(List<LargePostDetailsDto> content);

	List<ShortUserInfoDetailsDto> fetchAnyUserShortDetails(String unName);

	String onSubscribe(MianContentDto content);

	List<ShortUserInfoDetailsDto> fetchAllRecomendedUserDetails(String unName);

	String followedUserByUserId(String userIdOwn, String userIdOther);

	List<ShortsNewDetailsDto> fetchAllRecomendedUserNews(String userIdOwn);

	List<LargePostDetailsDto> fetchAllRecomendedUserPosts(String userIdOwn);

	Long fetchAllRecomendedUserPostsCount(String userIdOwn);

	Boolean fetchUserPrimeStatus(String userId);

	String postUserDetails(List<MianContentDto> content);

}
