package testComponent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import component.*;

public class WireNodeTest {

	WireNode wn;
	
	@Before
	public void setUp() throws Exception {
		wn = new WireNode(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void init() {
		assertNotNull("Init fail",wn);
	}

	@Test
	public void test() {
		wn.setInput(true, 0);
		assertEquals("111", wn.getOutputs() );
		
		wn.setInput(false, 0);
		assertEquals("000", wn.getOutputs() );
	}
}
