package Interface;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuestionTotalPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuestionTotalPanel() {
		this(1,1);
	}
	public QuestionTotalPanel(int nbEx, int nbQu) {
		setLayout(new BorderLayout(0, 0));
		
		EnoncePanel enoncePanel = new EnoncePanel(nbEx,nbQu);
		add(enoncePanel, BorderLayout.NORTH);
		
		SimulatorAnswerDynamicPanel simulatorAnswerDynamicPanel = new SimulatorAnswerDynamicPanel();
		add(simulatorAnswerDynamicPanel, BorderLayout.CENTER);
		

	}

}
