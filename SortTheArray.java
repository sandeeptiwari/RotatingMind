//WAP for  sort {0,1,0,1,0,0,1,1} this array?

public class SortTheArray{
	
	public void toSort(byte[] input){
		
		int len = input.length;
		
		for( int i = 0, j = len - 1; i < j ; ) 
			{ 
				if( input[i] == 1 ) 
				{ 
					if( input[j] == 0 ) 
					{ 
						input[i] = 0; 
						input[j] = 1; 
						i++; 
					} 

					j--; 
				} 
				else 
				{ 
					i++; 
			    }
			}
			
		for(int jindex = 0; jindex < len; jindex++){
			 int val = input[jindex];
			 System.out.print(val);
		}
	}
	
	public static void main(String...args){
		
		byte arr[] = new byte[]{0,1,0,1,0,0,1,1};
		SortTheArray sortTheArray = new SortTheArray();
		sortTheArray.toSort(arr);
		
	}
}
