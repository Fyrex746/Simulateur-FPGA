package Interface;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Exam.Question;

import javax.swing.JCheckBox;

public class SimulatorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField AnswNbBitsLUT;
	private JTextField AnswNbLUT;
	private JTextField AnswNbInputs;
	private int NbLut = 4;
	private int NbBitLut = 3;
	private int NbIn = 6;
	private JTextField txtL,textField;
	private JCheckBox chckbxActiverLeSimulateur,chckbxAfficherLeSimulateur;
	private JPanel SimulatorSettingsButtonPanel,checkboxVisibleSimulatorPanel;
	private JTabbedPane SimulatorChoicePanel;
	boolean isActive=true;
	
	/*public SimulatorPanel() {
		this(new Question(),true);
	}*/
	public SimulatorPanel(Question qu){
		this(qu, true);
	}
	public SimulatorPanel(Question qu,boolean Activer) {
		setLayout(new BorderLayout(0, 0));
		
		checkboxVisibleSimulatorPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) checkboxVisibleSimulatorPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(checkboxVisibleSimulatorPanel, BorderLayout.NORTH);
		
		chckbxActiverLeSimulateur = new JCheckBox("Activer le simulateur");
		chckbxActiverLeSimulateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxAfficherLeSimulateur.setVisible(chckbxActiverLeSimulateur.isSelected());
				qu.setUseSimulator(chckbxActiverLeSimulateur.isSelected());
				updatePanel();
			}
		});
		chckbxActiverLeSimulateur.setSelected(qu.getUseSimulator());
		if(Activer) checkboxVisibleSimulatorPanel.add(chckbxActiverLeSimulateur);
		
		chckbxAfficherLeSimulateur = new JCheckBox("Afficher le simulateur");
		chckbxAfficherLeSimulateur.setSelected(qu.getShowSimulator());
		chckbxAfficherLeSimulateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qu.setShowSimulator(chckbxAfficherLeSimulateur.isSelected());
				updatePanel();
			}
		});
		checkboxVisibleSimulatorPanel.add(chckbxAfficherLeSimulateur);
		
		SimulatorChoicePanel = new JTabbedPane(JTabbedPane.TOP);
		add(SimulatorChoicePanel, BorderLayout.CENTER);
		txtL = new JTextField();
		SimulatorChoicePanel.addTab("Etat initial", null, txtL, null);
		txtL.setHorizontalAlignment(SwingConstants.CENTER);
		txtL.setForeground(new Color(255, 255, 255));
		txtL.setBackground(new Color(0, 51, 204));
		txtL.setSelectedTextColor(Color.CYAN);
		txtL.setText("Simulateur \u00E0 ins\u00E9rer ici");
		txtL.setColumns(10);

		textField = new JTextField();
		SimulatorChoicePanel.addTab("R\u00E9sultat attendu", null, textField, null);
		textField.setText("Simulateur \u00E0 ins\u00E9rer ici");
		textField.setSelectedTextColor(Color.CYAN);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBackground(Color.GREEN);
		
		
		//------------------------------------------------------------------------------
		JPanel SimulatorSettingsPanel = new JPanel();
		SimulatorSettingsPanel.setVisible(false);
		SimulatorSettingsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel NbBitsLUTPanel = new JPanel();
		SimulatorSettingsPanel.add(NbBitsLUTPanel);
		NbBitsLUTPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label NbBitsLUT = new Label("Nombre de bits du LUT:");
		NbBitsLUTPanel.add(NbBitsLUT);

		AnswNbBitsLUT = new JTextField();
		NbBitsLUTPanel.add(AnswNbBitsLUT);
		AnswNbBitsLUT.setText(String.valueOf(NbBitLut));
		AnswNbBitsLUT.setColumns(10);

		JPanel NbLUTPanel = new JPanel();
		SimulatorSettingsPanel.add(NbLUTPanel);

		Label NbLUT = new Label("Nombre de LUTs:");
		NbLUTPanel.add(NbLUT);

		AnswNbLUT = new JTextField();
		NbLUTPanel.add(AnswNbLUT);
		AnswNbLUT.setText(String.valueOf(NbLut));
		AnswNbLUT.setColumns(10);

		JPanel NbInputsPanel = new JPanel();
		SimulatorSettingsPanel.add(NbInputsPanel);
		NbInputsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label NbInputs = new Label("Nombre d'entr\u00E9es:");
		NbInputsPanel.add(NbInputs);

		AnswNbInputs = new JTextField();
		NbInputsPanel.add(AnswNbInputs);
		AnswNbInputs.setText(String.valueOf(NbIn));
		AnswNbInputs.setColumns(10);
		//*/
		SimulatorSettingsButtonPanel = new JPanel();
		add(SimulatorSettingsButtonPanel, BorderLayout.SOUTH);
		FlowLayout flowLayout_3 = (FlowLayout) SimulatorSettingsButtonPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);

		JButton btnModifierLeSimulateur = new JButton("Modifier le simulateur");
		btnModifierLeSimulateur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimulatorSettingsPanel.setVisible(true);
				int result = JOptionPane.showConfirmDialog(null, SimulatorSettingsPanel, "",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					/*
					 * System.out.println("Nombre de bits pour le LUT: " +
					 * AnswNbBitsLUT.getText()); //si besoin affichage dans la console
					 * System.out.println("Nombre de LUTs: " +
					 * AnswNbLUT.getText());
					 * System.out.println("Nombre d'entrées: " +
					 * AnswNbInputs.getText());
					 */
					if(isInteger(AnswNbBitsLUT.getText()) && Integer.parseInt(AnswNbBitsLUT.getText())>0){
						NbBitLut = Integer.parseInt(AnswNbBitsLUT.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "Veuillez entrer un entier positif strictement!");
						AnswNbBitsLUT.setText(String.valueOf(NbBitLut));
					}
					if(isInteger(AnswNbInputs.getText()) && Integer.parseInt(AnswNbInputs.getText())>0){
						NbIn = Integer.parseInt(AnswNbInputs.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "Veuillez entrer un entier positif strictement!");
						AnswNbInputs.setText(String.valueOf(NbIn));
					}
					if(isInteger(AnswNbLUT.getText()) && Integer.parseInt(AnswNbLUT.getText())>0){
						NbLut = Integer.parseInt(AnswNbLUT.getText());
					}
					else{
						JOptionPane.showMessageDialog(null, "Veuillez entrer un entier positif strictement!");
						AnswNbLUT.setText(String.valueOf(NbLut));
					}
				} else {
					AnswNbBitsLUT.setText(String.valueOf(NbBitLut));
					AnswNbInputs.setText(String.valueOf(NbIn));
					AnswNbLUT.setText(String.valueOf(NbLut));
				}
				SimulatorSettingsPanel.setVisible(false);
			}
		});
		//SimulatorSettingsButtonPanel.add(btnModifierLeSimulateur); // a ajouter plus tard

		JButton btnRinitialiserSimulateur = new JButton("R\u00E9initialiser ce simulateur");
		SimulatorSettingsButtonPanel.add(btnRinitialiserSimulateur);
		btnRinitialiserSimulateur.setMinimumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.setMaximumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "R\u00E9initialiser le simulateur?", "",JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION){
					NbLut = 4;
					NbBitLut = 3;
					NbIn = 6;
					AnswNbInputs.setText(String.valueOf(NbIn));
					AnswNbLUT.setText(String.valueOf(NbLut));
					AnswNbBitsLUT.setText(String.valueOf(NbBitLut));
				}
				//JOptionPane.showMessageDialog(null, "R\u00E9initialisation du simulateur");
			}
		});
		updatePanel();
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
	private void updatePanel(){
		remove(SimulatorSettingsButtonPanel);
		remove(SimulatorChoicePanel);
		remove(checkboxVisibleSimulatorPanel);
		if(chckbxActiverLeSimulateur.isSelected() && chckbxAfficherLeSimulateur.isSelected()){
			isActive=true;
			add(checkboxVisibleSimulatorPanel, BorderLayout.NORTH);
			add(SimulatorChoicePanel, BorderLayout.CENTER);
			add(SimulatorSettingsButtonPanel, BorderLayout.SOUTH);
		}
		else{
			isActive=false;
			add(checkboxVisibleSimulatorPanel, BorderLayout.CENTER);
		}
		//System.out.println("SimulatorPanel: "+isActive);
		revalidate();
		repaint();
		setVisible(false);
		setVisible(true);
	}
}