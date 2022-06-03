package nttdata.javat4.business;

/**
 * Clase Estudiante.
 * 
 * @author manoli
 *
 */
public class Student {

	/** ID del estudiante */
	private int id;

	/** Nombre del estudiante */
	private String nameStudent;

	/** Nivel de inglés del estudiante */
	private String englishLevel;

	/**
	 * @param id
	 * @param nameStudent
	 * @param englishLevel
	 */
	public Student(int id, String nameStudent, String englishLevel) {
		this.id = id;
		this.nameStudent = nameStudent;
		this.englishLevel = englishLevel;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nameStudent
	 */
	public String getNameStudent() {
		return nameStudent;
	}

	/**
	 * @param nameStudent the nameStudent to set
	 */
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	/**
	 * @return the englishLevel
	 */
	public String getEnglishLevel() {
		return englishLevel;
	}

	/**
	 * @param englishLevel the englishLevel to set
	 */
	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	@Override
	public String toString() {
		return "Estudiante: " + id + ", nombre: " + nameStudent + ", nivel de inglés: " + englishLevel;
	}
}