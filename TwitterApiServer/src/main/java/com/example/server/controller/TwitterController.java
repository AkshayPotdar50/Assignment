package com.example.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.configuration.TwitterConfig;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@RestController
@RequestMapping("/api")
public class TwitterController {
	@Autowired
	private TwitterConfig twitterConfig;
    
	
	@GetMapping("/search-tweets")
	public ResponseEntity<List<Status>> searchTweets(@RequestParam String query) throws TwitterException{
		Twitter twitter=new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(twitterConfig.getConsumerKey(), twitterConfig.getConsumerSecret());
		AccessToken accessToken =new AccessToken(twitterConfig.getAccessToken(), twitterConfig.getAccessTokenSecret());
		twitter.setOAuthAccessToken(accessToken);
		QueryResult result=twitter.search(new Query (query));
		List<Status> tweets=result.getTweets();
		
		return ResponseEntity.ok(tweets);
		
	}
	@GetMapping("/get-tweets")
	public ResponseEntity<List<Status>> getTweets(@RequestParam String screenName) throws TwitterException{
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(twitterConfig.getConsumerKey(), twitterConfig.getConsumerSecret());
		AccessToken accessToken =new AccessToken(twitterConfig.getAccessToken(), twitterConfig.getAccessTokenSecret());
		twitter.setOAuthAccessToken(accessToken);
		List<Status> tweets=twitter.getUserTimeline(screenName);
		
		return ResponseEntity.ok(tweets);
		
	}

}
