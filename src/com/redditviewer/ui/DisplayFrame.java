package com.redditviewer.ui;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;



public class DisplayFrame extends JFrame implements ImageDisplayer {

	private static final long serialVersionUID = 18635487934L;
	public static final int DEFAULT_WIDTH = 1024;
	public static final int DEFAULT_HEIGHT = 700;
	ImageComponent component;

	@Override
	public void init() {
		setTitle("Slideshow");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		component = new ImageComponent();
		add(component);
		pack();
		this.setVisible(true);
	}

	@Override
	public void setImage(String url) throws MalformedURLException, IOException {
		component.setImage(url);
		repaint();
	}


}
