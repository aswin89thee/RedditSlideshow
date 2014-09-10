package com.redditviewer.service;

import java.util.List;
import java.util.Map;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

public class RedditImageService implements ImageService {
	public static final String SUBREDDIT_PARAM = "subreddit";
	private final int LIMIT = 200;
	private RestClient restClient = null;
	private String subreddit = null;
	private Submissions submissions = null;
	List<Submission> posts = null;
	
	private int count = 0;

	@Override
	synchronized public String getNextImageUrl() {
		String url = "";
		if(count == 0 || count >= LIMIT){
			posts = submissions.ofSubreddit(subreddit, SubmissionSort.TOP, -1, LIMIT, null, null, true);
			count = 1;
		}
		count++;
		Submission curPost = posts.get(count);
		if(curPost != null){
			url = posts.get(count).getUrl();
		}
		return url;
	}

	@Override
	public void initialize(Map<String,String> params) throws Exception {
		restClient = new HttpRestClient();
		if(params != null && params.keySet().size() > 0){
			subreddit = params.get(SUBREDDIT_PARAM);
		}
		submissions = new Submissions(restClient);
	}

}
