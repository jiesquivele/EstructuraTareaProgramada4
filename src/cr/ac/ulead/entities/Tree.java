package cr.ac.ulead.entities;

import java.time.LocalDate;
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(Person newPerson) {
        Node newNode = new Node();
        newNode.person = newPerson;
        LocalDate newDateOfBirth = newPerson.getDateOfBirth();
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                LocalDate currentDateOfBirth = current.person.getDateOfBirth();
                if (newDateOfBirth.isEqual(currentDateOfBirth)) {
                    int newID = Integer.parseInt(newPerson.getPersonID());
                    int currentID = Integer.parseInt(current.person.getPersonID());
                    if (newID < currentID) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
                if (newDateOfBirth.isAfter(currentDateOfBirth)) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else if (newDateOfBirth.isBefore(currentDateOfBirth)) {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("\nIN-ORDER: ");
                inOrder(root);
                break;
            case 2:
                System.out.println("\nPRE-ORDER: ");
                preOrder(root);
                break;
            case 3:
                System.out.println("\nPOST-ORDER: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.person.toString());
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.person.toString());
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.person.toString());
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.person.getName());
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("......................................................");
    }
}
