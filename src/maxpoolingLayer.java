
public class maxpoolingLayer {
	
	public int inputImgSize = 0;
	public int prevLayerSize = 0;//reLu
	public int layerSize = 0;//maxpooling layer
	public int outputImgSize = 0;
	
	public double[][] x;
	public double[][] o;

	
	public maxpoolingLayer(int imgIS, int pls, int ls) {
		this.inputImgSize = imgIS;
		this.prevLayerSize = pls;
		this.layerSize = ls;
		this.outputImgSize = imgIS/2;
		this.x = new double[this.prevLayerSize][this.inputImgSize*this.inputImgSize];
		this.o = new double[this.prevLayerSize][this.outputImgSize*this.outputImgSize];
		
		
	
	}
	
	public void maxpooling (double[][] input) {
		
		//receive reLu layer to x[i][j]
		for (int i = 0; i < this.prevLayerSize ; i++) {
			for (int j = 0; j < this.inputImgSize*this.inputImgSize; j++) {
				x[i][j] = input[i][j];
			}
		}
		
		
		
	}
	
	public void maxval() {
		
		
	}
	
}
