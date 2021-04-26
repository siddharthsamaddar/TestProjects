package project.practice.warmUp;

/*
Print the alternate nodes of linked list (Iterative Method)
Given a linked list, print the alternate nodes of linked list.

Examples:

Input : 1 -> 8 -> 3 -> 10 -> 17 -> 22 -> 29 -> 42
Output : 1 -> 3 -> 17 -> 29
Alternate nodes : 1 -> 3 -> 17 -> 29

Input : 10 -> 17 -> 33 -> 38 -> 73
Output : 10 -> 33 -> 73
Alternate nodes : 10 -> 33 -> 73
*/
class AlternateNodes {
    static class Node {
        int data;
        Node next;
    }

    static Node push(Node ref, int data) {
        Node n = new Node();
        n.data = data;
        n.next = ref;
        ref = n;
        return ref;
    }

    public static void main(String[] args) {
        Node head = null;
        head = push(null, 1);
        head = push(head, 8);
        head = push(head, 3);
        head = push(head, 10);
        head = push(head, 17);
        head = push(head, 22);
        head = push(head, 29);
        head = push(head, 42);

        printAlternateNodes(head);
    }

    static void printAlternateNodes(Node head) {
        int count = 0;
        while (head != null) {
            if (count % 2 == 0)
                System.out.printf(" %d ", head.data);
            count++;
            head = head.next;
        }
    }
}
