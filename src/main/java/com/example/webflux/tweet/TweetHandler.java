package com.example.webflux.tweet;

import com.example.webflux.model.Tweet;
import com.example.webflux.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TweetHandler {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetHandler(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Mono<ServerResponse> createTweet(ServerRequest serverRequest) {
          Mono<Tweet> monoTweet =  serverRequest.bodyToMono(Tweet.class);

          return tweetRepository.insert(monoTweet)
                  .flatMap(tweet -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject(tweet))).next();

    }
}
