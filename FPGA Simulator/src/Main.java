//import java.util.*;


public class Main {

	public static void main(String[] args) {
		Mux2v1 muxtest= new Mux2v1();
		muxtest.setInputs("100");
		
		Mux2v1 mux2 = new Mux2v1();
		mux2.setInputs("111");
	
		Wire muxtest_mux2 = new Wire(muxtest,0,mux2,0);
		
		System.out.println(muxtest);
		System.out.println(mux2);
		
		/*
		System.out.println("Les entrée vallent:	" + muxtest.getInputs() );
		System.out.println("La sortie vaut:		" + muxtest.getOutputs() );
		System.out.println(muxtest);
		*/
	}

}
