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
	
	public void segregate0and1(byte arr[])
	{
        int size = arr.length;
		int left = 0, right = size - 1;
		
		while(left < right){
			
			/* increment left while left index value is 0*/
			while(arr[left] == 0 && left < right)
				left++;
			
			/* Decrement right value while right index value = 1*/
            while(arr[right] == 1 && left < right)
					right--;
				
			if(left < right){
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
			
		}
		 
		for(int jindex = 0; jindex < size; jindex++){
			 int val = arr[jindex];
			 System.out.print(val);
		}
	}
	
	public static void main(String...args){
		
		byte arr[] = new byte[]{0,1,0,1,0,0,1,1};
		SortTheArray sortTheArray = new SortTheArray();
		//sortTheArray.toSort(arr);
		sortTheArray.segregate0and1(arr);
		
	}
}
