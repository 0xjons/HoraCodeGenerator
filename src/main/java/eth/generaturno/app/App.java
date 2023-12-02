package eth.generaturno.app;

import java.util.Scanner;
import eth.generaturno.libraries.GeneradorDeCodigos;

/**
 * Clase App: Esta clase es responsable de interactuar con el usuario para
 * generar códigos secuenciales basados en la hora actual.
 *
 * Autor: 0xjons
 */
public final class App {

    // Instancia de GeneradorDeCodigos para generar códigos secuenciales.
    private final GeneradorDeCodigos cod;

    // Instancia de Scanner para leer la entrada del usuario desde la consola.
    private final Scanner scanner;

    /**
     * Constructor de App: Inicializa la instancia de GeneradorDeCodigos y
     * Scanner. GeneradorDeCodigos es utilizado para generar códigos únicos y
     * Scanner para leer entradas del usuario.
     */
    public App() {
        scanner = new Scanner(System.in, "UTF-8");
        System.out.print("Por favor, introduzca el intervalo en minutos (por ejemplo, 60 para cada hora): ");
        int intervalo = Integer.parseInt(scanner.nextLine());
        cod = new GeneradorDeCodigos(intervalo);
    }

    /**
     * Método launchApp: Este método inicia la interacción con el usuario.
     * Solicita al usuario ingresar nombres y genera códigos únicos para cada
     * nombre válido ingresado. El usuario puede salir del bucle escribiendo
     * "EXIT".
     */
    public final void launchApp() {
        String input;
        while (true) {
            System.out.print("Por favor, inserte un nombre (escribe EXIT para salir): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("EXIT")) {
                break;
            }

            if (esNombreValido(input)) {
                String codigoGenerado = cod.generarCodigo();
                System.out.println("Código generado: " + codigoGenerado);
            } else {
                System.out.println("Entrada no válida. Asegúrese de ingresar solo letras.");
            }
        }
    }

    /**
     * Método esNombreValido: Verifica si el nombre ingresado contiene solo
     * letras. Utiliza una expresión regular para realizar la validación.
     *
     * @param nombre El nombre a validar.
     * @return true si el nombre contiene solo letras; false en caso contrario.
     */
    private boolean esNombreValido(String nombre) {
        return nombre.matches("[a-zA-Z]+");
    }
}
