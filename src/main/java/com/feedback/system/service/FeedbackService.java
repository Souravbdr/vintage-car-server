package com.feedback.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feedback.system.model.FeedbackModel;
import com.feedback.system.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	private FeedbackRepository feedbackRepository;
	
	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}
	
	public FeedbackModel insertFeedback(FeedbackModel feedbackModel) {
		feedbackRepository.save(feedbackModel);
		return feedbackModel;
	}
	
	public List<FeedbackModel> getAllFeedback(){
		return feedbackRepository.findAll();
	}

}
