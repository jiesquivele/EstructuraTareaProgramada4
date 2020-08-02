package cr.ac.ulead.logic;

import cr.ac.ulead.entities.Person;
import cr.ac.ulead.entities.Tree;
import cr.ac.ulead.ui.Display;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Logic {

    private Display display = new Display();
    public Tree theTree = new Tree();

    public void insertPerson() throws IOException {
        Person newPerson = new Person();
        display.addName();
        newPerson.setName(getString());
        display.addlastName();
        newPerson.setLastName(getString());
        display.addDateOfBirth();
        newPerson.setDateOfBirth(LocalDate.parse(getString()));
        display.addPersonID();
        newPerson.setPersonID(getString());
        theTree.insert(newPerson);
    }

    public void loadPerson() {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("C:\\dev\\estructuras\\tarea4\\personas.csv"));
            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String[] data = currentLine.split(",");
                Person newPerson = new Person();
                newPerson.setName(data[0]);
                newPerson.setLastName(data[1]);
                newPerson.setDateOfBirth(LocalDate.parse(data[2]));
                newPerson.setPersonID(data[3]);
                theTree.insert(newPerson);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
        }
    }

    public String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
