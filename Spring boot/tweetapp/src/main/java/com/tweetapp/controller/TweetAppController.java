package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entity.ReplyTweetMessage;
import com.tweetapp.entity.TweetMessage;
import com.tweetapp.entity.UserRegistration;
import com.tweetapp.service.RegistrationService;
import com.tweetapp.service.TweetMessageService;

@RestController()
@CrossOrigin(origins="http://localhost:3000")
public class TweetAppController {
	@Autowired
	RegistrationService registrationService;
	@Autowired
	TweetMessageService tweetMessage;
	@PostMapping(value ="/register")
	public String saveUserRegistration(@RequestBody UserRegistration registration) throws Exception {
		return registrationService.saveUserRegistration(registration);
		
	}
	@GetMapping(value ="/users/all")
	public List<UserRegistration> getUserRegistration() {
		return registrationService.getAllUser();
		
	}
	@GetMapping(value ="/user/search/{username}")
	public UserRegistration getUser(@PathVariable String username) {
		return registrationService.getUser(username);
		
	}
	@PutMapping(value ="/{username}/resetPassword/{oldPassword}/{newPassword}")
	public String updatePassword(@PathVariable String username,@PathVariable String oldPassword,@PathVariable String newPassword) throws Exception  {
		return registrationService.updatePassword(username, oldPassword, newPassword);
		
	}
	@PutMapping(value ="/{username}/forgetPassword/{newPassword}")
	public String forgetPassword(@PathVariable String username,@PathVariable String newPassword) throws Exception  {
		return registrationService.forgetPassword(username, newPassword);
		
	}
	@GetMapping(value ="/login")
	public String login() {
		return "LoggedIn";
		
	}
	@GetMapping(value ="/all")
	public List<TweetMessage> getAllTweet() {
		return tweetMessage.getAllTweet();
		
	}
	@PostMapping(value ="/{username}/add")
	public String saveTweetMessage(@PathVariable String username,@RequestBody TweetMessage tweet)  {
		return tweetMessage.postTweet(tweet, username);
		
	}
	@GetMapping(value ="/{username}")
	public List<TweetMessage> getUserTweet(@PathVariable String username) {
		return tweetMessage.getUserTweet(username);
		
	}
	@PutMapping(value ="/{username}/update/{id}/{tweet}")
	public String updateTweetMessage(@PathVariable String username,@PathVariable String id,@PathVariable String tweet)  {
		return tweetMessage.updateTweetMessage(username, id, tweet);
		
	}
	@DeleteMapping(value ="/{username}/delete/{id}")
	public String deleteTweetMessage(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.deleteTweetMessage(username, id);
		
	}
	@PostMapping(value ="/reply")
	public String saveReplyTweetMessage(@RequestBody ReplyTweetMessage replyTweetMessage)  {
		return tweetMessage.postReplyTweet(replyTweetMessage);
		
	}
	
	@PutMapping(value ="/{username}/like/{id}")
	public String updateLike(@PathVariable String username,@PathVariable String id)  {
		return tweetMessage.updateLike(username, id);
		
	}
	@GetMapping(value ="/replyTweet/{tweetMessageId}")
	public List<ReplyTweetMessage> getReplyTweet(@PathVariable String tweetMessageId) {
		return tweetMessage.getReplyTweet(tweetMessageId);
		
	}
	
}
