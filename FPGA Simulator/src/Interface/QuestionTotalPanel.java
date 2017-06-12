package Interface;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Exam.Exercise;
import Exam.Question;

public class QuestionTotalPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/*public QuestionTotalPanel() {
		this(new Question());
	}*/
	public QuestionTotalPanel(Question qu,boolean isEditable) {
		setLayout(new BorderLayout(0, 0));
		
		EnoncePanel enoncePanel = new EnoncePanel(qu,isEditable);
		add(enoncePanel, BorderLayout.NORTH);
		
		SimulatorAnswerDynamicPanel simulatorAnswerDynamicPanel = new SimulatorAnswerDynamicPanel(qu,isEditable);
		add(simulatorAnswerDynamicPanel, BorderLayout.CENTER);		

	}

}
