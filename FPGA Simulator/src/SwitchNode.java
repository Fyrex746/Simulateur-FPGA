
public class SwitchNode extends Component {
	private boolean interrupteur;
	
	SwitchNode(){
		super(1,2);
		updateOutputs();
	}
	
	protected void updateOutputs(){
		setOutput(inputs[0],0);
		if (interrupteur) setOutput(inputs[0],1);
		else setOutput(false,1);
	}
	protected void interruption(boolean valeur){
		interrupteur=valeur;
		updateOutputs();
	}
	protected void interruption(){
		if (interrupteur) interrupteur=false;
		else interrupteur=true;
		updateOutputs();
	}
}
