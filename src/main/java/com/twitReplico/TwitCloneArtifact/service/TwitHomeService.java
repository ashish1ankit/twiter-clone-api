package com.twitReplico.TwitCloneArtifact.service;

import java.util.List;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;

public interface TwitHomeService{


	String postFeedContent(MianContentDto content);

	List<MianContentDto> fetchAllPostDetails();

}
