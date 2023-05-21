package com.feedback.system.vo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FeedbackResponse {
	private String name;
    private String description;
    private String likedislike;
    private String file;
    private String customerName;
    private String email;
    private String location;
    private String date;

}
