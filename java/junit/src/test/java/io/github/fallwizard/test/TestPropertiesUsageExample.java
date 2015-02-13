package io.github.fallwizard.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * This demonstrates how to use the TestProperties JUnit Rule.
 * 
 * @author Richard Clayton (Berico Technologies)
 */
public class TestPropertiesUsageExample {

	@Rule
	public TestProperties testProperties = new TestProperties();
	
	@BeforeClass
	public static void setup_environment_properties(){
		
		System.setProperty("required.property1", "Property 1");
		System.setProperty("required.property2", "Property 2");
		
	}
	
	@Test
	@RequireProperties({
		"required.property1",
		"required.property2"
	})
	public void these_will_run_because_the_properties_are_in_the_environment(){
	
		String requiredProperty1 = System.getProperty("required.property1");
		String requiredProperty2 = System.getProperty("required.property2");
		
		assertEquals("Property 1", requiredProperty1);
		assertEquals("Property 2", requiredProperty2);
	}

	@Test
	@RequireProperties({
		"required.property3"
	})
	public void this_should_fail_because_property_not_set(){
	
		fail("Should not run!");
	}
	
	/*
	// Uncomment this if you want to see it fail!
	@Test(expected=TestPropertyMissingException.class)
	@RequireProperties(ignoreIfAbsent=false, value={"required.property4"})
	public void this_should_throw_an_exception_because_the_property_is_required(){
		
	}
	*/
}
