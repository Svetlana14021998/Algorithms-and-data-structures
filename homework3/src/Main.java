
import dec.Dequeue;
import dec.DequeueImpl;
import stack.Stack;
import stack.StackImpl;

public class Main {
    public static void main(String[] args) {
        String s = "qwert12345";
        Stack<Character> stack = new StackImpl<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        
        System.out.println();




        Dequeue<Integer> dequeue = new DequeueImpl<>(10) {
        };
        dequeue.insertRight(1); // 1
        dequeue.insertRight(2); // 1 2
        dequeue.insertRight(3); // 1 2 3
        dequeue.insertRight(4); // 1 2 3 4
        dequeue.insertRight(5); // 1 2 3 4 5
        dequeue.insertLeft(6); //  6 1 2 3 4 5
        dequeue.insertLeft(7); // 7 6 1 2 3 4 5
        dequeue.insertLeft(8); // 8 7 6 1 2 3 4 5
        dequeue.insertLeft(9); // 9 8 7 6 1 2 3 4 5
        dequeue.insertLeft(10); //10 9 8 7 6 1 2 3 4 5

       //   while (!dequeue.isEmpty()){
        //    System.out.print(dequeue.removeLeft() + " ");// удаление с 10
      //  }

        while (!dequeue.isEmpty()) {
            System.out.print(dequeue.removeRight() + " "); // удаление с 5
        }


    }
}
