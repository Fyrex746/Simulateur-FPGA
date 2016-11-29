package testComponent;

import static org.junit.Assert.*;
import org.junit.*;
import component.LUT3;

public class LUT3Test {
	LUT3 l3;
	
	@Before
	public void setUp() throws Exception {
		l3 = new LUT3();
	}

	@Test
	public void init() {
		assertNotNull("L'initialisation à échoué",l3);
	}
	
	@Test
	public void test() {
		l3.setInputs("000");
		l3.setVals("00000000");
		
		assertEquals("0", l3.getOutputs() );
		l3.setVals("10000000");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("001");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("01000000");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("010");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00100000");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("011");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00010000");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("100");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00001000");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("101");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00000100");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("110");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00000010");
		assertEquals("1", l3.getOutputs() );
		l3.setInputs("111");
		assertEquals("0", l3.getOutputs() );
		l3.setVals("00000001");
		assertEquals("1", l3.getOutputs() );
	}

}
