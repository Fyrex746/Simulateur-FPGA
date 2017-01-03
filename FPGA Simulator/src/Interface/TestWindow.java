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

public class TestWindow {

	private JFrame frmTest;
	/**
	 * @wbp.nonvisual location=81,-1
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("Joli titre");
	private JTextField txtL;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
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
		frmTest.setBounds(100, 100, 666, 459);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmTest.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox chckbxAfficherSimulateur = new JCheckBox("Afficher simulateur");
		chckbxAfficherSimulateur.setSelected(true);
		panel.add(chckbxAfficherSimulateur);
		
		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				JOptionPane.showMessageDialog(null, arg0.getPath().getLastPathComponent());
				/*if(arg0.equals("Jaune")) {
					System.out.println("Couleur:" + cmd);
					dess.setColor(Color.yellow);
					}*/
			}
		});
		
		JButton btnRinitialiserSimulateur = new JButton("R\u00E9initialiser simulateur");
		btnRinitialiserSimulateur.setMinimumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.setMaximumSize(new Dimension(100, 23));
		btnRinitialiserSimulateur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "R\u00E9initialisation du simulateur");
			}
		});
		panel.add(btnRinitialiserSimulateur);
		tree.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tree.setAutoscrolls(true);
		tree.setShowsRootHandles(true);
		tree.setBackground(Color.WHITE);
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
		tree.setEditable(true);
		panel.add(tree);
		panel.add(new JScrollPane(tree));
		
		/*ImageIcon imageIcon = new ImageIcon();
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(imageIcon);*/
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ca s'ouvre");
			}
		});
		frmTest.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		txtL = new JTextField();
		txtL.setBackground(new Color(0, 51, 204));
		txtL.setSelectedTextColor(Color.CYAN);
		txtL.setText("l");
		frmTest.getContentPane().add(txtL, BorderLayout.CENTER);
		txtL.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frmTest.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblExercice = new JLabel("Exercice 1");
		panel_1.add(lblExercice);
		
		JLabel lblQuestion = new JLabel("Question 1");
		panel_1.add(lblQuestion);
		
		JLabel label_1 = new JLabel("----------- ?");
		panel_1.add(label_1);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		buttonGroup_1.add(rdbtnA);
		panel_1.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		buttonGroup_1.add(rdbtnB);
		panel_1.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		buttonGroup_1.add(rdbtnC);
		panel_1.add(rdbtnC);
		
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
		chckbxmntmEnregistrementAuto.setSelected(true);//actif par defaut
		
		JMenu mnMode = new JMenu("Mode");
		menuBar.add(mnMode);
		
		JRadioButtonMenuItem rdbtnmntmExamen = new JRadioButtonMenuItem("Examen");
		buttonGroup.add(rdbtnmntmExamen);
		mnMode.add(rdbtnmntmExamen);
		rdbtnmntmExamen.setSelected(true); //valeur par defaut du groupe de boutons
		
		JRadioButtonMenuItem rdbtnmntmExercice = new JRadioButtonMenuItem("Exercice");
		buttonGroup.add(rdbtnmntmExercice);
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
