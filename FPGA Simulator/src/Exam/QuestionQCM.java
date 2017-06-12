package Exam;

import java.util.Arrays;

public class QuestionQCM extends QuestionParameter {
	private int numberAnswers=10;
	private Boolean allowMultipleChoice=true;
	private String[] choiceDescription = new String[getNumberAnswers()];
	private Boolean[] rightAnswers = new Boolean[getNumberAnswers()];
	/**
	 * @return the numberAnswers
	 */
	public QuestionQCM(){
		rightAnswers = new Boolean[getNumberAnswers()];
		choiceDescription = new String[getNumberAnswers()];
		//System.out.println("Réponse:QCM"+getNumberAnswers());
		Arrays.fill(rightAnswers, Boolean.FALSE);
		for(int i=0;i<getNumberAnswers();i++){
			choiceDescription[i]="Réponse "+Character.toString((char) (i+65));
		}
	}
	public int getNumberAnswers() {
		return numberAnswers;
	}
	/**
	 * @param numberAnswers the numberAnswers to set
	 */
	public void setNumberAnswers(int numberAnswers) {
		this.numberAnswers = numberAnswers;
		rightAnswers = new Boolean[getNumberAnswers()];
		choiceDescription = new String[getNumberAnswers()];
		Arrays.fill(rightAnswers, Boolean.FALSE);
		for(int i=0;i<getNumberAnswers();i++){
			choiceDescription[i]="Réponse "+Character.toString((char) (i+65));
		}
		//System.out.println("Nombre de réponses:"+numberAnswers);
	}
	/**
	 * @return the allowMultipleChoice
	 */
	public Boolean getAllowMultipleChoice() {
		return allowMultipleChoice;
	}
	/**
	 * @param allowMultipleChoice the allowMultipleChoice to set
	 */
	public void setAllowMultipleChoice(Boolean allowMultipleChoice) {
		this.allowMultipleChoice = allowMultipleChoice;
		//System.out.println("Réponses multiples:"+allowMultipleChoice);
	}
	/**
	 * @return the rightAnswers
	 */
	public Boolean[] getRightAnswers() {
		return rightAnswers;
	}
	/**
	 * @param rightAnswers the rightAnswers to set
	 */
	public void setRightAnswers(Boolean[] rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
	/**
	 * @return the choiceDescription
	 */
	public String[] getChoiceDescription() {
		return choiceDescription;
	}
	/**
	 * @param choiceDescription the choiceDescription to set
	 */
	public void setChoiceDescription(String[] choiceDescription) {
		this.choiceDescription = choiceDescription;
	}
}
