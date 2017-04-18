package Interface;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnswerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private int NbPossibleAns;
	private JTextField NbQCMAns;
	private boolean PossibleMultipleAnsw;
	private String typeReponse;
	private JComboBox AnswerType;
	private JCheckBox chckbxRponsesMultiples;
	private JPanel currentPanel;
	private JScrollPane jsp;
	
	public AnswerPanel(){
		this(3);
	}
	public AnswerPanel(int NbAnsInitial) {
		if(NbAnsInitial>26 || NbAnsInitial<2){
			NbPossibleAns=3;
		}
		else{
			NbPossibleAns=NbAnsInitial;
		}
		setLayout(new BorderLayout(0, 0));
		
		JPanel AnswerSettingsPanel = new JPanel();
		AnswerSettingsPanel.setVisible(false);
		add(AnswerSettingsPanel, BorderLayout.EAST);
		AnswerSettingsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxRponsesMultiples = new JCheckBox("R\u00E9ponses multiples");
		chckbxRponsesMultiples.setSelected(true); //valeur par défaut
		AnswerSettingsPanel.add(chckbxRponsesMultiples);
		
		JPanel NbAnsPanel = new JPanel();
		AnswerSettingsPanel.add(NbAnsPanel);
		
		JLabel lblNombreDeRponses = new JLabel("Nombre de r\u00E9ponses:");
		NbAnsPanel.add(lblNombreDeRponses);
		
		NbQCMAns = new JTextField();
		NbQCMAns.setText(String.valueOf(NbPossibleAns));
		NbAnsPanel.add(NbQCMAns);
		NbQCMAns.setColumns(10);
		
		JLabel lblAttentionLeBouton = new JLabel("Attention, le bouton OK r\u00E9initialisera le formulaire!");
		AnswerSettingsPanel.add(lblAttentionLeBouton);
		
		JPanel AnswerTypeSettingsPanel = new JPanel();
		add(AnswerTypeSettingsPanel, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) AnswerTypeSettingsPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		AnswerType = new JComboBox();
		AnswerType.setMaximumRowCount(3);
		AnswerType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				typeReponse = arg0.getItem().toString();
				updateCentralPanel();
				//JOptionPane.showMessageDialog(null, typeReponse);
			}
		});
		AnswerType.setModel(new DefaultComboBoxModel(new String[] {"QCM", "Zone de texte", "R\u00E9ponse sur le simulateur"}));
		AnswerType.setToolTipText("");
		AnswerTypeSettingsPanel.add(AnswerType);
		
		JButton AnswerSettings = new JButton("Param\u00E8tres");
		AnswerSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (AnswerType.getSelectedItem() == "QCM") {
					AnswerSettingsPanel.setVisible(true);
					int result = JOptionPane.showConfirmDialog(null, AnswerSettingsPanel, "", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						PossibleMultipleAnsw = chckbxRponsesMultiples.isSelected();
						if(isInteger(NbQCMAns.getText()) && Integer.parseInt(NbQCMAns.getText())>1 && Integer.parseInt(NbQCMAns.getText())<27){
							NbPossibleAns = Integer.parseInt(NbQCMAns.getText());
						}
						else{
							JOptionPane.showMessageDialog(null, "Veuillez entrer un entier entre 2 et 26");
							NbQCMAns.setText(String.valueOf(NbPossibleAns));
						}
					} else {
						NbQCMAns.setText(String.valueOf(NbPossibleAns));
						if (PossibleMultipleAnsw) {
							chckbxRponsesMultiples.setSelected(true);
						} else {
							chckbxRponsesMultiples.setSelected(false);
						}
					}
					AnswerSettingsPanel.setVisible(false);
					updateCentralPanel();
				} else {
					JOptionPane.showMessageDialog(null, "Pas de r\u00E9glages possibles");
				}
			}
		});
		AnswerTypeSettingsPanel.add(AnswerSettings);
		currentPanel=new JPanel();
		jsp = new JScrollPane (currentPanel);
		add(jsp, BorderLayout.CENTER);
		updateCentralPanel();
	}
	private void updateCentralPanel(){
		remove(currentPanel);
		remove(jsp);
		if (AnswerType.getSelectedItem() == "QCM"){
			if(chckbxRponsesMultiples.isSelected()){
				CheckDynamicForm checkDynamicForm= new CheckDynamicForm(NbPossibleAns);
				currentPanel=checkDynamicForm;
				add(currentPanel, BorderLayout.CENTER);
			}
			else{
				RadioDynamicForm radioDynamicForm= new RadioDynamicForm(NbPossibleAns);
				currentPanel=radioDynamicForm;
				add(currentPanel, BorderLayout.CENTER);
			}
		}
		else if(AnswerType.getSelectedItem() == "Zone de texte"){
			JTextArea txtrTextarea = new JTextArea();
			txtrTextarea.setText("Entrer la réponse");
			txtrTextarea.setBackground(Color.LIGHT_GRAY);
			currentPanel=new JPanel();
			currentPanel.setLayout(new BorderLayout());
	        currentPanel.add(BorderLayout.CENTER, txtrTextarea);
			add(currentPanel, BorderLayout.CENTER);
		};
		revalidate();
		currentPanel.setVisible(false);
		currentPanel.setVisible(true);
		jsp = new JScrollPane (currentPanel);
		jsp.setPreferredSize(new Dimension(10,105));
		if(AnswerType.getSelectedItem() == "R\u00E9ponse sur le simulateur") jsp.setPreferredSize(new Dimension(0,0));
	    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    add(jsp, BorderLayout.CENTER);
	}
	public static boolean isInteger(final String strInput) {
	    boolean ret = true;
	    try {
	        Integer.parseInt(strInput);
	    } catch (final NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
}
	