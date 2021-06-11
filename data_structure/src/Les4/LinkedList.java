package Les4;

public interface LinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E item;
        LinkedList.Node<E> next;
        LinkedList.Node<E> previous;

        public Node(E item, LinkedList.Node<E> next) {
            this.item = item;
            this.next = next;

    }

    public  Node (E item, LinkedList.Node<E> next,LinkedList.Node<E> previous){
            this.item = item;
            this.next = next;
            this.previous = previous;

    }

    }

}

