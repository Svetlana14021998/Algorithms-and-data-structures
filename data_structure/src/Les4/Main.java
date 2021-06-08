package Les4;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(0);
        list.insertFirst(6);
        list.insertFirst(3);//3 6 0 1
        show(list);
        Iter<Integer> iterator = (Iter<Integer>) list.iterator();
        iterator.reset();
        iterator.insertAfter(22);//3 22 6 0 1
        iterator.insertBefore(11);//3 11 22 6 0 1
        iterator.getCurrent();//11
        iterator.deleteCurrent();//3 22 6 0 1
        System.out.println(iterator.atEnd());//false
        iterator.nextLink();
        show(list);


    }

    static void show(LinkedList<Integer> list){
        for (Integer i : list){
            System.out.print(i + " ");
        }

    }
}
