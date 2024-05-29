package net.openwebinars.lib;

import java.util.List;

public class Libreria {
	
	public static double media(double... nums) {
		double result = 0.0;
		for (double n : nums) {
			result += n;
		}
		
		return result / nums.length;
		
	}
	
	public static double media(List<Double> nums) {
		double result = 0.0;
		for (double n : nums) {
			result += n;
		}
		
		return result / nums.size();
	}

}
