package io.github.fallwizard.test;

/**
 * Thrown if a required environment property is missing.
 * 
 * @author Richard Clayton (Berico Technologies)
 */
public class TestPropertyMissingException extends Exception {

	private static final long serialVersionUID = 1309461059566839469L;
	
	private String missingPropertyName;
	private String testClass;
	private String testName;

	public TestPropertyMissingException(String missingPropertyName, String testClass, String testName) {
		
		super(String.format("The [%s] property was missing from the environment.", 
				missingPropertyName, testClass, testName));
		
		this.testClass = testClass;
		this.testName = testName;
		this.missingPropertyName = missingPropertyName;
	}

	public String getMissingPropertyName() {
		return missingPropertyName;
	}

	public String getTestClass() {
		return testClass;
	}

	public String getTestName() {
		return testName;
	}
}