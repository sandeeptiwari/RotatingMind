public class EquilibriumIndex{
  
  public int equilibrium(int[] arr, int n){
	  int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
 
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];
 
        for (int i = 0; i < n; ++i)
        {
            sum -= arr[i]; // sum is now right sum for index i
 
            if (leftsum == sum)
                return i;
 
            leftsum += arr[i];
        }
 
        /* If no equilibrium index found, then return 0 */
        return -1;
  }
  
  public static void main(String...args){
	int a[] = {-7,1,5,2,-4,3,0};
	EquilibriumIndex ei = new EquilibriumIndex();
	System.out.print(ei.equilibrium(a, 7));
  }
}