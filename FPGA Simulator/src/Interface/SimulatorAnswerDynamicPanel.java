package Interface;

import javax.swing.JPanel;

import Exam.Question;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class SimulatorAnswerDynamicPanel extends JPanel {
	private SimulatorPanel simulatorPanel;
	private AnswerPanel answerPanel;
	/**
	 * Create the panel.
	 */
	/*public SimulatorAnswerDynamicPanel(){
		this(new Question());
	}//*/
	public SimulatorAnswerDynamicPanel(Question qu,boolean isEditable) {
		setLayout(new BorderLayout(0, 0));
		
		answerPanel = new AnswerPanel(qu, isEditable);
		simulatorPanel = new SimulatorPanel(qu, isEditable);
		simulatorPanel.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				update();
			}
		});
		add(simulatorPanel, BorderLayout.CENTER);
		update();
	}
	
	protected void update(){
		if(simulatorPanel.isActive){
			add(answerPanel, BorderLayout.SOUTH);
			add(simulatorPanel, BorderLayout.CENTER);
		}
		else{
			add(answerPanel, BorderLayout.CENTER);
			add(simulatorPanel, BorderLayout.NORTH);
		}
		//System.out.println("Panel regroupé: "+simulatorPanel.isActive);
	}
}
