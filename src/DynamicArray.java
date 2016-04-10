import java.util.Scanner;

public class DynamicArray {
	public static void main(String args[]){
		
		int final_number_of_elements_in_array;
		
		// initialization of array size to 1 
		int[] arr = new int[1]; 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in the array:");
		final_number_of_elements_in_array = input.nextInt();
		arr = new int[final_number_of_elements_in_array];
		
		System.out.println("The number of elements in the array are : " + arr.length);
		
		input.close();
	}	
}
