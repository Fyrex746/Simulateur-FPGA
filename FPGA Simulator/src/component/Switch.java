package component;


public class Switch extends Component {
	private boolean state = false;
	
	public Switch() {
		super(1,1);
		updateOutputs();
	}
	
	protected void updateOutputs(){
		if (state) setOutput(inputs[0],0);
		else setOutput(false,0);
	}
	
	public void switchState(){
		if(state)setState(false);
		else setState(true);
	}
	
	public void setState(boolean val){
		state = val;
		updateOutputs();
	}
	public boolean getState(boolean val){
		return state;
	}
}
