//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
       selectionSort(arr, i);
       return i;
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i=n-1; i>=0; i--){
	        int max = i;
	        for(int j=0;j<i;j++){
	            if(arr[j]>arr[max]){
	                max = j;
	            }
	        }
	        swap(arr, i, max);
	    }
	}
	void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}