package nttdata.javat4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import nttdata.javat4.business.ManagementServiceImpl;

/**
 * Clase principal
 * 
 * @author manoli
 *
 */
public class T4MainMMG {

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(T4MainMMG.class);

	/**
	 * Método principal que invoca a los métodos de la clase ManagementServiceImpl.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOG.info("TRAZA DE INICIO");

		ManagementServiceImpl m = new ManagementServiceImpl();

		// Añade alumnos al mapa de alumnos.
		m.addOrUpdateStudent(1, "Maria", "B1");
		m.addOrUpdateStudent(2, "Juan", "C1");
		m.addOrUpdateStudent(3, "Pepe", "A2");
		m.addOrUpdateStudent(4, "Daniel", "A1");
		m.addOrUpdateStudent(5, "Luisa", "B2");
		m.addOrUpdateStudent(6, "Pepe", "A2+");
		m.addOrUpdateStudent(7, "Ana", "A2+");
		m.addOrUpdateStudent(8, "Alfredo", "A2+");
		m.addOrUpdateStudent(9, "", "A2+");

		// Actualiza los alumnos.
		m.addOrUpdateStudent(1, "Maria", "B2");
		m.addOrUpdateStudent(4, "Daniel", "B1");

		// Añade institutos al mapa de institutos.
		m.addOrUpdateSchool("Sotero Hernandez", "DAW", "Sevilla");
		m.addOrUpdateSchool("Cesur", "DAM", "Malaga");
		m.addOrUpdateSchool("Salesianas", "DAM", "Sevilla");
		m.addOrUpdateSchool("Hermanos Machado", "DAW", "Sevilla");
		m.addOrUpdateSchool("V Centenario", "", "Sevilla");

		// Actualiza los institutos
		m.addOrUpdateSchool("Sotero Hernandez", "DAW", "San Juan");
		m.addOrUpdateSchool("Hermanos Machado", "DAW", "Dos Hermanas");

		// Añade a la base de datos alumnos con sus correspondientes institutos.
		m.addStudentToSchool(1, "Sotero Hernandez");
		m.addStudentToSchool(2, "Sotero Hernandez");
		m.addStudentToSchool(3, "Cesur");
		m.addStudentToSchool(4, "Cesur");
		m.addStudentToSchool(5, "Salesianas");
		m.addStudentToSchool(6, "Salesianas");
		m.addStudentToSchool(7, "Hermanos Machado");
		m.addStudentToSchool(8, "Hermanos Machado");
		m.addStudentToSchool(8, "V Centenario");
		m.addStudentToSchool(9, "Hermanos Machado");

		// Elimina un alumno del instituto.
		m.removeStudentFromSchool(1);
		m.removeStudentFromSchool(9);

		// Elimina un instituto.
		m.removeSchool("Sotero");
		m.removeSchool("Sotero Hernandez");

		// Muestra todos los alumnos de un instituto.
		m.showAllStudentsFromSchool("Sotero");
		m.showAllStudentsFromSchool("Cesur");

		System.out.println();

		// Muestra todos los alumnos.
		m.showAllStudents();

		System.out.println();

		// Muestra todos los instituos.
		m.showAllSchools();

		// Imprime el número total de estudiantes de la base de datos.
		m.printStudentTotalNum();

		// Borra un alumno del mapa alumno.
		m.removeStudent(1);
		m.removeStudent(9);

		LOG.info("TRAZA FIN");
	}
}