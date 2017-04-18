package Interface;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.FlowLayout;

public class CheckAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	public CheckAnswer() {
		this("A");
	}
	public CheckAnswer(String s) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JCheckBox chckbxA = new JCheckBox(s);
		add(chckbxA);
		
		//JTextPane txtpnRponseA = new JTextPane(); //retour a la ligne possible
		JTextField txtpnRponseA = new JTextField(); //retour a la ligne impossible
		txtpnRponseA.setText("R\u00E9ponse "+s);
		add(txtpnRponseA);

	}

}
