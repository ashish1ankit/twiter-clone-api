package com.twitReplico.TwitCloneArtifact.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@Service
public class TwitHomeServiceImpl implements TwitHomeService{

	@Autowired
	MongoClient mongoClient;
	
	List<MianContentDto> list = new ArrayList<MianContentDto>();

	@Override
	public String postFeedContent(MianContentDto content) {
		// TODO Auto-generated method stub
		list.add(content);
		return "Content posted SUccessfully";
		
	}

	@Override
	public List<MianContentDto> fetchAllPostDetails() {
		// TODO Auto-generated method stub
		return list;
	}

}
