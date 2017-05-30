package Exam;

public class QuestionText extends QuestionParameter {
	private String correctAnswer="Entrer la réponse";
	public QuestionText(){
		System.out.println("QuestionText");
	}
	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
		System.out.println("Réponse texte:"+correctAnswer);
	}
}
