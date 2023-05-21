package com.feedback.system.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.feedback.system.model.FeedbackModel;
import com.feedback.system.service.FeedbackService;
import com.feedback.system.vo.FeedbackResponse;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	private FeedbackService feedbackService;

	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestParam("name") String title,
			@RequestParam("description") String description, @RequestParam("attachment") MultipartFile attachment,
			@RequestParam("likedislike") String likedislike, @RequestParam("customername") String customername,
			@RequestParam("email") String email, @RequestParam("location") String location) throws IOException {
		System.out.println("insertion started");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = dateFormat.format(new Date());
		FeedbackModel feedbackModel = new FeedbackModel();
		feedbackModel.setTitle(title);
		feedbackModel.setDescription(description);
		feedbackModel.setImageData(attachment.getBytes());
		feedbackModel.setLikeDislike(likedislike);
		feedbackModel.setSubmitterName(customername);
		feedbackModel.setSubmitterEmail(email);
		feedbackModel.setLocation(location);
		feedbackModel.setDate(dateString);
		feedbackService.insertFeedback(feedbackModel);
		return ResponseEntity.ok("Success");
	}

	@GetMapping("/all")
	public List<FeedbackResponse> getAllFeedback() {
		System.out.println("getting responses");
		List<FeedbackModel> feedbackList = feedbackService.getAllFeedback();
		List<FeedbackResponse> responseList = new ArrayList<>();

		for (FeedbackModel feedback : feedbackList) {
			FeedbackResponse response = new FeedbackResponse();
			response.setName(feedback.getTitle());
			response.setDescription(feedback.getDescription());
			response.setFile(Base64.getEncoder().encodeToString(feedback.getImageData()));
			response.setLikedislike(feedback.getLikeDislike());
			response.setCustomerName(feedback.getSubmitterName());
			response.setEmail(feedback.getSubmitterEmail());
			response.setLocation(feedback.getLocation());
			response.setDate(feedback.getDate());
			responseList.add(response);
		}

		return responseList;
	}
}
