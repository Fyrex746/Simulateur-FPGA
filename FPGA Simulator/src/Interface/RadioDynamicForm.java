package Interface;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class RadioDynamicForm extends JPanel {

	/**
	 * Create the panel.
	 */
	protected int NbAnsw=3;
	public RadioDynamicForm(int NbAnsw) {
		setLayout(new GridLayout(NbAnsw, 1, 0, 0));
		for(int i=0;i<NbAnsw;i++){
			RadioAnswer checkAnswer = new RadioAnswer(Character.toString((char) (i+65)));
			add(checkAnswer);	
		}
	}
}