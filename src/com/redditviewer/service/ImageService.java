package com.redditviewer.service;

import java.util.Map;

public interface ImageService {
	public void initialize(Map<String,String> params) throws Exception;
	public String getNextImageUrl();
}
