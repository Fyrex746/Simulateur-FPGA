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
	public QuestionTotalPanel() {
		this(1,1,0, new Question());
	}
	public QuestionTotalPanel(int nbEx, int nbQu, int nbSsQu, Question qu) {
		setLayout(new BorderLayout(0, 0));
		
		EnoncePanel enoncePanel = new EnoncePanel(nbEx,nbQu, nbSsQu, qu);
		add(enoncePanel, BorderLayout.NORTH);
		
		SimulatorAnswerDynamicPanel simulatorAnswerDynamicPanel = new SimulatorAnswerDynamicPanel(qu);
		add(simulatorAnswerDynamicPanel, BorderLayout.CENTER);		

	}

}
