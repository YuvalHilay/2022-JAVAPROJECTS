package tree;

import java.util.Scanner;

public class ReversedWords {
	
	public static int checkReversed() {
		Scanner scan = new Scanner(System.in);//create scan for user input
		boolean flag=true;//initialization Variables
		String str;
		Node root= new Node();
		int sum=0;
		System.out.println("please enter string:");
		do {
			str=scan.next();//take input
			if(str.equals("X")==true) //condition for stop
				flag=false;
			else {
				if(root.num(str)!=0)//check if we need to sum++
					sum++;
				root.add(reverseString(str));//add the reverse string to the tree
			}
			
		}while(flag);
		scan.close();	
		return sum;
	}
	
	 private static String reverseString(String s) {//func for reverse a string
		    if(s.length() == 0)
		      return "";
		    return s.charAt(s.length()-1) + reverseString(s.substring(0,s.length()-1));
	 }
}
