package application.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Images {
	
	public static ImageIcon exit = new ImageIcon(" ");
	public static ImageIcon close = new ImageIcon(" ");
	public static ImageIcon exitSmall = getScaledImageIcon(exit, 15, 15);
	public static ImageIcon _new = new ImageIcon(" ");
	public static ImageIcon open = new ImageIcon(" ");
	public static ImageIcon save = new ImageIcon(" ");
	public static ImageIcon play = new ImageIcon(" ");
	public static ImageIcon pause = new ImageIcon(" ");
	public static ImageIcon stop = new ImageIcon(" ");
    
//    static ImageIcon IC = new ImageIcon("images/ic.png");
	public static ImageIcon IC = getScaledImageIcon(new ImageIcon(" "), 150, 150);

	private static ImageIcon getScaledImageIcon(ImageIcon srcIcon, float _w, float _h) {
		float y = srcIcon.getIconHeight();
	    float x = srcIcon.getIconWidth();
	    
	    float zoomX = _w/x;
	    float zoomY = _h/y;
	    float zoom;
	    if(zoomX>zoomY)
	        zoom = zoomY;
	    else zoom = zoomX;
	    
	    int w = (int) (zoom * x);
	    int h = (int) (zoom * y);
	    
	    Image srcImg = srcIcon.getImage();
	
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h,Color.WHITE, null);
	    g2.dispose();
	    return new ImageIcon(resizedImg);
	}
	
	private static Image getScaledImage(Image srcImg, int w, int h) {
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}

}
