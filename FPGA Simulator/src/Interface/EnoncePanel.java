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
	public EnoncePanel(int nbEx, int nbQu, int nbSsQu, Question qu) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel NumerotationPanel = new JPanel();
		add(NumerotationPanel, BorderLayout.NORTH);
		NumerotationPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel ExNbPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) ExNbPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		NumerotationPanel.add(ExNbPanel, BorderLayout.NORTH);
		
		JLabel lblExercice = new JLabel("Exercice "+nbEx);
		ExNbPanel.add(lblExercice);
		
		//JTextArea txtrTitreDeLexercice = new JTextArea(); //retour a la ligne possible
		JTextField txtrTitreDeLexercice = new JTextField(); //retour a la ligne impossible
		txtrTitreDeLexercice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				qu.getExercice().setTitle(txtrTitreDeLexercice.getText());
			}
		});
		ExNbPanel.add(txtrTitreDeLexercice);
		txtrTitreDeLexercice.setText("Titre de l'exercice");
		qu.getExercice().setTitle(txtrTitreDeLexercice.getText());
		
		JPanel QuNbPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) QuNbPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		NumerotationPanel.add(QuNbPanel, BorderLayout.SOUTH);
		
		JLabel lblQuestion;
		if(nbSsQu<1){
			lblQuestion = new JLabel("Question "+nbQu);
		}
		else{
			lblQuestion = new JLabel("Question "+nbQu+"."+nbSsQu);
		}
		QuNbPanel.add(lblQuestion);
		
		//JTextArea txtrTitreDeLa = new JTextArea(); //retour a la ligne possible
		JTextField txtrTitreDeLa = new JTextField(); //retour a la ligne impossible
		txtrTitreDeLa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				qu.setTitle(txtrTitreDeLa.getText());
			}
		});
		txtrTitreDeLa.setText("Titre de la question (si n\u00E9cessaire)");
		qu.setTitle(txtrTitreDeLa.getText());
		QuNbPanel.add(txtrTitreDeLa);
		
		JTextArea enonce = new JTextArea();
		enonce.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				qu.setDescription(enonce.getText());
			}
		});
		enonce.setBackground(Color.LIGHT_GRAY);
		enonce.setText("Entrer l'\u00E9nonc\u00E9 de la question ici");
		enonce.setLineWrap(true);
		enonce.setWrapStyleWord(true);
		qu.setDescription(enonce.getText());
		//add(enonce, BorderLayout.CENTER);

		JScrollPane jsp = new JScrollPane (enonce);
		jsp.setPreferredSize(new Dimension(10,50));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    add(jsp, BorderLayout.CENTER);
	}

}
