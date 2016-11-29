package testComponent;

import static org.junit.Assert.*;
import org.junit.*;
import component.SwitchNode;

public class SwitchNodeTest {

	SwitchNode swn;
	@Before
	public void setUp() throws Exception {
		swn = new SwitchNode();
	}

	@Test
	public void init() {
		assertNotNull("L'initialisation à échoué",swn);
	}
	
	@Test
	public void test() {
		swn.setInputs("1");
		assertEquals("01", swn.getOutputs() );
		swn.switchState();
		assertEquals("11", swn.getOutputs() );
		
		swn.setInputs("0");
		assertEquals("00", swn.getOutputs() );
		swn.switchState();
		assertEquals("00", swn.getOutputs() );
		
	}

}
