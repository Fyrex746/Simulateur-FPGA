package Interface;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Exam.Question;
import Exam.QuestionQCM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.awt.FlowLayout;

public class RadioAnswer extends JPanel {

	/**
	 * Create the panel.
	 */
	protected JRadioButton rdbtn;
	private JTextPane txtpnRponse;
	private int pos;
	/*public RadioAnswer() {
		this("A", new Question());
	}*/
	public RadioAnswer(String s, Question qu, boolean isEditable) {
		pos=(int) s.charAt(0)-65;
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		rdbtn = new JRadioButton(s);
		rdbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isEditable){
					((QuestionQCM) qu.getQuParam()).setRightAnswers(new Boolean[((QuestionQCM) qu.getQuParam()).getNumberAnswers()]);
					Arrays.fill(((QuestionQCM) qu.getQuParam()).getRightAnswers(), Boolean.FALSE);
					((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]=rdbtn.isSelected();
				}
				else{
					((QuestionQCM) qu.getQuParam()).setSelectedAnswers(new Boolean[((QuestionQCM) qu.getQuParam()).getNumberAnswers()]);
					Arrays.fill(((QuestionQCM) qu.getQuParam()).getSelectedAnswers(), Boolean.FALSE);
					((QuestionQCM) qu.getQuParam()).getSelectedAnswers()[pos]=rdbtn.isSelected();
				}
				//System.out.println("Réponse "+s+": "+rdbtn.isSelected());
			}
		});
		if(isEditable) rdbtn.setSelected(((QuestionQCM) qu.getQuParam()).getRightAnswers()[pos]);
		add(rdbtn);
		
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
