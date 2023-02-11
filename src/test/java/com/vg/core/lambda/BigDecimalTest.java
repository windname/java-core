package com.vg.core.lambda;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertNotNull;

//import org.junit.Test;

public class BigDecimalTest {
//	@Test
	public void testBig() {
		String result2 = new BigDecimal("469.00").divide(new BigDecimal("0.968000"), RoundingMode.HALF_UP).toPlainString();
		assertNotNull(result2);
	}
}
