package com.redditviewer.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.redditviewer.ui.DisplayFrame;
import com.redditviewer.ui.ImageDisplayer;


public class RedditImageSlideshow {
	private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
	private static final long PERIOD = 5000; // the period between successive executions
	
	public static void main(String[] args) throws IOException {
		ApplicationSettings.init();
		String subreddit = "";
		if(args.length == 0){
			subreddit = getString("Subreddit");
		}
		else{
			subreddit = args[0];
		}
		//println("Subreddit is " + subreddit);
		ImageDisplayer frame = new DisplayFrame();
		frame.init();
		startSlideShow(frame,subreddit);

	}
	
	private static void startSlideShow(ImageDisplayer frame, String subreddit) {
		//Do I need a ScheduledThreadPoolExecutor or TimerTask?
		TimerTask task = new SlideshowTask(frame, subreddit);
//		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
//		exec.scheduleAtFixedRate(task, 0, PERIOD, TimeUnit.MILLISECONDS);
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(task, 0, PERIOD);
	}

	private static String getString(String name)throws IOException {
		print("Please enter ");
		print(name);
		println(":");
		System.out.flush();
		String result = "";
			result = IN.readLine();
		result = result.trim();
		if (result.length() == 0) {
			return "-1";
		}
		return result;
	}
	private static void print(String str) {
		System.out.print(str);
	}
	private static void println(String str) {
		System.out.println(str);
	}

}
