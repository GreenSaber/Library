package Pac3;

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
public class tst_perimCalc {
	private ArrayList<String> parameters;
	private Double expected_result;
	private RectTriangle rt;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			
			{12.0, new ArrayList<String>(Arrays.asList("3","4"))},
	
		});
	}

public tst_perimCalc(Double expected_result, ArrayList<String> parameters)
{
	this.expected_result=expected_result;
	this.parameters=parameters;
}
@Before
public void setUp()
{
	rt=new RectTriangle();
}
@Test
	public void tstExpCalc() 
	
{
	assertEquals(expected_result, Double.valueOf(rt.perimCalc(parameters.get(0),parameters.get(1))));
}
}