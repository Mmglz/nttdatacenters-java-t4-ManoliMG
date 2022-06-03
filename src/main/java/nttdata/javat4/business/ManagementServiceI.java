package nttdata.javat4.business;

/**
 * Interfaz implementada por la clase ManagementServiceImpl.
 * 
 * @author manoli
 *
 */
public interface ManagementServiceI {

	/**
	 * Método para añadir o actualizar un estudiante.
	 * 
	 * @param id
	 * @param nameStudent
	 * @param englishLevel
	 */
	public void addOrUpdateStudent(Integer id, String nameStudent, String englishLevel);

	/**
	 * Método para añadir o actualizar un instituto.
	 * 
	 * @param nameSchool
	 * @param modality
	 * @param city
	 */
	public void addOrUpdateSchool(String nameSchool, String modality, String city);

	/**
	 * Método para añadir un estudiante y su instituto a la base de datos.
	 * 
	 * @param id
	 * @param nameSchool
	 */
	public void addStudentToSchool(Integer id, String nameSchool);

	/**
	 * Método para eliminar un estudiante del instituto.
	 * 
	 * @param id
	 */
	public void removeStudentFromSchool(int id);

	/**
	 * Método para eliminar un instituto.
	 * 
	 * @param nameSchool
	 */
	public void removeSchool(String nameSchool);

	/**
	 * Método para mostrar todos los estudiantes de un instituto.
	 * 
	 * @param nameSchool
	 */
	public void showAllStudentsFromSchool(String nameSchool);
}
