package component;

public class Test {

	public static void main(String[] args) {
		Mux2v1 muxtest= new Mux2v1();
		muxtest.setInputs("101");
		
		WireNode node = new WireNode(muxtest,0);
		
		Mux2v1 mux2 = new Mux2v1();
		mux2.setInputs("111");
		
		Mux2v1 mux3 = new Mux2v1();
		mux3.setInputs("111");
	
		//Wire muxtest_mux2 = new Wire(muxtest,0,mux2,0);
		node.addConnection(mux3, 0);
		node.addConnection(mux3, 1);
		
		System.out.println(muxtest);
		System.out.println(mux2);
		System.out.println(mux3);
		
		/*
		System.out.println("Les entrée vallent:	" + muxtest.getInputs() );
		System.out.println("La sortie vaut:		" + muxtest.getOutputs() );
		System.out.println(muxtest);
		*/
	}

}
