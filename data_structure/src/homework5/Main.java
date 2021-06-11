package homework5;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {

   /*     System.out.println(pow(-2,4));
        System.out.println(pow(2,-2));
        System.out.println(pow(3,0));
        System.out.println(pow(0.5,2));
        System.out.println(pow(0,2));
        System.out.println(pow(0,-2));

    */
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга",1,600));
        items.add(new Item("Бинокль",2,5000));
        items.add(new Item("Аптечка",4,1500));
        items.add(new Item("Ноутбук",2,40000));
        items.add(new Item("Котелок",1,500));

        Backpack backpack = new Backpack(6);
        backpack.searchBestItem(items);
        for (Item i:backpack.getBestItem()) {
            System.out.println(i.toString());
        }
        System.out.println("Стоимость лучшего набора: " + backpack.getBestCost());




    }

    private static double pow(double n, int count){
        if (n == 0){
            if (count <= 0 ){
                throw new IllegalArgumentException("Division  by 0");
            }
            else return 0;
        }
        if (count == 0){//базовый случай
            return 1;
        }
        if (count > 0){

            return n*pow(n,count-1);//положительная степень

        }

        else {
            return 1/(n*pow(n,abs(count)-1));//отрицательная степень сводится к положительной

        }

    }

}
