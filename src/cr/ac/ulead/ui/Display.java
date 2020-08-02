package cr.ac.ulead.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class Display {

    private Scanner input = new Scanner(System.in);
    private PrintStream output = new PrintStream(System.out);

    public void showMainMenu() {
        output.println("\n");
        output.println("=======================================================================");
        output.println("========================   MENU PRINCIPAL   ===========================");
        output.println("=======================================================================");
        output.println(" - 1) Insertar persona desde la consola.");
        output.println(" - 2) Insertar persona desde archivo CSV.");
        output.println(" - 3) Mostrar arbol binario de personas.");
        output.println(" - 4) Recorrer arbol binario.");
        output.println(" - 5) Salir.");
    }

    public void showTraverseMenu() {
        output.println("\n");
        output.println("=======================================================================");
        output.println("=======================   MENU DE RECORRIDO   =========================");
        output.println("=======================================================================");
        output.println(" - 1) Recorrer en sentido IN-ORDER.");
        output.println(" - 2) Recorrer en sentido PRE-ORDER.");
        output.println(" - 3) Recorrer en sentido POST-ORDER.");
        output.println(" - 4) Salir.");
    }

    public void addName() {
        output.println("Introduzca un nombre: ");
    }

    public void addlastName() {
        output.println("Introduzca un apellido: ");
    }

    public void addDateOfBirth() {
        output.println("Introduzca la fecha de nacimiento (AAAA-MM-DD): ");
    }

    public void addPersonID() {
        output.println("Introduzca la cedula de identidad: ");
    }
}
