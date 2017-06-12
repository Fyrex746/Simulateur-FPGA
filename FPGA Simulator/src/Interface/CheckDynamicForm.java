package Interface;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import Exam.Question;

public class CheckDynamicForm extends JPanel {
	/**
	 * Create the panel.
	 */
	private int NbAnsw=3;
	/*public CheckDynamicForm() {
		this(3, new Question());
	}*/
	public CheckDynamicForm(int NbAnsw, Question qu, boolean isEditable) {
		setLayout(new GridLayout(NbAnsw, 1, 0, 0));
		for(int i=0;i<NbAnsw;i++){
			CheckAnswer checkAnswer = new CheckAnswer(Character.toString((char) (i+65)), qu, isEditable);
			add(checkAnswer);
		}
	}

}
