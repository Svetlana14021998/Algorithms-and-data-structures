package lesson2;
import java.util.concurrent.TimeUnit;

public class Homework2 {
    private static final int max_size = 100000;
    private static final int max_value = 1000000;

    public static void main(String[] args) {

        lesson2.Array<Integer> arr1 = new ArrayImpl<>(max_size);
        arr1 = createArray();
        Array<Integer> arr2 = arr1;
        Array<Integer> arr3 = arr1;


        detectTime(arr1::sortBubble,"Bubble");
        detectTime(arr2::sortInsert,"Insert");
        detectTime(arr3::sortSelect,"Select");

    }
    private static Array createArray (){
        Array arr = new ArrayImpl(max_size);
        for (int i = 0; i < max_size; i++){
            arr.add((int)(Math.random()*max_value));
        }
        return arr;
    }
    private static void detectTime(Runnable runnable, String msg){
        Runnable th = new Runnable()
        {
            @Override
            public void run() {
                long beginTime = System.nanoTime();
                runnable.run();
                long endTime = System.nanoTime();
                long time = endTime - beginTime;
                System.out.println(TimeUnit.NANOSECONDS.toMicros(time) + " " +msg);

            }
        };
        th.run();


    }
}
