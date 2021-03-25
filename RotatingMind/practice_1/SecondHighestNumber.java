public class SecondHighestNumber
{
  public static int getSecondHighest(int arr[]){
	  int len = arr.length;
	  int maxNumber = 0, secondMax = 0;
	  
	  //System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
	  
	  for(int i = 0; i < len; i++){
		  int n = arr[i];
		  if(maxNumber < n){
			  secondMax = maxNumber;
			  maxNumber = n;
		  }else if(secondMax < n){
			  secondMax = n;
		  }
		  
	  }
	return secondMax;
  }
  
  public static void main(String args[]){
    int a[] = new int[]{5,34,78,2,45,1,99,23};
    System.out.println(getSecondHighest(a));
  }
}