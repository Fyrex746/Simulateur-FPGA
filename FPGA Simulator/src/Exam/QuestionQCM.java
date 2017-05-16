package Exam;

public class QuestionQCM extends QuestionParameter {
	private int numberAnswers;
	private Boolean allowMultipleChoice;
	String[] choiceDescription = new String[getNumberAnswers()];
	Boolean[] rightAnswers = new Boolean[getNumberAnswers()];
	/**
	 * @return the numberAnswers
	 */
	public QuestionQCM(){
		System.out.println("Réponse:QCM");
	}
	public int getNumberAnswers() {
		return numberAnswers;
	}
	/**
	 * @param numberAnswers the numberAnswers to set
	 */
	public void setNumberAnswers(int numberAnswers) {
		this.numberAnswers = numberAnswers;
		System.out.println("Nombre de réponses:"+numberAnswers);
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
		System.out.println("Réponses multiples:"+allowMultipleChoice);
	}
}
