package dec;

import queue.QueueImpl;

public class DequeueImpl <E> extends QueueImpl<E> implements Dequeue<E> {

    public DequeueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()){//если очередь заполнена то вставка невозможна
            return  false;
        }
        if (head == HEAD_DEFAULT){//если метка в дефолтном положении
            head = data.length;//ставим ее в конец
        }

        data[--head] = value;//записываем значение в предыдущую метке позицию 
        size++;//увеличиваем размер очереди

        return true;
        
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
        // if (isFull()) {//если очередь заполнена то вставка невозможна
        //            return false;
        //        }
        //
        //        if (tail == data.length - 1) {//если метка на последней возможной позиции
        //            tail = TAIL_DEFAULT;// ставим ее в дефолтное положение
        //        }
        //
        //        data[++tail] = value;//записываем значение на следующую позицию
        //        size++;//увеличиваем размер очереди
        //
        //        return true;
    }

    @Override
    public E removeLeft() {
        return super.remove();
        // if (isEmpty()) {//если очередь пуста то удалять нечего
        //            return null;
        //        }
        //
        //        if (head == data.length) {//если метка начала в конце очереди
        //            head = HEAD_DEFAULT;//то возвращаем ее в дефолтное положение
        //        }
        //
        //        E value = data[head++];//значение на удаление
        //        size--;//уменьшаем длину
        //
        //        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {//если очередь пуста то удалять нечего
            return  null;
        }
        if (tail == TAIL_DEFAULT){//если метка в дефолтном положении
            tail = data.length - 1;//ставим ее на последний элемент 
        }
        
        E value = data[tail--];//значение на удаление
        size--;//уменьшаем длину 
        
        return value;//
    }
}

