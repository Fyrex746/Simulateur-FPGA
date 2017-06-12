package Exam;

public class QuestionText extends QuestionParameter {
	private String correctAnswer="Entrer la réponse",studentAnswer="Entrer la réponse";
	public QuestionText(){
		//System.out.println("QuestionText");
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
		//System.out.println("Réponse texte:"+correctAnswer);
	}
	/**
	 * @return the studentAnswer
	 */
	public String getStudentAnswer() {
		return studentAnswer;
	}
	/**
	 * @param studentAnswer the studentAnswer to set
	 */
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
}
