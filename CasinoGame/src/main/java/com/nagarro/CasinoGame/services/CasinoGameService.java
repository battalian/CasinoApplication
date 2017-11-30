package com.nagarro.CasinoGame.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import com.alibaba.fastjson.JSON;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Option;
import com.mashape.unirest.http.options.Options;
import com.nagarro.CasinoGame.models.RouletteResult;
import com.nagarro.CasinoGame.models.UpdateProfit;

@Service
public class CasinoGameService {
	
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

		Collections.sort(sequences, new  compareFun());
		
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
	
	public RouletteResult showResult (  Integer num1,
			Integer num2,
			Integer num3,
			Integer num4,
			Integer num5,
			Integer num6,
			Integer num7,
			Integer num8,
			Long id
			)  {
		Double sum = (double) (num1 + num2 + num3 +num4 +num5 +num6 +num7 +num8) ;
		
		try {
			
			String json = JSON.toJSONString(new UpdateProfit(id, sum) );

			HttpResponse<JsonNode> postResponse = Unirest.post("http://localhost:8080/api/updateBlockedAmountWithId")
			        .header("accept", "application/json")
			        .header("Content-Type", "application/json")
			        .body( json )
			        .asJson();
			System.out.println( postResponse.getBody() );
			
		} catch (UnirestException e) {
			System.out.println("500 found");
			e.printStackTrace();
		}


		Random rand = new Random();
		Integer rouletteNum = randomGenerator(); 
		
		double profit = 0;
		if(rouletteNum >=1 && rouletteNum <=12  ){
			profit = profit + ( 1.5* num1 );
		}
		
		if(rouletteNum >=13 && rouletteNum <=27  ){
			profit = profit + ( 1.5* num2 );
		}
		
		if(rouletteNum >=28 && rouletteNum <=36  ){
			profit = profit + ( 1.5* num3 );
		}
		
		if(rouletteNum == 0){
			profit = profit + ( 10* num4 );
		}
		
		if(rouletteNum >=1 && rouletteNum <=18  ){
			profit = profit + ( 1.25* num5 );
		}
		
		if(rouletteNum >=19 && rouletteNum <=36  ){
			profit = profit + ( 1.25* num6 );
		}
		
		if(rouletteNum%2 == 0){
			profit = profit + ( 1.25* num7 );
		}
		
		if(rouletteNum%2 == 1 ){
			profit = profit + ( 1.25* num8 );
		}
		

		System.out.println("Roulette NUmber:" + rouletteNum);
		System.out.println("Profit:" + profit);


//		api();
		
		System.out.println("api");

		try {
			String json = JSON.toJSONString(new UpdateProfit(id, profit));

			HttpResponse<JsonNode> postResponse = Unirest.post("http://localhost:8080/api/updateAmountWithId")
			        .header("accept", "application/json")
			        .header("Content-Type", "application/json")
			        .body( json )
			        .asJson();
			System.out.println( postResponse.getBody() );
			
		} catch (UnirestException e) {
			System.out.println("500 found");
			e.printStackTrace();
		}
		
		
		return (new RouletteResult(id, profit-sum, rouletteNum));
	}

}


class compareFun implements Comparator<String>
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

