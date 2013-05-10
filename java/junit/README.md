# Test Utils

These are a set of utilities to aid developers in writing Unit and Integration Tests.

## Contents

Not much here yet. Add as needed.

* `@RequireProperties` annotation.

### `@RequireProperties`

This is a JUnit Rule that will either skip tests that do not have the required properties in the Environment or  automatically fail (throwing a `TestPropertyMissingException`).

#### Usage

Add the JUnit `@Rule` to your test class:

```java
public class BlahTest {

  @Rule
  public TestProperties testProperties = new TestProperties();

}
```

Annotate test methods that you require environment properties to execute.  In this form, if the properties are not in the environment, the test will be skipped.

```java

@Test
@RequireProperties({
	"system.property1",
	"system.property2"
})
public void test_sprocket_rotates_efficiently() {
	
	String prop1 = System.getProperty("system.property1");
	String prop2 = System.getProperty("system.property2");
}

```

You can make a property mandatory, failing the test if it is not found:

```java

@Test
@RequireProperties(ignoreIfAbsent=false, value={ "system.property1", "system.property2" })
public void test_sprocket_rotates_efficiently() {
	
	String prop1 = System.getProperty("system.property1");
	String prop2 = System.getProperty("system.property2");
}

```

