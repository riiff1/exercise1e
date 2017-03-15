package wdsr.exercise1;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtil {
	private Calculator calculator;
	
	public CalculatorUtil(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public String getAdditionText(final int a, final int b) {
		return String.format("%s + %s = %s", a, b, calculator.add(a, b));
	}

	public String getSubstractionText(final int a, final int b) {
		if(a < 0 && b <0) {
			return getSubstractionTextWithBrackets(a,b);
		}
		return String.format("%s - %s = %s", a, b, calculator.subtract(a, b));
	}
	
	public String getDivisionText(final int a, final int b) {
		return String.format("%s / %s = %s", a, b, calculator.divide(a, b));
	}
	
	public String getModuloText(final int a, final int b) {
		return String.format("%s %% %s = %s", a, b, calculator.modulo(a, b));
	}

	private String getSubstractionTextWithBrackets(final int a, final int b)
	{
		return String.format("(%s) - (%s) = (%s)", a, b, calculator.subtract(a, b));
	}

}
