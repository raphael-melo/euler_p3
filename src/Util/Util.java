package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Util {

	public static List<Long> generateListOfPrimes(Long limit) {
		
//		Map<Long, Boolean> isNotPrimeMap = new HashMap<Long, Boolean>();
		List<Long> notPrimes = new ArrayList<Long>();
//		boolean[] isNotPrime = new boolean[limit];
		List<Long> primes = new ArrayList<Long>();
		Long firstPrime = (long) 2;
		
		while(firstPrime <= limit){
			for (; firstPrime <= limit; firstPrime++) {
//				if(!isNotPrime[firstPrime-2]){
				if(!notPrimes.contains(firstPrime)){
					primes.add(firstPrime);
					break;
				}
			}
			for(int i = 2;i <= limit/firstPrime; i++){
				notPrimes.add(firstPrime*i);
//				isNotPrime[(firstPrime*i)-2] = true;
			}
			firstPrime++;
		}
		
		return primes;
	}
	
	public static Long nextPrime(List<Long> previousPrimes){
		Long attemptPrime = previousPrimes.get(previousPrimes.size()-1) + 1;
		while(true){
			boolean isPrime = true;
			for (Long previousPrime : previousPrimes) {
				if((attemptPrime % previousPrime) == 0){
					attemptPrime++;
					isPrime = false;
					break;
				}
			}
			if(isPrime == true)
				return attemptPrime;
		}
	}
	
}
