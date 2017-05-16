package Exam;

public class Exercise {
	int nbQuestions,QuestionNb;
	Question[] QuestionList = new Question[nbQuestions];
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		System.out.println("Title Exercise:"+title);
	}
}
