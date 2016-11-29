package testComponent;

import static org.junit.Assert.*;
import org.junit.*;
import component.LutIn;

public class LutInTest {

	LutIn li;
	@Before
	public void setUp() throws Exception {
		li = new LutIn(3);
	}

	@Test
	public void init() {
		assertNotNull("L'initialisation à échoué",li);
	}
	
	@Test
	public void test() {
		li.setInputs("000");
		li.connectLut(0);
		assertEquals("0", li.getOutputs() );
		li.setInputs("100");
		assertEquals("1", li.getOutputs() );
		li.connectLut(1);
		assertEquals("0", li.getOutputs() );
		li.setInputs("010");
		assertEquals("1", li.getOutputs() );
		li.connectLut(2);
		assertEquals("0", li.getOutputs() );
		li.setInputs("001");
		assertEquals("1", li.getOutputs() );
		li.connectLut(0);
		assertEquals("0", li.getOutputs() );
	}

}
