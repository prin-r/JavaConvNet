import java.awt.Graphics2D;
import java.io.File;
import javax.swing.JFrame;

public class Screen extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	public int[] pixels;
	public int x = 0, y = 0;
	public int[] pix;
	
	public image img = new image("C://Users/kanisorn/Dropbox/convolution/k.jpg");
	public String iDir = "C://Users/kanisorn/Dropbox/convolution/trainingSet/ptmp";
	public String tmpDir = "C://Users/kanisorn/Dropbox/convolution/trainingSet/tmp";
	public final File folder = new File(tmpDir);
	public image[] ilist;
	public String[] tmp = new String[1300];
	
	public int[][] t = new int[200][100];
	public double[][] normT = new double[200][100];
	
	public double[][] trainingSet = new double[1024][10];
	public double[][] target = new double[1024][10];
	
	public Screen (int width, int height) {
		pixels = new int[width*height];
		this.width = width;
		this.height = height;
		setResizable(false);
		setTitle("BezierTest");
		setSize(width, height);
		setLocation(50, 5);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//makeTrainingSet();
	}
	
	public void render(Graphics2D g2d) {
		img.draw(pixels, width);
	}
	
	private void makeTrainingSet() {
		for (int i = 1; i < trainingSet.length; i++) {
			if (trainingSet[i-1][0] < 0.0000001) {
				trainingSet[i][0] = 1.0;
				for (int j = 1; j < trainingSet[i].length; j++) trainingSet[i][j] = trainingSet[i-1][j];
			} else {
				int j = 0;
				while (trainingSet[i-1][j] > 0.0000001 && j < 10) j++;
				trainingSet[i][j] = 1.0;
				j++;
				while (j < trainingSet[i-1].length) {
					trainingSet[i][j] = trainingSet[i-1][j];
					j++;
				}
			}
		}
		for (int i = 1; i < trainingSet.length; i++) {
			int count = 0;
			for (int j = 0; j < trainingSet[i].length; j++) if (trainingSet[i][j] > 0.0000001) count++;
			target[i][count-1] = 1;
		}
	}
	
	public void listFilesForFolder(final File folder) {
		int i = 0;
		int c = 0;
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	String fName = fileEntry.getName();
	            System.out.println(tmpDir+"//"+fName);
	            tmp[i++] = tmpDir+"//"+fName;
	        }
	    }
	    for (int j = 0; j < i; j++) {
	    	c++;
	    	if (tmp[j] == null) break;
	    	else System.out.println(tmp[j]); 
	    }
	    this.ilist = new image[c];
	    for (int j = 0; j < c; j++) {
	    	this.ilist[j] = new image(tmp[j]);
	    }
	}
}
