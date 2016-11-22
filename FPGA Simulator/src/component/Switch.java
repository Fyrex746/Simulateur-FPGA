package component;


public class Switch extends Component {
	private boolean etat;
	
	public Switch() {
		super(1,1);
		updateOutputs();
	}
	
	protected void updateOutputs(){
		if (etat) setOutput(inputs[0],0);
		else setOutput(false,0);
	}
	
	public void interruption(){
		if(etat) etat=false;
		else etat=true;
		updateOutputs();
	}
	
	public void interruption(boolean val){
		etat=val;
		updateOutputs();
	}
}
