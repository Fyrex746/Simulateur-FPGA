
public class LUT3 extends Component{

	protected boolean[] tab= new boolean[8];
	private int temporaire;
	
	LUT3() {
		super(3, 1);
		tab = new boolean[8];
		updateOutputs();
		}
	
	protected void updateOutputs(){
		temporaire=0;
		if(inputs[0]) temporaire+=4;//MSB à gauche, en 0
		if(inputs[1]) temporaire+=2;
		if(inputs[2]) temporaire+=1;//LSB à droite, en 2
		setOutput(tab[temporaire],0);
	}
	
	protected void setVal(boolean value, int index){
		//Change la valeur index du tableau
		tab[index] = value;
		updateOutputs();
	}
	public void setVals(String str){
		if(str.length() == 8){
			setVals(str,0);
		}else{
			System.out.println("Incorrect lenght of Inputs string");
		}
	}
	public void setVals(String str,int beginningIndex){
		if(beginningIndex + str.length() <= 8){
			for(int i=beginningIndex; i<beginningIndex+str.length(); i++){
				if(str.charAt(i) == '1'){
					tab[i] = true;
				}else if(str.charAt(i) == '0'){
					tab[i] = false;
				}else{
					System.out.println("Incorrect caracter in Inputs string");
				}
			}
		}else{
			System.out.println("Incorrect lenght of Inputs string");
		}
		updateOutputs();
	}
}
