package wdsr.exercise1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testModuloByZero() {
		// given
		doThrow(new IllegalArgumentException()).when(calculator).modulo(anyInt(), eq(0));

		// when
		calcUtil.getModuloText(3, 0);

		// then
		// empty - exception expected
	}

	@Test
	public void testModulo16By4() {
		// given
		when(calculator.modulo(anyInt(),anyInt())).thenReturn(1);

		// when
		String result = calcUtil.getModuloText(5,2);

		// then
		assertEquals("5 % 2 = 1", result);
		verify(calculator).modulo(anyInt(),anyInt());
	}
}
