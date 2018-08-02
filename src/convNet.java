import java.util.Scanner;
/*
 * input 			36*36*3 (RGB)
 * conv 			32*32*16
 * relu 			32*32*16
 * maxpool 			16*16*16
 * conv 			12*12*20
 * relu 			12*12*20
 * maxpool 			6*6*20
 * conv 			2*2*20
 * relu 			2*2*20
 * maxpool 			1*1*20
 * fullyconnect 	1*1*10
 * fullyconnect 	1*1*10
 * */
public class convNet {
	
	public int trainingSize = 3600;
		
	public convLayer c1 = new convLayer(1296,3,16,16,5,0.01,0.5,0.0009);//36*36=1296
	public reluLayer r1 = new reluLayer();
	public maxpoolingLayer mp1 = new maxpoolingLayer();
	
	public convLayer c2 = new convLayer(1296,16,12,12,5,0.01,0.5,0.0009);
	public reluLayer r2 = new reluLayer();
	public maxpoolingLayer mp2 = new maxpoolingLayer();
	
	public convLayer c3 = new convLayer(1296,6,2,2,5,0.01,0.5,0.0009);
	public reluLayer r3 = new reluLayer();
	public maxpoolingLayer mp3 = new maxpoolingLayer();
	
	public double[][][] input = new double[this.trainingSize][3][1296];//1296=36*36
	
	public fullyConnectLayer f1 = new fullyConnectLayer(this.trainingSize,20,10, 0.09, 0.9, 0.001);
	public fullyConnectLayer f2 = new fullyConnectLayer(this.trainingSize,10,10, 0.09, 0.9, 0.001);
	
	public double[][] input2 = new double[this.trainingSize][20];//input ∑’Ë√—∫µËÕ¡“®“°maxpooling ∑’Ë¡’ 20 feature-map
	public double[][] target = new double[this.trainingSize][10];//category 10 type
	public convNet() {
		
	}
	
	public void train() {
		
		//feed to convolution layer#1
		for(int i = 0 ; i < this.trainingSize; i++) {
			c1.feedForward(input[i]);
			
		}
		
		
		
		//fullyConnectLayer 
		f1.feed(input2);
		f2.feed(f1.o);
		
		//computeLoss(input);
		
		f2.bpp(target);
		f1.bpp(f2.errorBack);
		f1.updateWeight();
		f2.updateWeight();
	}

}
