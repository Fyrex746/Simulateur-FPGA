package Exam;
import java.util.ArrayList;

public class Subject {
	private ArrayList ListExercise;
	private Question currentQuestion;
	private boolean ExamMode=true;
	private int TimerH=0,TimerMin=01,TimerSec=30;
	public Subject(){
		setListExercise(new ArrayList());
		getListExercise().add(new Exercise(1));
		new Question(1,((Exercise) getListExercise().get(0))); // ajoute une question à l'exercice 1
		setCurrentQuestion((Question) ((Exercise) getListExercise().get(0)).getListQuestions().get(0));
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
	/**
	 * @return the currentQuestion
	 */
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	/**
	 * @param currentQuestion the currentQuestion to set
	 */
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	/**
	 * @return the examMode
	 */
	public boolean isExamMode() {
		return ExamMode;
	}
	/**
	 * @param examMode the examMode to set
	 */
	public void setExamMode(boolean examMode) {
		ExamMode = examMode;
	}
	/**
	 * @return the timerSec
	 */
	public int getTimerSec() {
		return TimerSec;
	}
	/**
	 * @param timerSec the timerSec to set
	 */
	public void setTimerSec(int timerSec) {
		TimerSec = timerSec;
	}
	/**
	 * @return the timerMin
	 */
	public int getTimerMin() {
		return TimerMin;
	}
	/**
	 * @param timerMin the timerMin to set
	 */
	public void setTimerMin(int timerMin) {
		TimerMin = timerMin;
	}
	/**
	 * @return the timerH
	 */
	public int getTimerH() {
		return TimerH;
	}
	/**
	 * @param timerH the timerH to set
	 */
	public void setTimerH(int timerH) {
		TimerH = timerH;
	}
}
