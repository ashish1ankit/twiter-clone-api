package com.twitReplico.TwitCloneArtifact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twitReplico.TwitCloneArtifact.entity.MianContent;

public interface  HeaderRepository extends MongoRepository<MianContent, String> {

}
