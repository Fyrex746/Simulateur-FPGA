//import java.util.*;


public class Main {

	public static void main(String[] args) {
		mux2v1 muxtest= new mux2v1();
		muxtest.setInputs("101");
		System.out.println("Les entr�e vallent:	" + muxtest.getInputs() );
		System.out.println("La sortie vaut:		" + muxtest.getOutputs() );
		System.out.println(muxtest);
	}

}
