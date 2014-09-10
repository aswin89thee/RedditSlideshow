package com.redditviewer.ui;
import java.io.IOException;
import java.net.MalformedURLException;

public interface ImageDisplayer {
	void init();
	void setImage(String uri) throws MalformedURLException, IOException;
}
