package com.redditviewer.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import com.redditviewer.service.ImageService;
import com.redditviewer.service.RedditImageService;
import com.redditviewer.ui.ImageDisplayer;

public class SlideshowTask extends TimerTask {
	
	private ImageDisplayer frame = null;
	private String subreddit = "";
	ImageService service = null;
	
	public SlideshowTask(ImageDisplayer frame, String subreddit){
		this.frame = frame;
		this.subreddit = subreddit;
		init();
	}
	
	private void init(){
		service = new RedditImageService();
		Map<String,String> params = new HashMap<String,String>();
		params.put(RedditImageService.SUBREDDIT_PARAM, subreddit);
		try {
			service.initialize(params);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Inside run of TimerTask SlideshowTask");
		String nextUrl = "";
		
		//Logic to get the image from the next post
		nextUrl = service.getNextImageUrl();
		
		//Display the image in the frame
		try {
			frame.setImage(nextUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
