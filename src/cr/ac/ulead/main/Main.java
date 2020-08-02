package cr.ac.ulead.main;

import cr.ac.ulead.logic.Logic;
import cr.ac.ulead.ui.Display;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Logic logic = new Logic();
        Display display = new Display();
        boolean start = true;
        while (start) {
            display.showMainMenu();
            System.out.print("\nEscoja una opcion: ");
            int option = logic.getInt();
            switch (option) {
                case 1:
                    logic.insertPerson();
                    break;
                case 2:
                    logic.loadPerson();
                    break;
                case 3:
                    logic.theTree.displayTree();
                    break;
                case 4:
                    display.showTraverseMenu();
                    option = logic.getInt();
                    logic.theTree.traverse(option);
                    break;
                case 5:
                    start = false;
                    break;
                default:
                    System.out.print("Seleccion invalida. Intente de nuevo.\n");
            }
        }
    }
}
