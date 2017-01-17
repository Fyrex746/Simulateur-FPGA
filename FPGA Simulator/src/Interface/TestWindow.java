package Interface;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Choice;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Cursor;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TestWindow {

	private JFrame frmTest;
	/**
	 * @wbp.nonvisual location=81,-1
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("Joli titre");
	private JTextField txtL;
	private final ButtonGroup ExerciseMode = new ButtonGroup();
	private final ButtonGroup Answers = new ButtonGroup();
	private JTextField textField;
	private String typeReponse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setTitle("Fenetre de test");
		frmTest.setBounds(0, 0, 3840, 2160);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel LeftPanel = new JPanel();
		frmTest.getContentPane().add(LeftPanel, BorderLayout.WEST);
		LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.PAGE_AXIS));
		
		JCheckBox chckbxAfficherSimulateur = new JCheckBox("Afficher simulateur");
		chckbxAfficherSimulateur.setSelected(true);
		LeftPanel.add(chckbxAfficherSimulateur);
		
		JTree tree = new JTree();
		tree.setAlignmentY(Component.TOP_ALIGNMENT);
		tree.setAlignmentX(Component.LEFT_ALIGNMENT);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Table des mati\u00E8res") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Exercice 1");
						node_1.add(new DefaultMutableTreeNode("Question 1"));
						node_1.add(new DefaultMutableTreeNode("Question 2"));
						node_1.add(new DefaultMutableTreeNode("+Ajouter une question"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Exercice 2");
						node_1.add(new DefaultMutableTreeNode("Question 1"));
						node_1.add(new DefaultMutableTreeNode("Question 2"));
						node_1.add(new DefaultMutableTreeNode("+Ajouter une question"));
					add(node_1);
					add(new DefaultMutableTreeNode("+Ajouter un exercice"));
				}
			}
		));
		LeftPanel.add(tree);
		//JScrollPane scrollPane = new JScrollPane(tree);
		//leftPanel.add(scrollPane);
		
		/*ImageIcon imageIcon = new ImageIcon();
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(imageIcon);*/
		
		JPanel CenterPanel = new JPanel();
		frmTest.getContentPane().add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel SouthPanel = new JPanel();
		CenterPanel.add(SouthPanel, BorderLayout.SOUTH);
		SouthPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel SimulatorAnswerPanel = new JPanel();
		CenterPanel.add(SimulatorAnswerPanel, BorderLayout.CENTER);
		SimulatorAnswerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel AnswerPanel = new JPanel();
		SimulatorAnswerPanel.add(AnswerPanel, BorderLayout.SOUTH);
		AnswerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		AnswerPanel.add(panel);
		
		JButton btnModifierLeSimulateur = new JButton("Modifier le simulateur");
		btnModifierLeSimulateur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture des param\u00E8tres du simulateur");
			}
		});
		panel.add(btnModifierLeSimulateur);
		
		JButton btnRinitialiserSimulateur = new JButton("R\u00E9initialiser ce simulateur");
		panel.add(btnRinitialiserSimulateur);
		btnRinitialiserSimulateur.setMinimumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.setMaximumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "R\u00E9initialisation du simulateur");
			}
		});
		
		JPanel AnswerTypePanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) AnswerTypePanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		AnswerPanel.add(AnswerTypePanel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				typeReponse=arg0.getItem().toString();
				JOptionPane.showMessageDialog(null, typeReponse);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"QCM", "Zone de texte", "R\u00E9ponse sur simulateur", "Checkbox"}));
		comboBox.setToolTipText("");
		AnswerTypePanel.add(comboBox);
		
		JButton btnParamtres = new JButton("Param\u00E8tres");
		btnParamtres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Param\u00E8tres de la zone");
			}
		});
		AnswerTypePanel.add(btnParamtres);
		
		JPanel ReponseA = new JPanel();
		FlowLayout fl_ReponseA = (FlowLayout) ReponseA.getLayout();
		fl_ReponseA.setAlignment(FlowLayout.LEFT);
		AnswerPanel.add(ReponseA);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		ReponseA.add(rdbtnA);
		Answers.add(rdbtnA);
		
		JTextPane txtpnRponse = new JTextPane();
		ReponseA.add(txtpnRponse);
		txtpnRponse.setText("R\u00E9ponse 1");
		
		JPanel ReponseB = new JPanel();
		FlowLayout fl_ReponseB = (FlowLayout) ReponseB.getLayout();
		fl_ReponseB.setAlignment(FlowLayout.LEFT);
		AnswerPanel.add(ReponseB);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		ReponseB.add(rdbtnB);
		Answers.add(rdbtnB);
		
		JTextPane txtpnRponse_1 = new JTextPane();
		ReponseB.add(txtpnRponse_1);
		txtpnRponse_1.setText("R\u00E9ponse 2");
		
		JPanel ReponseC = new JPanel();
		FlowLayout fl_ReponseC = (FlowLayout) ReponseC.getLayout();
		fl_ReponseC.setAlignment(FlowLayout.LEFT);
		AnswerPanel.add(ReponseC);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		ReponseC.add(rdbtnC);
		Answers.add(rdbtnC);
		
		JTextPane txtpnRponse_2 = new JTextPane();
		ReponseC.add(txtpnRponse_2);
		txtpnRponse_2.setText("R\u00E9ponse 3");
		
		JTabbedPane SimulatorChoice = new JTabbedPane(JTabbedPane.TOP);
		SimulatorAnswerPanel.add(SimulatorChoice, BorderLayout.CENTER);
		
		txtL = new JTextField();
		SimulatorChoice.addTab("Etat initial", null, txtL, null);
		txtL.setHorizontalAlignment(SwingConstants.CENTER);
		txtL.setForeground(new Color(255, 255, 255));
		txtL.setBackground(new Color(0, 51, 204));
		txtL.setSelectedTextColor(Color.CYAN);
		txtL.setText("Simulateur \u00E0 ins\u00E9rer ici");
		txtL.setColumns(10);
		
		textField = new JTextField();
		SimulatorChoice.addTab("R\u00E9sultat attendu", null, textField, null);
		textField.setText("Simulateur \u00E0 ins\u00E9rer ici");
		textField.setSelectedTextColor(Color.CYAN);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBackground(Color.GREEN);
		
		JPanel EnoncePanel = new JPanel();
		CenterPanel.add(EnoncePanel, BorderLayout.NORTH);
		EnoncePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel ExerciceNbTitlePanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) ExerciceNbTitlePanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		EnoncePanel.add(ExerciceNbTitlePanel);
		
		JLabel lblExercice = new JLabel("Exercice 1");
		ExerciceNbTitlePanel.add(lblExercice);
		lblExercice.setAutoscrolls(true);
		lblExercice.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JTextPane txtpnTitreDeLexercice = new JTextPane();
		txtpnTitreDeLexercice.setText("Titre de l'exercice");
		ExerciceNbTitlePanel.add(txtpnTitreDeLexercice);
		
		JPanel QuestionNbTitlePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) QuestionNbTitlePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		EnoncePanel.add(QuestionNbTitlePanel);
		
		JLabel lblQuestion = new JLabel("Question 1");
		QuestionNbTitlePanel.add(lblQuestion);
		
		JTextPane txtpnTitreDeLa = new JTextPane();
		txtpnTitreDeLa.setText("Titre de la question(si n\u00E9cessaire, ne pas toucher sinon)");
		QuestionNbTitlePanel.add(txtpnTitreDeLa);
		
		JTextPane Enoncé = new JTextPane();
		Enoncé.setText("Entrer l'\u00E9nonc\u00E9 de la question");
		EnoncePanel.add(Enoncé);
		
		JMenuBar menuBar = new JMenuBar();
		frmTest.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mntmNouveau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture d'un nouveau fichier");
			}
		});
		mnFichier.add(mntmNouveau);
		
		JMenuItem mntmOuvrir = new JMenuItem("Ouvrir");
		mntmOuvrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture de votre fichier");
			}
		});
		mnFichier.add(mntmOuvrir);
		
		JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
		mntmEnregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enregistrement de votre fichier");
			}
		});
		mnFichier.add(mntmEnregistrer);
		
		JCheckBoxMenuItem chckbxmntmEnregistrementAuto = new JCheckBoxMenuItem("Enregistrement auto");
		mnFichier.add(chckbxmntmEnregistrementAuto);
		chckbxmntmEnregistrementAuto.setSelected(true);
		
		JMenu mnModifier = new JMenu("Modifier");
		menuBar.add(mnModifier);
		
		JMenuItem mntmModifierLeFormulaire = new JMenuItem("Modifier le formulaire de contact");
		mnModifier.add(mntmModifierLeFormulaire);
		mntmModifierLeFormulaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ca s'ouvre");
			}
		});
		
		JMenu mnMode = new JMenu("Mode");
		menuBar.add(mnMode);
		
		JRadioButtonMenuItem rdbtnmntmExamen = new JRadioButtonMenuItem("Examen");
		ExerciseMode.add(rdbtnmntmExamen);
		mnMode.add(rdbtnmntmExamen);
		rdbtnmntmExamen.setSelected(true); //valeur par defaut du groupe de boutons
		
		JRadioButtonMenuItem rdbtnmntmExercice = new JRadioButtonMenuItem("Exercice");
		ExerciseMode.add(rdbtnmntmExercice);
		mnMode.add(rdbtnmntmExercice);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Version 1.0\nAuteur:");
			}
		});
		mnAide.add(mntmAPropos);
		
		JMenuItem mntmGnrerLexercice = new JMenuItem("G\u00E9n\u00E9rer l'exercice");
		menuBar.add(mntmGnrerLexercice);
		mntmGnrerLexercice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ca s'ouvre");
			}
		});
		
		JPanel TimerPanel = new JPanel();
		FlowLayout fl_TimerPanel = (FlowLayout) TimerPanel.getLayout();
		fl_TimerPanel.setAlignment(FlowLayout.RIGHT);
		menuBar.add(TimerPanel);
		
		JLabel lblMinuteur = new JLabel("Minuteur:");
		TimerPanel.add(lblMinuteur);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		TimerPanel.add(spinner);
		
		JLabel lblH = new JLabel("h");
		TimerPanel.add(lblH);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		TimerPanel.add(spinner_1);
		
		JLabel lblMin = new JLabel("min");
		TimerPanel.add(lblMin);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(30, 0, 59, 1));
		TimerPanel.add(spinner_2);
		
		JLabel lblS = new JLabel("s");
		TimerPanel.add(lblS);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
