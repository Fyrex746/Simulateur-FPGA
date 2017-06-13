package Exam;

public class Question {
	Exercise exercice;
	private int QuNb=1,SsQuNb=0;
	private String title="Titre de la question", description="Entrer l'énoncé de la question ici",answType="QCM";
	private Boolean useSimulator=true, showSimulator=true;
	private QuestionParameter QuParam;
	/**
	 * @return the exercice
	 */

	public Question(int n, Exercise exo){
		exercice=exo;
		setQuNb(n);
		if(answType=="QCM") QuParam = new QuestionQCM();
		if(answType=="Zone de texte") QuParam = new QuestionText();
		//System.out.println("Exercice "+exercice.getExNb()+" - Question "+n+" créée");
		getExercice().getListQuestions().add(this);
		//getExercice().setQuestionNb(getQuNb());
	}
	public Exercise getExercice() {
		return exercice;
	}
	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercise exercice) {
		this.exercice = exercice;
		//System.out.println("Exercise:"+exercice);
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
		//System.out.println("Title Question:"+title);
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
		//System.out.println("Enonce:"+description);
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
		//System.out.println("Simulator active:"+useSimulator);
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
		//System.out.println("Show simulator:"+showSimulator);
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
	/**
	 * @return the answType
	 */
	public String getAnswType() {
		return answType;
	}
	/**
	 * @param answType the answType to set
	 */
	public void setAnswType(String answType) {
		this.answType = answType;
	}
	/**
	 * @return the quNb
	 */
	public int getQuNb() {
		return QuNb;
	}
	/**
	 * @param quNb the quNb to set
	 */
	public void setQuNb(int quNb) {
		QuNb = quNb;
		//System.out.println("Qu"+quNb);
	}
	/**
	 * @return the ssQuNb
	 */
	public int getSsQuNb() {
		return SsQuNb;
	}
	/**
	 * @param ssQuNb the ssQuNb to set
	 */
	public void setSsQuNb(int ssQuNb) {
		SsQuNb = ssQuNb;
	}
}
