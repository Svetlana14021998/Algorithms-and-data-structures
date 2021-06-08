package Les4;

import java.util.Iterator;

public interface Iter<E> extends Iterator<E> {
    void reset();//перемещение в начлао списка
    void insertBefore(E value);//вставка до
    void insertAfter(E value);//вставка после
    LinkedList.Node<E> getCurrent();//получение элемента на который указывает итератор
    boolean atEnd();// true  если итератор находится в конце
    void deleteCurrent();//удаляет элемент в текущей позиции
    void nextLink();

}
