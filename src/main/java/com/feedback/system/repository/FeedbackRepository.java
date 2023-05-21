package com.feedback.system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feedback.system.model.FeedbackModel;

public interface FeedbackRepository extends MongoRepository<FeedbackModel, String> {
	
}
