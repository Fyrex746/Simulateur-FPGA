package Interface;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

import Exam.Question;
import Exam.QuestionQCM;
import Exam.QuestionText;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	private int pos;
	/*public CheckAnswer() {
		this("A",new Question());
	}*/
	public CheckAnswer(String s, Question qu) {
		pos=(int) s.charAt(0)-65;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JCheckBox chckbxA = new JCheckBox(s);
		chckbxA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]=chckbxA.isSelected();
				System.out.println("Réponse "+s+": "+chckbxA.isSelected());
			}
		});
		chckbxA.setSelected(((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]);
		add(chckbxA);
		
		//JTextPane txtpnRponseA = new JTextPane(); //retour a la ligne possible
		JTextField txtpnRponseA = new JTextField(); //retour a la ligne impossible
		txtpnRponseA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				((QuestionQCM) qu.getQuParam()).getChoiceDescription()[pos]=txtpnRponseA.getText();
				System.out.println("Réponse "+s+": "+txtpnRponseA.getText()); 
			}
		});
		//txtpnRponseA.setText("R\u00E9ponse "+s);
		txtpnRponseA.setText(" "+((QuestionQCM)qu.getQuParam()).getChoiceDescription()[pos]);
		add(txtpnRponseA);

	}

}
