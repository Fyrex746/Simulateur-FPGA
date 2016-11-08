
public class LUT3 extends Component{

	protected boolean tab[];
	private int temporaire;
	private int i;
	
	LUT3() {
		super(3, 1);
		tab = new boolean[8];
	}
	
	protected void updateOutputs(){
//		temporaire=boolToBin(inputs[2])*4+boolToBin(inputs[1])*2+boolToBin(inputs[0]);
		temporaire=0;
//		for (i=0;i<3;i++){
//			if(inputs[i]){
//				temporaire+=Math.pow(2,i);
//			}
//		}
		//System.out.println(temporaire);
		if(inputs[2]) temporaire+=4;
		if(inputs[1]) temporaire+=2;
		if(inputs[0]) temporaire+=1;
		System.out.println(temporaire);
		System.out.println(tab[temporaire]);
		setOutput(tab[temporaire],0);
	}
	
	protected void setVal(boolean value, int index){
		//Change la valeur index du tableau
		tab[index] = value;
		updateOutputs();
	}
}
