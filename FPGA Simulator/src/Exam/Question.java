package Exam;

public class Question {
	private Exercise exercice= new Exercise();
	int QuNb,SsQuNb;
	private String title, description;
	private Boolean useSimulator, showSimulator;
	private QuestionParameter QuParam= new QuestionQCM();
	/**
	 * @return the exercice
	 */
	public Question(){
		System.out.println("Question créée");
	}
	public Exercise getExercice() {
		return exercice;
	}
	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercise exercice) {
		this.exercice = exercice;
		System.out.println("Exercise:"+exercice);
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
		System.out.println("Title Question:"+title);
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
		System.out.println("Enonce:"+description);
	}
	/**
	 * @return the useSimulator
	 */
	public Boolean getUseSimulator() {
		return useSimulator;
	}
	/**
	 * @param useSimulator the useSimulator to set
	 */
	public void setUseSimulator(Boolean useSimulator) {
		this.useSimulator = useSimulator;
		System.out.println("Simulator active:"+useSimulator);
	}
	/**
	 * @return the showSimulator
	 */
	public Boolean getShowSimulator() {
		return showSimulator;
	}
	/**
	 * @param showSimulator the showSimulator to set
	 */
	public void setShowSimulator(Boolean showSimulator) {
		this.showSimulator = showSimulator;
		System.out.println("Show simulator:"+showSimulator);
	}
	/**
	 * @return the quParam
	 */
	public QuestionParameter getQuParam() {
		return QuParam;
	}
	/**
	 * @param quParam the quParam to set
	 */
	public void setQuParam(QuestionParameter quParam) {
		QuParam = quParam;
	}
}
