package com.redditviewer.utils;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static Image getImageFromUrl(String url) throws MalformedURLException, IOException{
		Image img = null;
		img = ImageIO.read(new URL(url));
		return img;
	}

}
