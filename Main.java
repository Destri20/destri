public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements
        list.insertAtEnd("Devi");
        list.insertAtBeginning("Sarah");
        list.insertAtEnd("Indra");
        list.insertAtEnd("Ari");

        // Print the list
        System.out.println("Linked list after insertions:");
        list.printList(); // Expected: Sarah -> Devi -> Indra -> Ari -> null

        // insert after a specific node
        Node nodeDevi = list.getNode("Devi");
        if (nodeDevi != null) {
            list.insertAfter(nodeDevi, "Destri");
        }

        // Print the list after insertAfter
        System.out.println("\nLinked List after inserting Destri after Devi:");
        list.println();

        // Delete a node
        list.deleteNode("Indra");

        // Print the list after deletion
        System.out.println("\nLinked List after deleting Indra:");
        list.printlnList(); // Expected: Sarah -> Devi -> Destri -> Ari -> null
        
        // Delete a non-existent node
        list.deleteNode("Midah");

        // Print the list after trying to delete non-existent node
        System.out.println("\nLinked List after trying to delete Midah:");
        list.printlnList(); // Expected: Sarah -> Devi -> Destri -> Ari -> null
    }
}