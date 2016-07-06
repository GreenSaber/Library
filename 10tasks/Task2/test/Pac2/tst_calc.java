package Pac2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value = Parameterized.class)
public class tst_calc {
	private String pass_value;
	private Double expected_result;
	private ExpCalc ec;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			{0.25, new ArrayList<String>(Arrays.asList("1","2","3"))},
	
		});
	}

public tst_calc(Double expected_result, String pass_value)
{
	this.expected_result=expected_result;
	this.pass_value=pass_value;
}
@Before
public void setUp()
{
	ec=new ExpCalc();
}
@Test
	public void tstExpCalc() 
{
	assertEquals(expected_result, ec.calc(pass_value));
}
}