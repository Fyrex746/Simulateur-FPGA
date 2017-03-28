package component;
import java.util.ArrayList;
import java.util.Map;

public interface Simulator {
	//Appeler cette fonction dans l'interface graphique pour avoir le nom des diff�rents param�tres demand�s par le simulateur
	public ArrayList<String> getStrParameters();
	
	//Appeler cette fonction dans l'interface graphique pour configurer les param�tres du simulateur et g�rer les erreurs
	public void setParameters(Map<String, String> parameters) throws SimulatorParametersException;
	public void reset();
}

class SimulatorParametersException  extends Exception{
	//A sous-classer dans les classes impl�mentant Simulator afin de lever des exeptions personaliser
	public SimulatorParametersException(){
		System.out.println("Param�tre du simulateur incorrect");
	}
}