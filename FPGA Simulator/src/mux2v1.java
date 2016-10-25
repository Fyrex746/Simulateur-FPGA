//import java.util.*;

public class mux2v1 extends Component {

	mux2v1() {
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
