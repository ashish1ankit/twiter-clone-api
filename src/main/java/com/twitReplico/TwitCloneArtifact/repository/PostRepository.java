package com.twitReplico.TwitCloneArtifact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.twitReplico.TwitCloneArtifact.entity.MianContent;
import com.twitReplico.TwitCloneArtifact.entity.PostDetails;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface  PostRepository extends MongoRepository<PostDetails, String> {

}
