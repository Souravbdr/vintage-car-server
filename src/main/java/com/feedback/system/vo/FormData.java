package com.feedback.system.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FormData {
	
	private String name;
	private String description;
	private String likedislike;
	private MultipartFile attachment;
	private String customername;
	private String email;
}
