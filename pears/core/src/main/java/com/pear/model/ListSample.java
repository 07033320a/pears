package com.pear.model;

import lombok.Data;

@Data
public class ListSample {

	private Long index;
	private String title;
	private String author;
	private String status;
	private Integer pageviews;
	private String display_time;

	public ListSample() {

	}

	public ListSample(Long index, String title, String author, String status, Integer pageviews, String display_time) {
		this.index = index;
		this.title = title;
		this.author = author;
		this.status = status;
		this.pageviews = pageviews;
		this.display_time = display_time;
	}
}
