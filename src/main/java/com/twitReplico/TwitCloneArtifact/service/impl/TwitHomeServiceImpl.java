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
import com.twitReplico.TwitCloneArtifact.entity.PostDetails;
import com.twitReplico.TwitCloneArtifact.model.LargePostDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.MianContentDto;
import com.twitReplico.TwitCloneArtifact.model.ShortUserInfoDetailsDto;
import com.twitReplico.TwitCloneArtifact.model.ShortsNewDetailsDto;
import com.twitReplico.TwitCloneArtifact.repository.PostRepository;
import com.twitReplico.TwitCloneArtifact.repository.UserRepository;
import com.twitReplico.TwitCloneArtifact.service.TwitHomeService;

@Service
public class TwitHomeServiceImpl implements TwitHomeService {

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	List<MianContentDto> list = new ArrayList<MianContentDto>();

	@Override
	public String postFeedContent(List<LargePostDetailsDto> content) {
		List<PostDetails> postDetails = new ArrayList<>();
		for (LargePostDetailsDto contentDto : content) {
			UUID uuid = UUID.randomUUID();

			postDetails.add(PostDetails.builder().postId(uuid.toString()).postDesc(contentDto.getPostDesc())
					.postImageUrlList(contentDto.getPostImageUrlList()).postTitle(contentDto.getPostTitle())
					.postUserId(contentDto.getPostUserId()).postUserName(contentDto.getPostUserName()).build());
		}
		postRepository.saveAll(postDetails);
		return "Content posted SUccessfully";

	}

	@Override
	public List<LargePostDetailsDto> fetchAllPostDetails() {
		List<LargePostDetailsDto> postDetails = new ArrayList<>();
		Query query = new Query();
//		query.addCriteria(Criteria.where("userName").regex(unName, "i"));

		List<PostDetails> finList = mongoTemplate.find(query, PostDetails.class, "Posts");
		if (!finList.isEmpty()) {
			for (PostDetails dto : finList) {
				postDetails.add(LargePostDetailsDto.builder().postId(dto.toString()).postDesc(dto.getPostDesc())
						.postImageUrlList(dto.getPostImageUrlList()).postTitle(dto.getPostTitle())
						.postUserId(dto.getPostUserId()).postUserName(dto.getPostUserName()).build());
			}

		}
		return postDetails;
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

	@Override
	public Boolean fetchUserPrimeStatus(String userId) {
		Boolean status = false;
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userId).where("primeMarker").is(true));

		List<MianContent> finList = mongoTemplate.find(query, MianContent.class, "Users");
		if (!finList.isEmpty())
			status = true;
		return status;
	}
	
	@Override
	public String postUserDetails(List<MianContentDto> content) {
		List<MianContent> mianContents = new ArrayList<>();
		for (MianContentDto contentDto : content) {
			UUID uuid = UUID.randomUUID();

			mianContents.add(MianContent.builder().primeMarker(contentDto.getPrimeMarker())
					.userHandle(contentDto.getUserHandle()).userId(contentDto.getUserId())
					.userImgUrl(contentDto.getUserImgUrl()).userName(contentDto.getUserName()).build());
		}
		userRepository.saveAll(mianContents);
		return "Content added Successfully";

	}

}
