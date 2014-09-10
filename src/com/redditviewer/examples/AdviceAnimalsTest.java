package com.redditviewer.examples;

import java.util.List;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

public class AdviceAnimalsTest {
	
	private static final String SUBREDDIT = "AdviceAnimals";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestClient restClient = new HttpRestClient();
		Submissions subms = new Submissions(restClient);
		List<Submission> submissionsSubreddit = subms.ofSubreddit(SUBREDDIT, SubmissionSort.TOP, -1, 10, null, null, true);
		for(Submission post : submissionsSubreddit){
			String title = post.getTitle();
			String url = post.getUrl();
			System.out.println(title);
			System.out.println(url);
			System.out.println();
		}
	}

}
