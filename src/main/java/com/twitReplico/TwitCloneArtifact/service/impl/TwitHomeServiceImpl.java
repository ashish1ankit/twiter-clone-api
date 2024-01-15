package com.twitReplico.TwitCloneArtifact.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.model.LargePostDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.ShortsNewDetailsDto;
import com.twitReplico.TwitCloneArtifact.repository.TwitHomeRepository;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@Service
public class TwitHomeServiceImpl implements TwitHomeService {

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	TwitHomeRepository twitHomeRepository;

	List<MianContentDto> list = new ArrayList<MianContentDto>();

	@Override
	public String postFeedContent(List<MianContentDto> content) {
		// TODO Auto-generated method stub
		List<MianContent> mianContent = new ArrayList<>();
		for (MianContentDto contentDto : content) {
			UUID uuid = UUID.randomUUID();

			mianContent.add(MianContent.builder().id(uuid.toString()).postMessage(contentDto.getPostMessage())
					.userHandle(contentDto.getUserHandle()).userId(contentDto.getUserId())
					.userName(contentDto.getUserName()).build());
		}
		twitHomeRepository.saveAll(mianContent);
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
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").regex(unName, "i"));

		List<MianContent> finList = mongoTemplate.find(query, MianContent.class, "Users");
		if (!finList.isEmpty()) {
			for (MianContent dto : finList) {
				ShortUserInfoDetailsDto detailsDto = ShortUserInfoDetailsDto.builder().userHandle(dto.getUserHandle())
						.userId(dto.getUserId()).userName(dto.getUserName()).build();
				detailsDtos.add(detailsDto);
			}

		}
		return detailsDtos;
	}

	@Override
	public String onSubscribe(MianContentDto content) {
		// TODO Auto-generated method stub
		return "Successfully subscribed!";
	}

	@Override
	public List<ShortUserInfoDetailsDto> fetchAllRecomendedUserDetails(String unName) {
		return fetchAnyUserShortDetails(unName);
	}

	@Override
	public String followedUserByUserId(String userIdOwn, String userIdOther) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShortsNewDetailsDto> fetchAllRecomendedUserNews(String userIdOwn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LargePostDetailsDto> fetchAllRecomendedUserPosts(String userIdOwn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long fetchAllRecomendedUserPostsCount(String userIdOwn) {
		// TODO Auto-generated method stub
		return 1l;
	}

}
