import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class image {
	
	public int[][] pix;
	public int[][] RGB;
	public BufferedImage img = null;
	public int w;
	public int h;
	public int x;
	public int y;
	
	public image(String dir) {
		File in = new File(dir);
		try {
			img = ImageIO.read(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.x = 0;
		this.y = 0;
		this.w = img.getWidth();
		this.h = img.getHeight();
		this.pix = new int[w][h];
		this.RGB = new int[3][w*h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int rgb = img.getRGB(i, j);
				int r = (rgb >> 16) & 0xFF;
		        int g = (rgb >> 8) & 0xFF;
		        int b = (rgb & 0xFF);
		        int index = i+j*w;
		        RGB[0][index] = r;
		        RGB[1][index] = g;
		        RGB[2][index] = b;
				pix[i][j] = (int)Math.abs((r+g+b)/3);
			}
		}	
	}
	
	public void draw(int[] sp, int sw) {
		int wx = w+x;
		int hy = h+y;
		for (int i = x; i < wx; i++) {
			for (int j = y; j < hy; j++) {
				int index = i+j*sw;
				//int c = toR(i-x,j-y);
				if (index >= 0 & index < sp.length) sp[index] = toG(i-x,j-y)+toB(i-x,j-y)+toR(i-x,j-y);
			}
		}
	}
	
	public int toR(int i, int j) {
		return this.RGB[0][i+j*w]<<16;
	}
	
	public int toG(int i, int j) {
		return this.RGB[1][i+j*w]<<8;
	}
	
	public int toB(int i, int j) {
		return this.RGB[2][i+j*w];
	}
}
