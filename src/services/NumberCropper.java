package services;

import java.math.BigDecimal;
  
  public class NumberCropper {
	  
  	public static final double truncateNumber(double value, int decimals) {
  		final BigDecimal bdValue = BigDecimal.valueOf(value);
  		return bdValue.setScale(decimals, BigDecimal.ROUND_HALF_EVEN).doubleValue();
  	}
  }
  