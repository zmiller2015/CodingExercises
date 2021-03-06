package BrainTeasers;

import java.util.Scanner;

public class PrisonCell {

	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many prison cells: ");
		int totalCellNumber = input.nextInt();
		System.out.println("How many prisoners will be released: ");
		int releaseNumber = input.nextInt();  
		int toBeReleased[] = new int[10];  //to hold the values input from the keyboard
		//int cellArray[] = new int[100];		//I might not need this
		for (int i = 0; i < releaseNumber; i++)
		{
			System.out.println((i+1) + " prisoner: ");
			toBeReleased[i] = input.nextInt();
		}
		int max = totalCellNumber - 1;
		
		int temp = releaseNumber;  //This is the largest number of bribes to be subtracted repeatedly from the released ppl
		int middle = (totalCellNumber - 1) / 2;
		for (int j = 0; j < releaseNumber; j++){

			int closest = determineClosest(temp, toBeReleased, middle, 100);
			System.out.println(closest);
			System.out.println("Bribes: " + max);
			max = closest - 1;
			
		}
		/*    A better idea foor how to get this accomplished is to save the index of the highest value so that I can delete it from
		 *    the array once I am done with it
		 * 
		 *    The idea of my main method is that a loop will go through as many times as there are prisoers to be released. and then remove them
		 *    from the array recording the 
		 */
		
		
		
		
		
		input.close();
	}//end of main
	
	public static int determineClosest(int sizeIndex, int toBeReleased[], int middle, int result){
		
		if (sizeIndex < 0) //base case
			return result;
		else if (result == 100 || Math.abs(middle - toBeReleased[sizeIndex]) < Math.abs(middle - result))    // if the absolute value of middle - first value then make result else recurse
		{
			result = determineClosest(--sizeIndex, toBeReleased, middle, toBeReleased[sizeIndex + 1]);
		}
		else
			result = determineClosest(--sizeIndex, toBeReleased, middle, result);
		return result;
	}
}
