package com.twitReplico.TwitCloneArtifact.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@Service
public class TwitHomeServiceImpl implements TwitHomeService{

	@Autowired
	MongoClient mongoClient;
	
	List<MianContentDto> list = new ArrayList<MianContentDto>();

	@Override
	public String postFeedContent( List<MianContentDto> content) {
		// TODO Auto-generated method stub
		list.addAll(content);
		return "Content posted SUccessfully";
		
	}

	@Override
	public List<MianContentDto> fetchAllPostDetails() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<ShortUserInfoDetailsDto> fetchAnyUserShortDetails(String unName) {
		List<ShortUserInfoDetailsDto> detailsDtos = new ArrayList<>();
		List<MianContentDto> finList = list.stream().filter(user -> user.getUserName().equalsIgnoreCase(unName))
				.collect(Collectors.toList());
		if (!finList.isEmpty()) {
			for (MianContentDto dto : finList) {
				ShortUserInfoDetailsDto detailsDto = ShortUserInfoDetailsDto.builder().userHandle(dto.getUserHandle())
						.userId(dto.getUserId()).userName(dto.getUserName()).build();
				detailsDtos.add(detailsDto);
			}

		}
		return detailsDtos;
	}

}
