package testComponent;

import static org.junit.Assert.*;

import org.junit.After;
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
		mux1.setInputs("000");
		mux2.setInputs("000");
		
		Wire wire = new Wire(mux1,0,mux2,0);
		
		
		fail("Not yet implemented");
	}

}
