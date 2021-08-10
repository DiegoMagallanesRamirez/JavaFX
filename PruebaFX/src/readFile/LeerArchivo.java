package readFile;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Lectura de archivos.
 * 
 * En este ejemplo se trata de mostrar el proceso para leer un archivo, mostrar
 * y manejar su contenido.
 * 
 * @see Scanner
 * @see File
 * 
 * @author Diego
 * @version 27/07/2021
 */
public class LeerArchivo {
	
	// Aquí se guarda el archivo a leer.
	private File archivo;

	/**
	 * Constructor
	 * Recibe la ruta del archivo y lo guarda en 'archivo'.
	 * @param ruta La ruta donde se encuentra el archivo.
	 */
	public LeerArchivo(String ruta) {
		archivo = new File(ruta);
	}

	/**
	 * Se encarga de ir leyendo línea por línea hasta el final del archivo.
	 */
	public void leer() {
		try {
			Scanner lector = new Scanner(archivo);

			String linea = "";

			// Pregunta si tiene más líneas que leer:
			while(lector.hasNextLine()) {
				// Leemos la línea y luego la mostramos.
				linea = lector.nextLine();
				System.out.println(linea);
			}
			

		} catch(FileNotFoundException fnfe) {
			// En este catch manejamos el error de no encontrar el archivo.
			System.out.println("\nArchivo no encontrado.\n");
		} catch(Exception e) {
			// En este catch manejamos cualquier otro error que pueda llegar a ocurrir.
			System.out.println("\nHa ocurrido un error: " + e.getMessage());
		}
	}

	/**
	 * Se encarga de buscar un código postal y, si lo encuentra, mostrar un poco
	 * de su información relacionada.
	 * @param cp El código postal a buscar.
	 */
	public String[] buscar(String cp) {
		String [] datos = new String[5];

		try {
			Scanner lector = new Scanner(archivo);

			String linea = "";
			String [] data;

			// Pregunta si tiene más líneas que leer:
			while(lector.hasNextLine()) {
				// Leemos la línea y luego la mostramos.
				linea = lector.nextLine();
				// Seperamos su contenido por pipes |
				data = linea.split("\\|");

				// Preguntamos si el código postal que estamos leyendo es igual
				// al que nos pasaron. Si es igual, muestra su información:
				if(data[0].equals(cp)) {
					datos[0] = data[0];
					datos[1] = data[1];
					datos[2] = data[3];
					datos[3] = data[4];
					datos[4] = data[5];
				}
			}
			return datos;

		} catch(FileNotFoundException fnfe) {
			// En este catch manejamos el error de no encontrar el archivo.
			System.out.println("\nArchivo no encontrado.\n");
		} catch(Exception e) {
			// En este catch manejamos cualquier otro error que pueda llegar a ocurrir.
			System.out.println("\nHa ocurrido un error: " + e.getMessage());
		}

		return null;
	}
}