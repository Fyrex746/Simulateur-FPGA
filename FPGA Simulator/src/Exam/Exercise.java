package Exam;
import java.util.ArrayList;

public class Exercise {
	private int QuestionNb,ExNb=1;
	private String title="Titre de l'exercice";
	private ArrayList ListQuestions= new ArrayList();
	
	/*public Exercise(){
		this(1);
	}//*/
	public Exercise(int n){
		System.out.println("Nouvel exercice "+n);
		setExNb(n);
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		//System.out.println("Title Exercise:"+title);
	}
	/**
	 * @return the nbQuestions
	 */
	/*public int getNbQuestions() {
		return nbQuestions;
	}
	/**
	 * @param nbQuestions the nbQuestions to set
	 */
	/*public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}
	/**
	 * @return the questionNb
	 */
	public int getQuestionNb() {
		return QuestionNb;
	}
	/**
	 * @param questionNb the questionNb to set
	 */
	public void setQuestionNb(int questionNb) {
		QuestionNb = questionNb;
	}
	/**
	 * @return the exNb
	 */
	public int getExNb() {
		return ExNb;
	}
	/**
	 * @param exNb the exNb to set
	 */
	public void setExNb(int exNb) {
		ExNb = exNb;
	}
	/**
	 * @return the listQuestions
	 */
	public ArrayList getListQuestions() {
		return ListQuestions;
	}
	/**
	 * @param listQuestions the listQuestions to set
	 */
	public void setListQuestions(ArrayList listQuestions) {
		ListQuestions = listQuestions;
	}
}
