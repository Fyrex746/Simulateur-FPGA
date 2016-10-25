
public class WireNode extends Component{
	
	WireNode(int numberOfOutputs) {
		super(1, numberOfOutputs);
	}
	
	protected void updateOutputs(){
		for(int i=0; i<outputs.length; i++){
			setOutput(inputs[0], i);
		}
	}
	
	public void addConnection(Component component, int inputIndex){
		numberOfOutputs += 1;
		outputs = new boolean[numberOfOutputs];
		
		Wire tempOutputsWires[] = outputsWires;
		outputsWires = new Wire[numberOfOutputs];
		
		for(int i=0; i<tempOutputsWires.length; i++){
			outputsWires[i] = tempOutputsWires[i];
		}
		updateOutputs();
		Wire wire = Wire(this,tempOutputsWires.length,component,inputIndex);
	}
	
	public void deleteConnection(Component component, int inputIndex){
		numberOfOutputs -= 1;
		outputs = new boolean[numberOfOutputs];
		
		outputsWires[inputIndex] = null;
		Wire tempOutputsWires[] = outputsWires;
		outputsWires = new Wire[numberOfOutputs];
		
		for(int i=0; i<inputIndex-1; i++){
			outputsWires[i] = tempOutputsWires[i];
		}
		for(int i=inputIndex+1; i<tempOutputsWires.length; i++){
			outputsWires[i-1] = tempOutputsWires[i];
		}
		updateOutputs();
	}
}
