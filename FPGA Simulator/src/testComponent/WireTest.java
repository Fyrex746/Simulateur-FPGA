package testComponent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import component.Wire;
import component.Mux2v1;

public class WireTest {
	Mux2v1 mux1; 
	Mux2v1 mux2;
	
	
	@Before
	public void setUp() throws Exception {
		mux1= new Mux2v1();
		mux2= new Mux2v1();
	}

	@Test
	public void connect2MuxWithWire() {
		Wire wire = new Wire(mux1,0,mux2,0);
		assertNotNull("wire creating failed",wire);
		
		mux1.setInputs("011");
		assertEquals(mux1.getOutput(0) , mux2.getInput(0) );
		
		mux1.setInputs("010");
		assertEquals(mux1.getOutput(0) , mux2.getInput(0) );
		
		mux1.setInputs("000");
		assertEquals(mux1.getOutput(0) , mux2.getInput(0) );
	}
	
	@Test
	public void disconnectWire() {
		Wire wire = new Wire(mux1,0,mux2,0);
		wire.disconect();
		
		mux1.setInputs("011");
		mux2.setInputs("000");
		
		assertNotEquals(mux1.getOutput(0) , mux2.getInput(0) );
	}

}
