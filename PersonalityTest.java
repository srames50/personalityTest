// CS210 Assignment #7 "Personality Test"
// Shyam Ramesh

// This Java code processes a file containing survey results from the Keirsey Personality Test.
// The code uses four methods to calculate the scores of each dimension from the data in the input file.
// Then the code then outputs the results for each participant.


import java.io.*;
import java.util.*;


public class PersonalityTest {

    public static void main(String[] args) throws IOException {
    	intro(); // intro
    	
    	Scanner console = new Scanner(System.in);
    	// gathering file name
    	System.out.println("Please input the file name: "); // obtaining file name from user
    	Scanner input = new Scanner(new File(console.next()));
    	System.out.println("");
    	System.out.println("** This program reports the results for Keirsey Personality Test  ** ");
    	System.out.println("");
    	
    	while(input.hasNextLine()) { // while there is a next line, continue processing data
    		System.out.println(input.nextLine() + ": ");

    		String data = input.nextLine();
    		char[] dataArr = addtoArr(data);
    		
    		answers(dataArr);
    		
    		
    	}
    	System.out.print("..."); // end of program
    	
    	
    }
    public static void intro() { // intro method
    	System.out.println("The Keirsey Temperament Sorter (keirsey.com) is a test that measures four independent dimensions of your personality: ");
    	System.out.println("The test involves answering a 70-question survey.");
    	System.out.println("This program processes the file with the survey results and will output the corresponding results for each participatant in the input file");
    	System.out.println("");
    	
    }
    
    public static char[] addtoArr(String data) { // adding all letters to an array
    	char[] output = new char[70];
    	for(int i = 0; i < 70; i++) {
    		char letter = data.charAt(i);
    		output[i] = letter;
    	}
    	
    	return output;
    }
    
    public static void answers(char[] dataArr) { // method to process data 
    	int[] ei = answersProcessing1(dataArr);
    	System.out.printf("answers: [%dA-%dB, ", ei[0], ei[1]);
    	int[] sn = answersProcessing2(dataArr, 1, 2);
    	System.out.printf("%dA-%dB, ", sn[0], sn[1]);
    	int[] tf = answersProcessing2(dataArr, 3, 4);
    	System.out.printf("%dA-%dB, ", tf[0], tf[1]);
    	int[] jp = answersProcessing2(dataArr, 5, 6);
    	System.out.printf("%dA-%dB]\n", jp[0], jp[1]);
    	
    	int[] bRatios = new int[4];
    	bRatios[0] = percentB(ei);
    	bRatios[1] = percentB(sn);
    	bRatios[2] = percentB(tf);
    	bRatios[3] = percentB(jp);
    	System.out.printf("percent B: [%d, %d, %d, %d]\n", bRatios[0], bRatios[1], bRatios[2], bRatios[3]);
    	
    	String[] pTypes = pType(bRatios); 
    	System.out.printf("type: %s%s%s%s\n\n", pTypes[0], pTypes[1], pTypes[2], pTypes[3]);
    	
    	
    }
    
    public static int[] answersProcessing1(char[] dataArr) { // method to iterate through array and determine a tally and b tally
    	int[] resultArr = new int[2];
    	int aTally = 0;
		int bTally = 0;
    	for(int i = 0; i < dataArr.length; i += 7) {
    		if(dataArr[i] == 'A' || dataArr[i] == 'a') {
    			aTally += 1;
    		} else if(dataArr[i] == 'B' || dataArr[i] == 'b') {
    			bTally += 1;
    		}
    	}
    	resultArr[0] = aTally;
    	resultArr[1] = bTally;
    	
    	return resultArr;
    }
    
    public static int[] answersProcessing2(char[] dataArr, int num1, int num2) { // method to iterate through array like above but for the ones with two quesitons
    	int[] resultArr = new int[2];
    	int aTally = 0;
		int bTally = 0;
    	for(int i = num1; i < dataArr.length; i += 7) {
    		if(dataArr[i] == 'A' || dataArr[i] == 'a') {
    			aTally += 1;
    		} else if(dataArr[i] == 'B' || dataArr[i] == 'b') {
    			bTally += 1;
    		}
    	}
    	for(int i = num2; i < dataArr.length; i += 7) {
    		if(dataArr[i] == 'A' || dataArr[i] == 'a') {
    			aTally += 1;
    		} else if(dataArr[i] == 'B' || dataArr[i] == 'b') {
    			bTally += 1;
    		}
    	}
    	resultArr[0] = aTally;
    	resultArr[1] = bTally;
    	
    	return resultArr;
    }
    
    public static int percentB(int[] arr) { // percent b method calculator
    	double ratio = 100 * arr[1]/(arr[0] + arr[1]);
    	int lastRatio = (int) Math.round(ratio);
    	return lastRatio;
    	
    }
    
    public static String[] pType(int[] bRatios) { // personality determiner method based on bRatios
    	String[] type = new String[4];
    	
    	if(bRatios[0] > 50) {
    		type[0] = "I";
    	} else if (bRatios[0] < 50) {
    		type[0] = "E";
    	} else {
    		type[0] = "X";
    	}
    	
    	if(bRatios[1] > 50) {
    		type[1] = "N";
    	} else if (bRatios[1] < 50) {
    		type[1] = "S";
    	} else {
    		type[1] = "X";
    	}
    	
    	if(bRatios[2] > 50) {
    		type[2] = "F";
    	} else if (bRatios[2] < 50) {
    		type[2] = "T";
    	} else {
    		type[2] = "X";
    	}
    	
    	if(bRatios[3] > 50) {
    		type[3] = "P";
    	} else if (bRatios[3] < 50) {
    		type[3] = "J";
    	} else {
    		type[3] = "X";
    	}
    	
    	return type;
    	
    }
   
    
}