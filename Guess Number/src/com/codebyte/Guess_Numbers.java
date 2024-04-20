package com.codebyte;

import java.util.Random;
import java.util.Scanner;

public class Guess_Numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		
		boolean start = true;
	
			while (start) {
				
				System.out.println("welcome to Guess Number Game you can guess number upto 100");
				
				int guess=0,trials=3,score=1;
				Random random = new Random();
				int number = random.nextInt(100) + 1;
				System.out.println(number);
				while(guess<trials) {
				System.out.println("Attempt"+(guess+1)+":");
				
				int userInput=sc.nextInt();
				
				
					if (number == userInput) {
						if(score==1)
				         {
				        	 score=30;
				         }
						else {
							int temp=score*10;
							score=30-temp;
						}
						
						System.out.println(" your quess value correct your score"+score);
						
						break;
					}
					
					if (number < userInput) {
						System.out.println("Your Quess Value is greater try again");					

					} if(number>userInput) {
						System.out.println("Your Quess values is lower try again ");
						
					}
					guess++;
					score++;
					
				}
				if(guess==trials) {	
		System.out.println(" Your Choices are finished correct number is "+number+" type your wish 'RESTART' Or 'STOP' ");
		String  str=sc.next();
		if(str.equalsIgnoreCase("stop")) {
			start=false;
		}
				}
				
			}
         
		
			

		System.out.print("your choice is stop");

	}

}
