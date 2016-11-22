package testComponent;

import static org.junit.Assert.*;
import org.junit.*;

import component.Mux2v1;

public class Mux2v1Test {

	Mux2v1 mux;
	
	@Before
	public void setUp() throws Exception {
		mux= new Mux2v1();
	}

	@Test
	public void init() {
		assertNotNull("L'initialisation à échoué",mux);
	}
	
	@Test
	public void logicTest() {
		mux.setInputs("000");
		assertEquals("0", mux.getOutputs() );
		mux.setInputs("001");
		assertEquals("0", mux.getOutputs() );
		
		mux.setInputs("010");
		assertEquals("0", mux.getOutputs() );
		mux.setInputs("011");
		assertEquals("1", mux.getOutputs() );
		
		mux.setInputs("110");
		assertEquals("1", mux.getOutputs() );
		mux.setInputs("111");
		assertEquals("1", mux.getOutputs() );
		
		mux.setInputs("100");
		assertEquals("1", mux.getOutputs() );
		mux.setInputs("101");
		assertEquals("0", mux.getOutputs() );
		
		
	}
}
