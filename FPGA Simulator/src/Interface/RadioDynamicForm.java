package Interface;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class RadioDynamicForm extends JPanel {

	/**
	 * Create the panel.
	 */
	private int NbAnsw;
	private final ButtonGroup Answers = new ButtonGroup();
	public RadioDynamicForm() {
		this(3);
	}
	public RadioDynamicForm(int NbAnsw) {
		setLayout(new GridLayout(NbAnsw, 1, 0, 0));
		for(int i=0;i<NbAnsw;i++){
			RadioAnswer checkAnswer = new RadioAnswer(Character.toString((char) (i+65)));
			Answers.add(checkAnswer.rdbtn);
			add(checkAnswer);	
		}
	}
}