package org.minemofan.core.common.utils.decimal;

import java.math.BigDecimal;

/**
 * Created on 2015-04-01
 * <p>Title:       BigDecima工具类</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     东软软件股份有限公司</p>
 * <p>Department:  软件开发事业部</p>
 * @author         mosh
 * @version        1.0
 */
public class BigDecimalUtil {
	public static void main(String[] args) {
		BigDecimal big = new BigDecimal("10");
		BigDecimal big2 = new BigDecimal("3");
		System.out.println(big.divide(big2,10,BigDecimal.ROUND_HALF_UP).doubleValue());
		//System.out.println(big.divide(big2));
		int i1 = -100;
		int i2 = 10;
		System.out.println(i1/i2);
		
		
		System.out.println(big.equals(new BigDecimal(10)));
	}
}
