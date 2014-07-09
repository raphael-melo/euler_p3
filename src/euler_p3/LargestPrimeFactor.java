package euler_p3;
import java.util.ArrayList;
import java.util.List;

import Util.Util;

public class LargestPrimeFactor {

	@Deprecated
	public static long largestPrimeFactor(long num) {
		List<Long> allPrimesSmaller = Util.generateListOfPrimes(num);
		
		for (int i = allPrimesSmaller.size() - 1; i > 0; i--) {
			if((num % allPrimesSmaller.get(i)) == 0){
				return allPrimesSmaller.get(i);
			}
		}
		return 1;
	}
	
	public static long largestPrimeFactor2(long num){
		
		Long lastDivisiblePrime = 1L;
		Long restDivision = num;
		
		Long currentPrime = 2L;
		
		List<Long> testedPrimes = new ArrayList<Long>();
		
		while(restDivision >= currentPrime){
			testedPrimes.add(currentPrime);
			if (restDivision % currentPrime == 0){
				lastDivisiblePrime = currentPrime;
				restDivision = restDivision / lastDivisiblePrime;
			}
			currentPrime = Util.nextPrime(testedPrimes);
		}
		
		return lastDivisiblePrime;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long number = 600851475143L;
		System.out.println(largestPrimeFactor2(number));
		
		
	}

}
