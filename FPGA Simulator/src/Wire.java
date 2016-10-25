//import java.util.*;

public class Wire {
	// Connect the output of the component A to input of component B
	private boolean transmitedValue;
	private Component componentA;
	private int outputIndex;
	private Component componentB;
	private int inputIndex;
	
	
	Wire(Component componentA,int outputIndex,Component componentB,int inputIndex){
		setcomponentA(componentA,outputIndex);
		setcomponentB(componentB,inputIndex);
		transfertSignal();	//Rajouté
	}
	
	public boolean getValue(){
		return transmitedValue;
	}
	public void setcomponentA(Component component,int index){
		if(component != componentA){
			componentA.outputsWires[outputIndex] = null;
		}
		componentA = component;
		outputIndex = index;
		componentA.outputsWires[outputIndex] = this;
	}
	public void setcomponentB(Component component,int index){
		if(component != componentB){
			componentB.inputsWires[inputIndex] = null;
		}
		componentB = component;
		outputIndex = index;
		componentB.inputsWires[inputIndex] = this;
	}
	public void transfertSignal(){
		transmitedValue = componentA.getOutput(outputIndex);
		componentB.setInput(transmitedValue, inputIndex);	
	}
	public void disconect(){
		this.componentA.outputsWires[this.outputIndex] = null;
		this.componentB.outputsWires[this.inputIndex] = null;
	}
}
