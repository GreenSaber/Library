package Pac1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value = Parameterized.class)
public class tst_isNumber {
	private String pass_value;
	private Boolean expected_result;
	private FourDigit fd;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			{true, "1234"},
			{false, "abcd"},
			{false, "123q"},
			{true, "0000"},
		});
	}

public tst_isNumber(Boolean expected_result, String pass_value)
{
	this.expected_result=expected_result;
	this.pass_value=pass_value;
}
@Before
public void setUp()
{
	fd=new FourDigit();
}
@Test
	public void tstFourDigit() 
{
	assertEquals(expected_result, fd.isNumber(pass_value));
}
}