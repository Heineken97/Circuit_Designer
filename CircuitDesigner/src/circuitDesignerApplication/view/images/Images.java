package circuitDesignerApplication.view.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Images {
	private static ImageIcon AND = new ImageIcon("view/images/AND.png");
	private static ImageIcon NAND = new ImageIcon("view/images/NAND.png");
	private static ImageIcon NOR = new ImageIcon("view/images/NOR.png");
	private static ImageIcon NOT = new ImageIcon("view/images/NOT.png");
	private static ImageIcon OR = new ImageIcon("view/images/OR.png");
	private static ImageIcon XNOR = new ImageIcon("view/images/XNOR.png");
	private static ImageIcon XOR = new ImageIcon("view/images/XOR.png");
	
	private static ImageIcon getScaledImageIcon(ImageIcon srcIcon, float _w, float _h) {
		float y = srcIcon.getIconHeight();
		float x = srcIcon.getIconWidth();
		
		float zoomX = _w/x;
		float zoomY = _h/y;
		float zoom;
		if(zoomX>zoomY) {
			zoom = zoomY;
		}else {
			zoom = zoomX;
		}
		
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

	public static ImageIcon getAND() {
		return AND;
	}
	public static ImageIcon getNAND() {
		return NAND;
	}
	public static ImageIcon getNOR() {
		return NOR;
	}
	public static ImageIcon getNOT() {
		return NOT;
	}
	public static ImageIcon getOR() {
		return OR;
	}
	public static ImageIcon getXNOR() {
		return XNOR;
	}
	public static ImageIcon getXOR() {
		return XOR;
	}
	public static void setAND(ImageIcon aND) {
		AND = aND;
	}
	public static void setNAND(ImageIcon nAND) {
		NAND = nAND;
	}
	public static void setNOR(ImageIcon nOR) {
		NOR = nOR;
	}
	public static void setNOT(ImageIcon nOT) {
		NOT = nOT;
	}
	public static void setOR(ImageIcon oR) {
		OR = oR;
	}
	public static void setXNOR(ImageIcon xNOR) {
		XNOR = xNOR;
	}
	public static void setXOR(ImageIcon xOR) {
		XOR = xOR;
	}
}
