package component;

public class SwitchNode extends Component {
	private WireNode wn;
	private Switch sw;
	private Wire wire;
	
	public SwitchNode(){
		super(1,2);
		wn  = new WireNode(2);
		sw = new Switch();
		wire = new Wire(wn,1,sw,0);
		updateOutputs();
	}
	
	protected void updateOutputs(){
		wn.setInput(inputs[0], 0);
		
		setOutput(wn.getOutput(0),0);
		setOutput(sw.getOutput(0),1);
	}
	
	public void switchState(){
		sw.switchState();
		updateOutputs();
	}
	
	public void setState(boolean val){
		sw.setState(val);
		updateOutputs();
	}
	public boolean getState(){
		return sw.getState();
	}
}
