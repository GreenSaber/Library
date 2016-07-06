package Pac5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value = Parameterized.class)
public class tst_expCalc {
	private String pass_value;
	private Double expected_result;
	private RealNumb rn;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			{25.0, "5"},
			{81.0, "-3"},
			{16.0, "4"}
		});
	}

public tst_expCalc(Double expected_result, String pass_value)
{
	this.expected_result=expected_result;
	this.pass_value=pass_value;
}
@Before
public void setUp()
{
	rn=new RealNumb();
}
@Test
	public void tstFourDigit() 
{
	assertEquals(expected_result, rn.expCalc(pass_value));
}
}