package Interface;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SimulatorAnswerDynamicPanel extends JPanel {
	private SimulatorPanel simulatorPanel;
	private AnswerPanel answerPanel;
	/**
	 * Create the panel.
	 */
	public SimulatorAnswerDynamicPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				update(); //fonctionne si on resize manuellement la fenetre
			}
		});
		setLayout(new BorderLayout(0, 0));
		
		answerPanel = new AnswerPanel();
		simulatorPanel = new SimulatorPanel();
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
		System.out.println("Panel regroup�: "+simulatorPanel.isActive);
	}
}
