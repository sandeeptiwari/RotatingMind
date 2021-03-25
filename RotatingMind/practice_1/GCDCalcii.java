
public class GCDCalcii{
	
	public int getGDC(int m, int n){
		
		if(m < n)
			return getGDC(n, m);
		
		if(m % n == 0){
			return n;
		}else{
			return getGDC(m, m % n);
		}
	}


	public static void main(String args[]){
		GCDCalcii gcd = new GCDCalcii();
		System.out.print(gcd.getGDC(16, 12));
		
	}
}