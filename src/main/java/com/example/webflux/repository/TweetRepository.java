package com.example.webflux.repository;

import com.example.webflux.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Boot automatically plugs in an implementation of this interface called SimpleReactiveMongoRepository at runtime.
 */
@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {
}
