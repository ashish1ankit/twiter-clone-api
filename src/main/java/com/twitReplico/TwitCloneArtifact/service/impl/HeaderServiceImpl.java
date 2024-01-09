package com.twitReplico.TwitCloneArtifact.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.service.HeaderService;

@Service
public class HeaderServiceImpl implements HeaderService{

	@Autowired
	MongoClient mongoClient;
	
	@Override
	public String addPost(MianContent content) {
		MianContent mianContent = new MianContent();
//		mianContent.s
//		mongoClient.
		return null;
	}

}
