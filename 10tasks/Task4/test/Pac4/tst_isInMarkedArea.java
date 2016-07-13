package Pac4;

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
public class tst_isInMarkedArea {
	private ArrayList<String> parameters;
	private boolean expected_result;
	private Area a;
@Parameters
public static Collection<Object[]> set_of_parameters()
	{
		return Arrays.asList(new Object[][]{
			
			{true, new ArrayList<String>(Arrays.asList("1","1"))},
			{false, new ArrayList<String>(Arrays.asList("10","1"))},
	
		});
	}

public tst_isInMarkedArea(Boolean expected_result, ArrayList<String> parameters)
{
	this.expected_result=expected_result;
	this.parameters=parameters;
}
@Before
public void setUp()
{
	a=new Area();
}
@Test
	public void tstExpCalc() 
	
{
	assertEquals(expected_result, a.isInMarkedArea(parameters.get(0),parameters.get(1)));
}
}