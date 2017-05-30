package Exam;
import java.util.ArrayList;

public class Subject {
	private ArrayList ListExercise;
	public Subject(){
		setListExercise(new ArrayList());
		getListExercise().add(new Exercise(1));
		new Question(1,((Exercise) getListExercise().get(0))); // ajoute une question à l'exercice 1
		//((Question) ((Exercise) getListExercise().get(0)).getListQuestions().get(0)).exercice=(Exercise) getListExercise().get(0);
	}
	/**
	 * @return the listExercise
	 */
	public ArrayList getListExercise() {
		return ListExercise;
	}
	/**
	 * @param listExercise the listExercise to set
	 */
	public void setListExercise(ArrayList listExercise) {
		ListExercise = listExercise;
	}
}
