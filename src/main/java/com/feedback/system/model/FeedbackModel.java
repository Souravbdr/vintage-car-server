package com.feedback.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class FeedbackModel {

	@Id
	private String Id;
	private String title;
	private String description;
	private String likeDislike;

	@Field("image_data")
	private byte[] imageData;

	private String submitterName;
	private String submitterEmail;
	private String location;
	private String date;
}
