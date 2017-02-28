package Interface;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.FlowLayout;

public class CheckAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	public CheckAnswer(String s) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JCheckBox chckbxA = new JCheckBox(s);
		add(chckbxA);
		
		JTextPane txtpnRponseA = new JTextPane();
		txtpnRponseA.setText("R\u00E9ponse "+s);
		add(txtpnRponseA);

	}

}
