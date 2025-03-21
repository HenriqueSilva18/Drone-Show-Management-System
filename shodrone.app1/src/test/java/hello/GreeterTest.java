package hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
	A comment
*/
public class GreeterTest {
	
	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertTrue(greeter.sayHello().contains("Hello world!"));
	}

}
