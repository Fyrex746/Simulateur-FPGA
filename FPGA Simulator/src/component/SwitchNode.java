package component;

public class SwitchNode extends Component {
	private boolean interrupteur;
	
	public SwitchNode(){
		super(1,2);
		updateOutputs();
	}
	
	protected void updateOutputs(){
		setOutput(inputs[0],0);
		if (interrupteur) setOutput(inputs[0],1);
		else setOutput(false,1);
	}
	public void switchEtat(boolean valeur){
		interrupteur=valeur;
		updateOutputs();
	}
	public void setEtat(){
		if (interrupteur) interrupteur=false;
		else interrupteur=true;
		updateOutputs();
	}
}
