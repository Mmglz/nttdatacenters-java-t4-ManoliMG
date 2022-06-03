package nttdata.javat4.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que implementa la interfaz ManagementServiceI.
 * 
 * @author manoli
 *
 */
public class ManagementServiceImpl implements ManagementServiceI {

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(ManagementServiceImpl.class);

	/** Constantes String para Logger */
	private static final String LOG_START = "TRAZA DE INICIO";
	private static final String LOG_END = "TRAZA FIN\n";

	/** Mapa studentsList de clave integer y de valor un objeto Estudiante */
	private Map<Integer, Student> studentsList = new HashMap<>();

	/** Mapa schoolsList de clave string y de valor un objeto Instituto */
	private Map<String, School> schoolsList = new HashMap<>();

	/**
	 * Método para añadir o actualizar estudiantes en el mapa studentsList
	 */
	@Override
	public void addOrUpdateStudent(Integer id, String nameStudent, String englishLevel) {

		LOG.info(LOG_START);

		Student st = new Student(id, nameStudent, englishLevel);

		// Si el mapa contiene el id se actualiza la información.
		if (studentsList.containsKey(id)) {

			studentsList.replace(id, st);

			LOG.info("El estudiante con id {} ha sido actualizado", id);

			// Sino se comprueba que el nombre y el nivel de inglés sean correctos y se añade al mapa.
		} else if (!nameStudent.isBlank() && !englishLevel.isBlank() && onlyLetters(nameStudent)) {

			studentsList.put(st.getId(), st);

			LOG.info("Se ha añadido como estudiante a {} con id {}.", st.getNameStudent(), id);

			// Si no se cumple con nada de lo anterior muestra un mensaje de error.
		} else {

			LOG.error("Los datos del estudiante son incorrectos.");
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para añadir o actualizar institutos en el mapa schoolsList.
	 */
	@Override
	public void addOrUpdateSchool(String nameSchool, String modality, String city) {

		LOG.info(LOG_START);

		School sc = new School(nameSchool, modality, city);

		// Si el mapa contiene el nombre se actualiza la información.
		if (schoolsList.containsKey(sc.getNameSchool())) {

			schoolsList.replace(nameSchool, sc);

			LOG.info("El instituto {} ha sido actualizado.", nameSchool);

			// Sino se comprueba que el nombre, modalidad y ciudad sean correctos y se añade al mapa.
		} else if (checkSchool(nameSchool, modality, city)) {

			schoolsList.put(sc.getNameSchool(), sc);

			LOG.info("Se ha añadido el instituto {}.", nameSchool);

			// Si no se cumple con nada de lo anterior muestra un mensaje de error.
		} else {

			LOG.error("Los datos del instituto son incorrectos.");
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para añadir un estudiante y su instituto a la base de datos.
	 */
	@Override
	public void addStudentToSchool(Integer id, String nameSchool) {

		LOG.info(LOG_START);

		// Comprueba que los datos introducidos como parámetros existen en los mapas.
		if (studentsList.containsKey(id) && schoolsList.containsKey(nameSchool)) {

			// Se añade los datos al mapa database.
			School.database.put(studentsList.get(id), schoolsList.get(nameSchool));

			LOG.info("El estudiante con id {}, ha sido añadido al instituto {}.", id, nameSchool);

			// Si no se encuentran los datos muestra un mensaje de error.
		} else {

			LOG.error("El estudiante o el instituto no existen en la base de datos.");
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para eliminar un estudiante del instituto.
	 */
	@Override
	public void removeStudentFromSchool(int id) {

		LOG.info(LOG_START);

		// Comprueba que el id introducido como parámetro existe en el mapa studentsList.
		if (studentsList.containsKey(id)) {

			// Elimina del mapa database al estudiante con el id introducido.
			School.database.remove(studentsList.get(id));

			LOG.info("El estudiante con id {}, ha sido eliminado de su instituto.", id);

			// Si no se encuentra el id muestra un mensaje de error.
		} else {

			LOG.error("El estudiante no existe en la base de datos.");
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para eliminar un instituto.
	 */
	@Override
	public void removeSchool(String nameSchool) {

		LOG.info(LOG_START);

		// Comprueba que el id introducido como parámetro existe en el mapa schoolsList y lo elimina.
		if (schoolsList.containsKey(nameSchool)) {

			schoolsList.remove(nameSchool);

			LOG.info("El intituto {} se ha eliminado correctamente.", nameSchool);

			// Si no se encuentra el id muestra un mensaje de error.
		} else {

			LOG.error("No hay ningun instituto registrado con nombre {} .", nameSchool);
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para mostrar todos los estudiantes de un instituto.
	 */
	@Override
	public void showAllStudentsFromSchool(String nameSchool) {

		// Comprueba que el nombre introducido como parámetro existe en el mapa schoolsList.
		if (schoolsList.containsKey(nameSchool)) {

			// Recorrore el mapa database.
			for (Entry<Student, School> key : School.database.entrySet()) {

				// Si el valor del mapa database es igual al nombre introducido como parámetro, imprime todos los alumnos del instituto.
				if (key.getValue().equals(schoolsList.get(nameSchool))) {

					System.out.println("Instituto: " + nameSchool + ". " + key.getKey());
				}
			}

			// Si no se encuentra el nombre muestra un mensaje de error.
		} else {

			System.out.println("\nDatos incorrectos. Introduce un instituto válido.\n");
		}
	}

	/**
	 * Método para mostrar todos los estudiantes.
	 */
	public void showAllStudents() {

		// Muestra si el mapa está vacío.
		if (studentsList.isEmpty()) {

			System.out.println("\nActualmente no hay alumnos inscritos.\n");

			// Recorre el mapa y muestra todos los estudiantes.
		} else {

			Iterator<Integer> iter = studentsList.keySet().iterator();

			while (iter.hasNext()) {

				Integer key = iter.next();

				System.out.println(studentsList.get(key));
			}
		}
	}

	/**
	 * Método para mostrar todos los institutos.
	 */
	public void showAllSchools() {

		// Muestra si el mapa está vacío.
		if (studentsList.isEmpty()) {

			System.out.println("\nActualmente no hay estudiantes inscritos.\n");

			// Recorre el mapa y muestra todos los institutos.
		} else {

			Iterator<String> iter = schoolsList.keySet().iterator();

			while (iter.hasNext()) {

				String key = iter.next();

				System.out.println(schoolsList.get(key));
			}
		}
	}

	/**
	 * Método para mostrar el número total de estudiantes del mapa datbase.
	 */
	public void printStudentTotalNum() {

		System.out.println("\nEn total hay " + School.database.size() + " estudiante registrados en la base de datos.\n");
	}

	/**
	 * Método para eliminar un estudiante.
	 * 
	 * @param id
	 */
	public void removeStudent(Integer id) {

		LOG.info(LOG_START);

		// Comprueba si el id introducido como parámetro existe en el mapa studentsList.
		if (studentsList.containsKey(id)) {

			// Elimina al estudiante del mapa datbase.
			School.database.remove(studentsList.get(id));

			// Elimina al estudiante del mapa studentsList.
			studentsList.remove(id);

			LOG.info("El estudiante con id {}, se ha eliminado correctamente.", id);

			// Si no se encuentra el id se muestra un mensaje de error.
		} else {

			LOG.error("No hay ningun estudiante registrado con id {}.", id);
		}

		LOG.info(LOG_END);
	}

	/**
	 * Método para validar la modalidad.
	 * 
	 * @param modality
	 * @return
	 */
	private static boolean validateModality(String modality) {

		boolean check = false;

		// Comprueba que la modalidad sólo pueda ser DAW o DAM.
		if (modality.equalsIgnoreCase("DAW") || modality.equalsIgnoreCase("DAM")) {

			check = true;

		} else {

			check = false;
		}

		return check;
	}

	/**
	 * Método para comprobar que una cadena sólo tiene letras.
	 * 
	 * @param text
	 * @return boolean
	 */
	private static boolean onlyLetters(String text) {

		// Recorre la palabra (text) letra a letra.
		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);

			// Comprueba que no está entre a y z, A y Z, ni es un espacio.
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {

				return false;
			}
		}

		return true;
	}

	/**
	 * Método para validar los atributos de un Instituto.
	 * 
	 * @param nameSchool
	 * @param modality
	 * @param city
	 * @return
	 */
	private static boolean checkSchool(String nameSchool, String modality, String city) {

		boolean school;

		// Comprueba que el nombre, la modalidad y la ciudad no sean campos vacios, que la modalidad sea la correcta y que el nombre y la ciudad no contengan números.
		if (!nameSchool.isBlank() && !modality.isBlank() && !city.isBlank() && validateModality(modality)
				&& onlyLetters(nameSchool) && onlyLetters(city)) {

			school = true;

		} else {

			school = false;
		}

		return school;
	}
}