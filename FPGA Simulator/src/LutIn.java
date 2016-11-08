
public class LutIn extends Component{

	protected boolean connection[];
	protected int selIn;
	
	LutIn(int i) {
		super(i, 1);
		connection=new boolean[i];
	}
	
	protected void updateOutputs(){
		setOutput(inputs[selIn],0);
	}
	
	protected void connectLut(int index){
		connection=new boolean[connection.length];
		connection[index]=true;
		selIn=index;
		updateOutputs();
	}
}
