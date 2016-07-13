package Pac6;

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
public class tst_maxValueCalc {
	private ArrayList<String> parameters;
	private Double expected_result;
	private MaxMinValue mm;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			
			{256.0, new ArrayList<String>(Arrays.asList("156","178.0","256"))},
			{100.0, new ArrayList<String>(Arrays.asList("0","-154654","100"))},
	
		});
	}

public tst_maxValueCalc(Double expected_result, ArrayList<String> parameters)
{
	this.expected_result=expected_result;
	this.parameters=parameters;
}
@Before
public void setUp()
{
	mm=new MaxMinValue();
}
@Test
	public void tstMaxMinValue() 
	
{
	assertEquals(expected_result, Double.valueOf(mm.maxValueCalc(parameters.get(0),parameters.get(1),parameters.get(2))));
}
}