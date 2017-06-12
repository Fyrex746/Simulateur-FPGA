package Interface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Exam.Exercise;
import Exam.Question;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnoncePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	/*public EnoncePanel() {
		this(1,1,0, new Question());
	}*/
	public EnoncePanel(Question qu,boolean isEditable) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel NumerotationPanel = new JPanel();
		add(NumerotationPanel, BorderLayout.NORTH);
		NumerotationPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel ExNbPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) ExNbPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		NumerotationPanel.add(ExNbPanel, BorderLayout.NORTH);
		
		JLabel lblExercice = new JLabel("Exercice "+qu.getExercice().getExNb());
		ExNbPanel.add(lblExercice);
		
		//JTextArea txtrTitreDeLexercice = new JTextArea(); //retour a la ligne possible
		JTextField txtrTitreDeLexercice = new JTextField(); //retour a la ligne impossible
		txtrTitreDeLexercice.setEditable(isEditable);
		txtrTitreDeLexercice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				qu.getExercice().setTitle(txtrTitreDeLexercice.getText());
			}
		});
		txtrTitreDeLexercice.setText(qu.getExercice().getTitle());
		if(!isEditable && txtrTitreDeLexercice.getText().contains("Titre de l'exercice")){
			txtrTitreDeLexercice.setVisible(false);
		}
		ExNbPanel.add(txtrTitreDeLexercice);
		
		JPanel QuNbPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) QuNbPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		NumerotationPanel.add(QuNbPanel, BorderLayout.SOUTH);
		
		JLabel lblQuestion;
		if(qu.getSsQuNb()<1){
			lblQuestion = new JLabel("Question "+qu.getQuNb());
		}
		else{
			lblQuestion = new JLabel("Question "+qu.getQuNb()+"."+qu.getSsQuNb());
		}//*/
		QuNbPanel.add(lblQuestion);
		
		//JTextArea txtrTitreDeLa = new JTextArea(); //retour a la ligne possible
		JTextField txtrTitreDeLa = new JTextField(); //retour a la ligne impossible
		txtrTitreDeLa.setEditable(isEditable);
		txtrTitreDeLa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				qu.setTitle(txtrTitreDeLa.getText());
			}
		});
		txtrTitreDeLa.setText(qu.getTitle());
		if(!isEditable && txtrTitreDeLa.getText().contains("Titre de la question")){
			txtrTitreDeLa.setVisible(false);
		}
		QuNbPanel.add(txtrTitreDeLa);
		
		JTextArea enonce = new JTextArea();
		enonce.setEditable(false);
		enonce.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				qu.setDescription(enonce.getText());
			}
		});
		enonce.setBackground(Color.LIGHT_GRAY);
		enonce.setText(qu.getDescription());
		enonce.setLineWrap(true);
		enonce.setWrapStyleWord(true);
		//add(enonce, BorderLayout.CENTER);

		JScrollPane jsp = new JScrollPane (enonce);
		jsp.setPreferredSize(new Dimension(10,50));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    add(jsp, BorderLayout.CENTER);
	}

}
