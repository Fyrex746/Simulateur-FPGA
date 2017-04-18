package Interface;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class RadioAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	protected JRadioButton rdbtn;
	private JTextPane txtpnRponse;
	public RadioAnswer() {
		this("A");
	}
	public RadioAnswer(String s) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		rdbtn = new JRadioButton(s);
		add(rdbtn);
		
		//JTextPane txtpnRponse = new JTextPane(); //retour a la ligne possible
		JTextField txtpnRponse = new JTextField(); //retour a la ligne impossible
		txtpnRponse.setText("R\u00E9ponse "+s);
		add(txtpnRponse);

	}

}
