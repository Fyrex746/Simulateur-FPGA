package Interface;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class RadioAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	public RadioAnswer(String s) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JRadioButton rdbtnA = new JRadioButton(s);
		add(rdbtnA);
		
		JTextPane txtpnRponseA = new JTextPane();
		txtpnRponseA.setText("R\u00E9ponse "+s);
		add(txtpnRponseA);

	}

}
