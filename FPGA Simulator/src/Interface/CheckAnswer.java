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
import java.util.Arrays;

public class CheckAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	private int pos;
	/*public CheckAnswer() {
		this("A",new Question());
	}*/
	public CheckAnswer(String s, Question qu,boolean isEditable) {
		pos=(int) s.charAt(0)-65;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JCheckBox chckbx = new JCheckBox(s);
		chckbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isEditable) ((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]=chckbx.isSelected();
				else ((QuestionQCM) qu.getQuParam()).getSelectedAnswers()[pos]=chckbx.isSelected();
				//System.out.println("Réponse "+s+": "+chckbx.isSelected());
			}
		});
		if(isEditable)chckbx.setSelected(((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]);
		add(chckbx);
		
		//JTextPane txtpnRponse = new JTextPane(); //retour a la ligne possible
		JTextField txtpnRponse = new JTextField(); //retour a la ligne impossible
		txtpnRponse.setEditable(isEditable);
		txtpnRponse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				((QuestionQCM) qu.getQuParam()).getChoiceDescription()[pos]=txtpnRponse.getText();
				//System.out.println("Réponse "+s+": "+txtpnRponse.getText()); 
			}
		});
		//txtpnRponse.setText("R\u00E9ponse "+s);
		txtpnRponse.setText(" "+((QuestionQCM)qu.getQuParam()).getChoiceDescription()[pos]);
		add(txtpnRponse);

	}

}
