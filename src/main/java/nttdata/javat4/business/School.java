package nttdata.javat4.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Instituto.
 * 
 * @author manoli
 *
 */
public class School {

	/** Nombre del instituto */
	private String nameSchool;

	/** Modalidad del instituto */
	private String modality;

	/** Ciudad del instituto */
	private String city;

	/**
	 * Mapa database de clave un objeto Estudiante y de valor un objeto Instituto
	 */
	protected static Map<Student, School> database = new HashMap<>();

	/**
	 * @param nameSchool
	 * @param modality
	 * @param city
	 */
	public School(String nameSchool, String modality, String city) {
		this.nameSchool = nameSchool;
		this.modality = modality;
		this.city = city;
	}

	/**
	 * @return the nameSchool
	 */
	public String getNameSchool() {
		return nameSchool;
	}

	/**
	 * @param nameSchool the nameSchool to set
	 */
	public void setNameSchool(String nameSchool) {
		this.nameSchool = nameSchool;
	}

	/**
	 * @return the modality
	 */
	public String getModality() {
		return modality;
	}

	/**
	 * @param modality the modality to set
	 */
	public void setModality(String modality) {
		this.modality = modality;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Instituto: " + nameSchool + ", modalidad: " + modality + ", ciudad: " + city;
	}
}