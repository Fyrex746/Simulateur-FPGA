package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Exam.*;

import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class FenetreProf extends JFrame {

	private JPanel contentPane;
	private QuestionTotalPanel questionTotalPanel;
	private DynamicTreeDemo dynamicTreeDemo;
	private JMenuBar menuBar;
	private JMenu mnFichiers;
	private JMenu mnModifier;
	private JMenu mnMode;
	private JMenu mnAide;
	private JMenuItem mntmNouveau;
	private JMenuItem mntmOuvrir;
	private JMenuItem mntmEnregistrer;
	private JCheckBoxMenuItem chckbxmntmEnregistrementAuto;
	private JMenuItem mntmModifierLeFormulaire;
	private JRadioButtonMenuItem rdbtnmntmExercice;
	private JRadioButtonMenuItem rdbtnmntmExamen;
	private JMenuItem mntmPropos;
	private JMenuItem mntmGenere;
	private final ButtonGroup ExMode = new ButtonGroup();
	private JPanel TimerPanel;
	private JLabel lblMinuteur;
	private JLabel lblH;
	private JLabel lblMin;
	private JLabel lblS;
	private JSpinner hSpinner;
	private JSpinner minSpinner;
	private JSpinner sSpinner;
	private JPanel menuPanel;
	private JButton btnGenere;
	private Subject sujet = new Subject();
	//private Question qu=new Question();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreProf frame = new FenetreProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreProf() {
		setTitle("Fen\u00EAtre professeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-1, -1, 3840, 2160);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichiers = new JMenu("Fichier");
		menuBar.add(mnFichiers);
		
		mntmNouveau = new JMenuItem("Nouveau");
		mnFichiers.add(mntmNouveau);
		mntmNouveau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(dynamicTreeDemo);
				sujet = new Subject();
				dynamicTreeDemo = new DynamicTreeDemo(true,sujet);
				dynamicTreeDemo.addContainerListener(new ContainerAdapter() {
					@Override
					public void componentAdded(ContainerEvent arg0) {
						//JOptionPane.showMessageDialog(null, "Actualisation ");
						updateQuestionPanel();
					}
				});
				dynamicTreeDemo.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						System.out.println("Mouse");
						updateQuestionPanel();
					}
				});
				dynamicTreeDemo.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						//System.out.println("Property changed");
						updateQuestionPanel();
					}
				});
				contentPane.add(dynamicTreeDemo, BorderLayout.WEST);
				revalidate();
				dynamicTreeDemo.setVisible(false);
				dynamicTreeDemo.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ouverture d'un nouveau fichier");
			}
		});
		
		mntmOuvrir = new JMenuItem("Ouvrir");
		mntmOuvrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture de votre fichier");
			}
		});
		mnFichiers.add(mntmOuvrir);
		
		mntmEnregistrer = new JMenuItem("Enregistrer");
		mntmEnregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enregistrement de votre fichier");
			}
		});
		mnFichiers.add(mntmEnregistrer);
		
		chckbxmntmEnregistrementAuto = new JCheckBoxMenuItem("Enregistrement auto");
		mnFichiers.add(chckbxmntmEnregistrementAuto);
		
		mnModifier = new JMenu("Modifier"); //a ajouter plus tard
		//menuBar.add(mnModifier);
		
		mntmModifierLeFormulaire = new JMenuItem("Modifier le formulaire de contact");
		//mnModifier.add(mntmModifierLeFormulaire);
		mntmModifierLeFormulaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture du formulaire de contact");
			}
		});
		
		mnMode = new JMenu("Mode");
		menuBar.add(mnMode);
		
		rdbtnmntmExercice = new JRadioButtonMenuItem("Exercice");
		rdbtnmntmExercice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sujet.setExamMode(rdbtnmntmExamen.isSelected());
			}
		});
		rdbtnmntmExercice.setSelected(!sujet.isExamMode());
		ExMode.add(rdbtnmntmExercice);
		mnMode.add(rdbtnmntmExercice);
		
		rdbtnmntmExamen = new JRadioButtonMenuItem("Examen");
		rdbtnmntmExamen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sujet.setExamMode(rdbtnmntmExamen.isSelected());
			}
		});
		rdbtnmntmExamen.setSelected(sujet.isExamMode());
		ExMode.add(rdbtnmntmExamen);
		mnMode.add(rdbtnmntmExamen);
		
		mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		mntmPropos = new JMenuItem("\u00C0 propos");
		mnAide.add(mntmPropos);
		mntmPropos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Version 1.0\nAuteur:");
			}
		});
		
		menuPanel = new JPanel();
		menuBar.add(menuPanel);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		btnGenere = new JButton("G\u00E9n\u00E9rer le fichier");
		menuPanel.add(btnGenere, BorderLayout.WEST);
		btnGenere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Génération du fichier... à venir");
			}
		});
		
		TimerPanel = new JPanel();
		menuPanel.add(TimerPanel, BorderLayout.EAST);
		FlowLayout flowLayout = (FlowLayout) TimerPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		lblMinuteur = new JLabel("Minuteur:");
		TimerPanel.add(lblMinuteur);
		
		hSpinner = new JSpinner();
		hSpinner.setModel(new SpinnerNumberModel(sujet.getTimerH(), 0, 23, 1));
		hSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				sujet.setTimerH((int) hSpinner.getValue());
				//JOptionPane.showMessageDialog(null,((int) hSpinner.getValue()));
			}      
		});
		TimerPanel.add(hSpinner);
		
		lblH = new JLabel("h");
		TimerPanel.add(lblH);
		
		minSpinner = new JSpinner();
		minSpinner.setModel(new SpinnerNumberModel(sujet.getTimerMin(), 0, 59, 1));
		minSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				sujet.setTimerMin((int) minSpinner.getValue());
				//JOptionPane.showMessageDialog(null,((int) minSpinner.getValue()));
			}      
		});
		TimerPanel.add(minSpinner);
		
		lblMin = new JLabel("min");
		TimerPanel.add(lblMin);
		
		sSpinner = new JSpinner();
		sSpinner.setModel(new SpinnerNumberModel(sujet.getTimerSec(), 0, 59, 1));
		sSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				sujet.setTimerSec((int) sSpinner.getValue());
				//JOptionPane.showMessageDialog(null, ((int) sSpinner.getValue()));
			}      
		});
		TimerPanel.add(sSpinner);
		
		lblS = new JLabel("s");
		TimerPanel.add(lblS);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dynamicTreeDemo = new DynamicTreeDemo(true,sujet);
		dynamicTreeDemo.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Actualisation ");
				updateQuestionPanel();
			}
		});
		dynamicTreeDemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Mouse");
				updateQuestionPanel();
			}
		});
		dynamicTreeDemo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				//System.out.println("Property changed");
				updateQuestionPanel();
			}
		});
		contentPane.add(dynamicTreeDemo, BorderLayout.WEST);
		
		questionTotalPanel = new QuestionTotalPanel(sujet.getCurrentQuestion());
		contentPane.add(questionTotalPanel, BorderLayout.CENTER);
	}
	
	public void updateQuestionPanel(){
		//JOptionPane.showMessageDialog(null, "Actualisation panneau de questions");
		questionTotalPanel = new QuestionTotalPanel(sujet.getCurrentQuestion());
		contentPane.add(questionTotalPanel, BorderLayout.CENTER);
		revalidate();
	}

}
