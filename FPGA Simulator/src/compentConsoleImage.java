

public class compentConsoleImage {
	private String[] imageTab;
	private int nbrLine;
	
	compentConsoleImage(Component component){
		nbrLine = Math.max(component.numberOfInputs, component.numberOfOutputs);
		imageTab = new String[nbrLine];
	}
	
	//Modify image
	private void addStringAtBegin(String str){
		for(int i =0; i< nbrLine; i++){
			addStringAtBeginOfLine(str,i);
		}
	}
	private void addStringAtBeginOfLine(String str,int index){
		imageTab[index] = str + imageTab[index];
	}
	
	private void addStringAtEnd(String str){
		for(int i =0; i< nbrLine; i++){
			addStringAtEndOfLine(str,i);
		}
	}
	private void addStringAtEndOfLine(String str,int index){
		imageTab[index] += str;
	}

	
	//
	public String toString() {
		String temp = new String();
		for(int i =0; i< nbrLine; i++){
			String tempLine = new String();
			for(int j =0; j< nbrLine; j++){}
			temp += tempLine + "\n";
		}
		return temp;
	}
	
}
