
public class testMaxpool {
	public static void main(String[] args) {
		double[] x = new double[32*32];
		double[] o = new double[16*16];
		double[][] pool = new double[16*16][2*2];
		
		//get Value x
		for (int i = 0; i < x.length; i++) {
			x[i] = Math.random()*5;
		}
		
		//collect value to pool
		for(int i = 0; i < 32; i++) {
			int count = 0;//0->2
			int count2 = 0;//0->15
			for (int j = 0; j < 32; j++) {
				System.out.println(i+ "  " + j + "   " + count2 + "     " + count);
				if(count == 2) {
					count = 0;
					count2++;
					j--;
					
				}
				else {
					x[j] = pool[count2][count];
					count++;
				}
				
			}
		}
	}
	
}
