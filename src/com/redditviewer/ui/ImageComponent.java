package com.redditviewer.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import com.redditviewer.utils.ImageUtils;

class ImageComponent extends JComponent{
	private static final long serialVersionUID = 198765168735L;
	private Image image;
	public ImageComponent(){
	}

	public ImageComponent(String url)
	{
		try{
			image = ImageIO.read(new URL(url));
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	void setImage(String url) throws MalformedURLException, IOException
	{
			image = ImageUtils.getImageFromUrl(url);
	}

	public void paintComponent (Graphics g){
		if(image == null) return;		
		//Fit image to the screen
		int type = ((BufferedImage)(image)).getType() == 0? BufferedImage.TYPE_INT_ARGB : ((BufferedImage)(image)).getType();
		BufferedImage resizeImageJpg = resizeImage(((BufferedImage)(image)), type);

		g.drawImage(resizeImageJpg, 0, 0, this);
	}
	
	private BufferedImage resizeImage(BufferedImage img, int type){
		int IMG_WIDTH = this.getWidth();
		int IMG_HEIGHT = this.getHeight();

		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		
		//Scale the image but maintain the aspect ratio
		if(img.getWidth() > img.getHeight())
			g.drawImage(img.getScaledInstance(IMG_WIDTH, -1, Image. SCALE_SMOOTH), 0, 0, this);
		else
		{
			int x = (IMG_WIDTH - img.getWidth(null)) / 2;
			int y = (IMG_HEIGHT - img.getHeight(null)) / 2;
			g.drawImage(img.getScaledInstance(-1, IMG_HEIGHT, Image. SCALE_SMOOTH), x, y, this);
		}
		
		g.dispose();

		return resizedImage;
	}
}