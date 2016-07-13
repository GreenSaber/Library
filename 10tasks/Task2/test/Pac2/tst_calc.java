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
	private ArrayList<String> parameters;
	private Double expected_result;
	private ExpCalc ec;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			
			{2.0, new ArrayList<String>(Arrays.asList("1","1","0"))},
	
		});
	}

public tst_calc(Double expected_result, ArrayList<String> parameters)
{
	this.expected_result=expected_result;
	this.parameters=parameters;
}
@Before
public void setUp()
{
	ec=new ExpCalc();
}
@Test
	public void tstExpCalc() 
	
{
	assertEquals(expected_result, Double.valueOf(ec.calc(parameters.get(0),parameters.get(1),parameters.get(2))));
}
}