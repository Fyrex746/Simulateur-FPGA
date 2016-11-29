package testComponent;

import static org.junit.Assert.*;
import org.junit.*;
import component.Switch;

public class SwitchTest {
	Switch sw;
	

	@Before
	public void setUp() throws Exception {
		sw = new Switch();
	}

	@Test
	public void init() {
		assertNotNull("L'initialisation à échoué",sw);
	}
	
	@Test
	public void test() {
		sw.setInputs("1");
		assertEquals("0", sw.getOutputs() );
		sw.setInputs("0");
		assertEquals("0", sw.getOutputs() );
		
		sw.switchState();
		assertEquals("0", sw.getOutputs() );
		sw.setInputs("1");
		assertEquals("1", sw.getOutputs() );
		
	}

}
