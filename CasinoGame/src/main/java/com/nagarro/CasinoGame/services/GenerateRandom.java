package com.nagarro.CasinoGame.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class compare implements Comparator<String>
{
	public int compare(String X, String Y)
	{
		String XY = X+Y;
		String YX = Y+ X;

		int sum1=0, sum2=0;

		for(int i=0; i<XY.length(); i++){
			if(i%2==0)
				sum1  = sum1+ (XY.charAt(i)- '0'  );
			else
				sum1  = sum1- (XY.charAt(i)- '0'  );
		}

		for(int i=0; i<YX.length(); i++){
			if(i%2==0)
				sum2  = sum2+ (YX.charAt(i)- '0'  );
			else
				sum2  = sum2- (YX.charAt(i)- '0'  );
		}

		return (Math.abs(sum1) <  Math.abs(sum2) )? 1: 0;
	}
}

public class GenerateRandom {

	static int RANDOM_NUMBERS = 20;
	public static Integer randomGenerator(){
		ArrayList<String> sequences = new ArrayList<String>();
		for(int i=0; i<RANDOM_NUMBERS; i++){
			Random rand = new Random();
			Integer  sequence_length = rand.nextInt(9)+ 1;
			String s = "";
			for(int j=0; j<sequence_length; j++) {
				if(j==0)
					s = s + (rand.nextInt(8)+ 1 + '0');   
				else
					s = s + (rand.nextInt(9)+ '0');   
			}
			sequences.add(s);
		}

//		System.out.println(sequences);

		Collections.sort(sequences, new  compare());
		
		int j = 0;
		String res="";
		while (sequences.size() > j) {
//			System.out.println(sequences.get(j));
			res = res + sequences.get(j);
			j++;
		}
		Integer fin=0;
		for(int i=0; i<res.length(); i++){
			if(i%2==0)
				fin  = fin+ (res.charAt(i)- '0'  );
			else
				fin  = fin- (res.charAt(i)- '0'  );
		}
		
		return (Math.abs(fin)% 36 );
	}

	public static void main(String[] args) {
		System.out.println( randomGenerator());
		}

}
