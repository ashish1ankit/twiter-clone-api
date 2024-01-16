package com.twitReplico.TwitCloneArtifact.service;

import java.util.List;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;

public interface TwitHomeService{



	List<MianContentDto> fetchAllPostDetails();

	String postFeedContent(List<MianContentDto> content);

	List<ShortUserInfoDetailsDto> fetchAnyUserShortDetails(String unName);

}
