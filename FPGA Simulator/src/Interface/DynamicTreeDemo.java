/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package Interface;

/*
 * This code is based on an example provided by Richard Stanford, 
 * a tutorial reader.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import Exam.*;

public class DynamicTreeDemo extends JPanel 
                             implements ActionListener {
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static Subject sujet;
    DynamicTree treePanel;

    public DynamicTreeDemo(boolean isEditable,Subject s) {
        super(new BorderLayout());
        sujet=s;
        //Create the components.
        treePanel = new DynamicTree(sujet,isEditable);
        populateTree(treePanel);

        JButton addButton = new JButton("Ajouter");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);
        
        JButton removeButton = new JButton("Supprimer");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);

        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(220, 200));
        add(treePanel, BorderLayout.CENTER);
        treePanel.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				update();
			}
		});

        JPanel panel = new JPanel(new GridLayout(0,2));
        panel.add(addButton);
        panel.add(removeButton);
        if(isEditable) add(panel, BorderLayout.SOUTH);
        treePanel.tree.expandRow(0);
        treePanel.tree.expandRow(1);
    }

    public void populateTree(DynamicTree treePanel) {
        String p1Name = new String("Exercice ");
        String c1Name = new String("Question ");
        DefaultMutableTreeNode p1;
        for(int i=0;i<sujet.getListExercise().size();i++){
        	p1=treePanel.addObject("Exercice "+(i+1));
        	for(int j=0;j<((Exercise) sujet.getListExercise().get(i)).getListQuestions().size();j++){
        		treePanel.addObject(p1,"Question "+(j+1));
        	}
        	//p1 = treePanel.addObject(null, p1Name+(i+1));
        }
        //p1 = treePanel.addObject(null, p1Name);
        //treePanel.addObject(p1, c1Name);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
        	if(treePanel.tree.getSelectionPath()==null){
        		JOptionPane.showMessageDialog(null, "Veuillez sélectionner un noeud!");
        	}
        	else{
        		int NbEnfants=treePanel.treeModel.getChildCount(treePanel.tree.getLastSelectedPathComponent())+1;
        		if(treePanel.tree.getSelectionPath().getPathCount()==1){
        			treePanel.addObject("Exercice " + NbEnfants);
        			sujet.getListExercise().add(new Exercise(NbEnfants));}
        		else if (treePanel.tree.getSelectionPath().getPathCount()==2){
        			treePanel.addObject("Question " + NbEnfants);
        			//((Exercise) sujet.getListExercise().get(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Exercice ", ""))-1)).getListQuestions().add(new Question(NbEnfants,((Exercise) sujet.getListExercise().get(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Exercice ", ""))-1))));
        			new Question(NbEnfants,((Exercise) sujet.getListExercise().get(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Exercice ", ""))-1)));
        			}
        		/*else if (treePanel.tree.getSelectionPath().getPathCount()==3){ // creation Sous-Question
        			treePanel.addObject("Sous-question " + NbEnfants);
        			//((Exercise) sujet.getListExercise().get(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Exercice ", ""))-1)).getListQuestions().add(new Question(NbEnfants,0));
        		}//*/
        		else{
        			JOptionPane.showMessageDialog(null, "Inutile d'aller si loin!");
        		}
        	}
        }
        else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            if(treePanel.tree.getSelectionPath().getPathCount()==1){
    			JOptionPane.showMessageDialog(null, "Elément impossible à retirer");
            }
            else{
            	if(treePanel.tree.getSelectionPath().getPathCount()==2){
            		sujet.getListExercise().remove(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Exercice ", ""))-1);
            	}
            	else if(treePanel.tree.getSelectionPath().getPathCount()==3){
            		((Exercise) sujet.getListExercise().get(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).getParent().toString().replaceAll("Exercice ", ""))-1)).getListQuestions().remove(Integer.parseInt(((DefaultMutableTreeNode) treePanel.tree.getLastSelectedPathComponent()).toString().replaceAll("Question ", ""))-1);
            	}
            	else if(treePanel.tree.getSelectionPath().getPathCount()==4){ // retrait sous-question du sujet
            		
            	}
            	treePanel.removeCurrentNode();
            	
            }
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    protected void update(){
    	add(treePanel, BorderLayout.CENTER);
    	//JOptionPane.showMessageDialog(null, "Actualisation ");
	}
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("DynamicTreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        DynamicTreeDemo newContentPane = new DynamicTreeDemo(true,sujet);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
