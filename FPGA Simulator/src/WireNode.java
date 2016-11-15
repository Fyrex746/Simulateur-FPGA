
public class WireNode extends Component{
	
	WireNode(int numberOfOutputs) {
		super(1, numberOfOutputs);
	}
	
	WireNode(Component componentA,int outputIndex ) {
		super(1, 0);
		inputs[0] = componentA.getOutput(outputIndex);
		inputsWires[0] = new Wire(componentA,outputIndex,this,0);
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
		outputsWires[numberOfOutputs-1] = new Wire(this,numberOfOutputs-1,component,inputIndex);
		updateOutputs();
		
		
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
