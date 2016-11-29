package component;
//import java.util.*;


abstract class Component {
	protected int numberOfInputs;
	protected boolean inputs[];
	Wire[] inputsWires;
	
	protected int numberOfOutputs;
	protected boolean outputs[];
	Wire[] outputsWires;
	
	//Inits
	Component(int i,int o){
		numberOfInputs = i;
		inputs = new boolean[numberOfInputs];
		inputsWires = new Wire[numberOfInputs];
		
		numberOfOutputs = o;
		outputs = new boolean[numberOfOutputs];
		outputsWires = new Wire[numberOfOutputs];
	}

	//Inputs functions
	public void setInput(boolean value, int index){
			inputs[index] = value;
			updateOutputs();
	}
	public boolean getInput(int index){
		return inputs[index];
	}
	public int getNumberOfOutputs(){
		return numberOfOutputs;
	}
	public void setInputs(String str){
		if(str.length() == numberOfInputs){
			setInputs(str,0);
		}else{
			System.out.println("Incorrect lenght of Inputs string");
		}
	}
	public void setInputs(String str,int beginningIndex){
		if(beginningIndex + str.length() <= numberOfInputs){
			for(int i=beginningIndex; i<beginningIndex+str.length(); i++){
				if(str.charAt(i) == '1'){
					inputs[i] = true;
				}else if(str.charAt(i) == '0'){
					inputs[i] = false;
				}else{
					System.out.println("Incorrect caracter in Inputs string");
				}
			}
		}else{
			System.out.println("Incorrect lenght of Inputs string");
		}
		updateOutputs();
	}
	public String getInputs(){
		String str = new String();
		for(int i=0; i<+numberOfInputs;i++){
			if(inputs[i]){
				str += "1";
			}else{
				str += "0";
			}
		}
		return str;
	}
	
	//Outputs functions
	protected void setOutput(boolean value, int index){
		//System.out.println("set output n°"+index+" to "+value);
		outputs[index] = value;
		if(outputsWires[index] != null){
			outputsWires[index].transfertSignal();
		}
	}
	public boolean getOutput(int index){
		return outputs[index];
	}
	public int getNumberOfInputs(){
		return numberOfInputs;
	}
	public String getOutputs(){
		String str = new String();
		for(int i=0; i<+numberOfOutputs;i++){
			if(outputs[i]){
				str += "1";
			}else{
				str += "0";
			}
		}
		return str;
	}
	
	//Disconnect Wire
	public void disconnectInput(int index){
		if(inputsWires[index] != null){
			inputsWires[index].disconect();
		}
	}
	public void disconnectOutput(int index){
		if(outputsWires[index] != null){
			outputsWires[index].disconect();
		}
	}
	
	// Logic of component
	protected void updateOutputs(){}
	
	
	//use to print component in console and debug
	public String toString(){
		String motif = new String();
		
		//Draw rect
		int rectH = 2 * Math.max(numberOfInputs, numberOfOutputs) +1;
		int rectL = 5;
		String rect[] = new String[rectH];
		for(int i = 0; i<rectH; i++){
			String line = new String();
			if(i==0 || i==rectH-1){
				line += "+";
				for(int j = 0; j<rectL-2; j++){line += "-";}
				line += "+";
			}else{
				line += "|";
				for(int j = 0; j<rectL-2; j++){line += " ";}
				line += "|";
			}
			rect[i] = line;
		}
		

		
		//Draw Inputs
		String inputs[] = new String[rectH];
		int inputsL = 4;
		int inputToDrawNumber = 0;
		for(int i = 0; i<rectH; i++){
			String line = new String();
			if(numberOfInputs>numberOfOutputs){
				if(i == 1+2*inputToDrawNumber){
					line += boolToBinString(this.inputs[inputToDrawNumber]);
					for(int j = 0; j<inputsL-1; j++){line += "-";}
					inputToDrawNumber += 1;
				}else{
					for(int j = 0; j<inputsL; j++){line += " ";}
				}
			}else{
				if(i == (rectH/numberOfInputs+1)*(inputToDrawNumber+1) && inputToDrawNumber<numberOfInputs){
					line += boolToBinString(this.inputs[inputToDrawNumber]);
					for(int j = 0; j<inputsL-1; j++){line += "-";}
					inputToDrawNumber += 1;
				}else{
					for(int j = 0; j<inputsL; j++){line += " ";}
				}
			}
			inputs[i] = line;
		}
		
		//Draw Outputs
		String outputs[] = new String[rectH];
		int outputsL = 4;
		int outputToDrawNumber = 0;
		for(int i = 0; i<rectH; i++){
			String line = new String();
			if(numberOfOutputs>numberOfInputs){
				if(i == 1+2*outputToDrawNumber){
					for(int j = 0; j<outputsL-1; j++){line += "-";}
					line += boolToBinString(this.outputs[outputToDrawNumber]);
					outputToDrawNumber += 1;
				}else{
					for(int j = 0; j<outputsL; j++){line += " ";}
				}
			}else{
				if(i == (rectH/numberOfInputs+1)*(outputToDrawNumber+1) && outputToDrawNumber<numberOfOutputs){
					for(int j = 0; j<outputsL-1; j++){line += "-";}
					line += boolToBinString(this.outputs[outputToDrawNumber]);
					outputToDrawNumber += 1;
				}else{
					for(int j = 0; j<outputsL; j++){line += " ";}
				}
			}
			outputs[i] = line;
		}
		
		
		
		for(int i =0; i< rectH; i++){
			motif += inputs[i] + rect[i] + outputs[i] + "\n";
		}
		return motif;
		
	}


	//Utility
	private String boolToBinString(boolean bool){ return bool? "1":"0";}
	private boolean binStringToBool(String str){
		if(str == "1") {return true;}
		else if(str == "1") {return false;}
		else{
			System.out.println("Incorrect argument");
			return false;
		}
	}


}
