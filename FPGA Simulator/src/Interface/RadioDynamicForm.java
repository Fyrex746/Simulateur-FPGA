package Interface;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import Exam.Question;

public class RadioDynamicForm extends JPanel {

	/**
	 * Create the panel.
	 */
	private final ButtonGroup Answers = new ButtonGroup();

	public RadioDynamicForm(int NbAnsw, Question qu, boolean isEditable) {
		setLayout(new GridLayout(NbAnsw, 1, 0, 0));
		for(int i=0;i<NbAnsw;i++){
			RadioAnswer checkAnswer = new RadioAnswer(Character.toString((char) (i+65)), qu, isEditable);
			Answers.add(checkAnswer.rdbtn);
			add(checkAnswer);	
		}
	}
}