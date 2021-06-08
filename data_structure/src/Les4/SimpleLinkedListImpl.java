package Les4;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        System.out.println(this);
        System.out.println("----------");
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> node) {
        return node != null ? node.item : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iter<E> {

        private final SimpleLinkedListImpl<E> list;

        private Node<E> follow;
        private Node<E> previous;

        public ListIterator() {
            this.list = SimpleLinkedListImpl.this;
            reset();
        }
        @Override
        public void reset() {//начальные значения
            follow = list.firstElement;//текущий элемент
            previous = null;//предыдущий элемент


        }

        @Override
        public void insertBefore(E value) {
            Node<E> node = new Node<>(value,null);
            if (previous == null){
                node.next = list.firstElement;
                list.firstElement = node;
                reset();
            }

        }

        @Override
        public void insertAfter(E value) {
            Node<E> node = new Node<>(value,null);
            if (list.isEmpty()){
                list.firstElement = node;
                follow = node;}
                    else{
                        node.next = follow.next;
                        follow.next = node;
                        nextLink();
            }

        }

        @Override
        public Node<E> getCurrent() {//возвращает текущее значение
            return follow;
        }

        @Override
        public boolean atEnd() {//конец списка?
            return follow.next == null;//если нет, то false
        }

        @Override
        public void deleteCurrent() {
            if (previous == null){
                list.firstElement = follow.next;
                reset();
            }else{
                previous.next = follow.next;
                if (!hasNext()){
                    reset();
                }else{
                    follow = follow.next;
                }

            }

        }

        @Override
        public void nextLink() {//переход к следующему элементу
            previous = follow;//предыдущий становится текущим
            follow = follow.next;//текущий становится следующим
        }

        @Override
        public boolean hasNext() {
            return follow!=null;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E nextV = follow.item;//текущий
            nextLink();
            //previous = follow;//предыдущий становится текущим
            //follow = follow.next;//текущий становится следующим
            return nextV;
        }

}
}
