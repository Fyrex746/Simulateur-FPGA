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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.Timer;

public class FenetreEleve extends JFrame {

	private JPanel contentPane,menuPanel,TimerPanel;
	private QuestionTotalPanel questionTotalPanel;
	private DynamicTreeDemo dynamicTreeDemo;
	private JMenuBar menuBar;
	private JMenu mnFichiers,mnMode,mnAide,mnModifier;
	private JMenuItem mntmNouveau,mntmOuvrir,mntmEnregistrer,mntmModifierLeFormulaire,mntmPropos,mntmGenere;
	private JCheckBoxMenuItem chckbxmntmEnregistrementAuto;
	private JRadioButtonMenuItem rdbtnmntmExercice,rdbtnmntmExamen;
	private final ButtonGroup ExMode = new ButtonGroup();
	private JLabel lblMinuteur,lblH,lblMin,lblS;
	private JSpinner hSpinner,minSpinner,sSpinner;
	private JButton btnGenere;
	private Subject sujet = new Subject();
	private boolean isEditable=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreEleve frame = new FenetreEleve();
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
	public FenetreEleve() {
		setTitle("Fen\u00EAtre \u00E9l\u00E8ve");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-1, -1, 3840, 2160);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichiers = new JMenu("Fichier");
		menuBar.add(mnFichiers);
		
		mntmNouveau = new JMenuItem("Nouveau");
		if(isEditable) mnFichiers.add(mntmNouveau);
		mntmNouveau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(dynamicTreeDemo);
				sujet = new Subject();
				dynamicTreeDemo = new DynamicTreeDemo(isEditable,sujet);
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
		//if(isEditable) menuBar.add(mnModifier);
		
		mntmModifierLeFormulaire = new JMenuItem("Modifier le formulaire de contact");
		//mnModifier.add(mntmModifierLeFormulaire);
		mntmModifierLeFormulaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ouverture du formulaire de contact");
			}
		});
		
		mnMode = new JMenu("Mode");
		if(isEditable) menuBar.add(mnMode);
		
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
		if(isEditable) menuPanel.add(btnGenere, BorderLayout.WEST);
		btnGenere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Génération du fichier... à venir");
			}
		});//*/
		
		TimerPanel = new JPanel();
		menuPanel.add(TimerPanel, BorderLayout.EAST);
		FlowLayout flowLayout = (FlowLayout) TimerPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		if(isEditable){
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
		}
		else{
			if(sujet.isExamMode()){
				lblMinuteur = new JLabel("Minuteur:");
				TimerPanel.add(lblMinuteur);
				JTextField minuteur=new JTextField();
				TimerPanel.add(minuteur);
				minuteur.setEditable(false);
				minuteur.setText(String.format("%02d", sujet.getTimerH())+":"+String.format("%02d", sujet.getTimerMin())+":"+String.format("%02d", sujet.getTimerSec()));
				minuteur.setEditable(false);;
				Timer t= new Timer(1000, new ActionListener() {
				       int g=sujet.getTimerSec()+60*sujet.getTimerMin()+3600*sujet.getTimerH();
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	minuteur.setText(String.format("%02d", g/3600)+":"+String.format("%02d", (g/60)%60)+":"+String.format("%02d", (g-1)%60));
				        	if(g==1)
				        	{
				        		minuteur.setText("");
				        		JOptionPane.showMessageDialog(null, "Temps \u00E9coul\u00E9");
				        		((Timer)e.getSource()).stop();
				        	}
				        	g--;
				      }
				    });
				t.start();
			}
			JLabel lblChrono = new JLabel("   Chronom\u00E8tre:");
			TimerPanel.add(lblChrono);
			JTextField chronometre=new JTextField();
			TimerPanel.add(chronometre);
			chronometre.setEditable(false);
			chronometre.setText("0");
			chronometre.setEditable(false);;
			Timer t1= new Timer(100, new ActionListener() {
			       int g1=1;
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	chronometre.setText(String.format("%02d", (g1/14400)%24)+":"+String.format("%02d", (g1/600)%60)+":"+String.format("%02d", (g1/10)%60)+":"+String.format("%01d", g1%10));
			        	g1++;
			      }
			    });
			t1.start();
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dynamicTreeDemo = new DynamicTreeDemo(isEditable,sujet);
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
		
		questionTotalPanel = new QuestionTotalPanel(sujet.getCurrentQuestion(),isEditable);
		contentPane.add(questionTotalPanel, BorderLayout.CENTER);
	}
	
	public void updateQuestionPanel(){
		contentPane.remove(questionTotalPanel);
		questionTotalPanel = new QuestionTotalPanel(sujet.getCurrentQuestion(),isEditable);
		contentPane.add(questionTotalPanel, BorderLayout.CENTER);
		revalidate();
	}

}
