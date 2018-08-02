
public class convLayer {
	
	public int inputImgSize = 0;
	public int prevLayerSize = 0;//inputSize
	public int layerSize = 0;//convolSize
	public int nextLayerSize = 0;//reLusize
	public double learningRate = 0.0;
	public double momentumRate = 0.0;
	public double weightDecay = 0.0;
	
	public int kernelSize = 0;
	public int kernelNum = 0;
	
	public double[][] x;
	public double[][][] kernels;
	public double[][][] dk;
	public double[][][] vk;
	public double[][] sigma;
	public double[][] features;
	public double[] bias;
	
	public convLayer(int imgs,int pls, int ls, int nls, int ks, double lr, double mr, double wd) {
		this.inputImgSize = imgs;
		this.prevLayerSize = pls;
		this.layerSize = ls;
		this.nextLayerSize = nls;
		this.kernelSize = ks;
		this.kernelNum = ls*nls;
		this.learningRate = lr;
		this.momentumRate = mr;
		this.weightDecay = wd;
		
		this.x = new double[this.prevLayerSize][this.inputImgSize*this.inputImgSize];
		this.bias = new double[this.layerSize];
		this.kernels = new double[this.prevLayerSize][this.layerSize][this.kernelSize*this.kernelSize];
		this.features = new double[this.layerSize][this.prevLayerSize];
		
		//random kernals
		iniationW();
		
	}
	
	public void iniationW(){
		double weightRange = 4.0*Math.sqrt(6.0/(this.prevLayerSize+this.layerSize+1.0));
		for(int i = 0 ; i < this.prevLayerSize ; i++) {
			for (int j = 0 ; j < this.layerSize; j++) {
				for (int k = 0; k < this.kernelSize*this.kernelSize; k++) {
					double r = Math.random()*weightRange;
					this.kernels[i][j][k] = (Math.random() < 0.5)? -r:r;
					//System.out.println(kernels[i][j]);
				}
			}
		}
	}
	
	
	public void feedForward(double[][] input) {
		//ใน conv x[3][36*36] แต่ถ้าใส่มาจากภายนอก input[training set]
		for(int i = 0; i < this.prevLayerSize; i++) {
			for(int j = 0; j < this.inputImgSize*this.inputImgSize; j++) {
				x[i][j] = input[i][j];
			}
		}
		
				
		for(int i = 0; i < this.prevLayerSize; i++) {
			for(int j = 0; j < this.layerSize; j++) {
				double sum = 0.0;
				for(int k = 0; k < this.kernelSize*this.kernelSize; k++) {
					sum += x[i][] * kernels[i][j][k];
				}
			}
		}
		
		
	}
	
}
