//import java.util.*;

public class Mux2v1 extends Component {

	Mux2v1() {
		super(3, 1);
	}
	
	protected void updateOutputs(){
		//configure outputs[0]
		if(inputs[2]){
			setOutput(inputs[1],0);
		}else{
			setOutput(inputs[0],0);
		}
	}
}