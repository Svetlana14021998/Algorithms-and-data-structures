package lesson6;

import java.util.Random;

public class Test6 {

    public static void main(String[] args) {
        Random random = new Random();
        int maxLevel = 4;//максимальная глубина
        int count = 20;//количество деревьев
        int balanceCount = 0;//количество сбалансированных деревьев
        int elementCount = (int) (Math.pow(2, maxLevel) - 1);//максимальное количество элементов
        int value = 25;


        for (int i = 0; i < count; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevel);
            createTree(random, tree, elementCount, value);
            if (tree.isBalanced()) {
                balanceCount++;
            }
        }


        /* Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

//        tree.traverse(Tree.TraverseMode.IN_ORDER);

        tree.display();
//        tree.remove(55);
//        tree.remove(42);
        tree.remove(40);
        tree.display();
        */

        double balancePercent = balanceCount * 100 / (count * 1.0);
        System.out.println("Balanced is : " + balancePercent + "% trees");


    }

    private static void createTree(Random random, Tree<Integer> tree, int elementCount, int value) {

        for (int i = 0; i < elementCount; i++) {
            tree.add(random.nextInt(2 * value) - value);//random.nextInt(diff+1)+min, diff = max -min
        }

    }
}
