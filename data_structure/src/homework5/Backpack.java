package homework5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final int maxWeight;

    private int bestCost;
    private List<Item> bestItem = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calculateCost(List<Item> items) {
        int sumCost = 0;
        for (Item item : items) {
            sumCost += item.getCost();
        }
        return sumCost;
    }

    private int calculateWeight(List<Item> items) {

        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.getWeight();
        }
        return sumWeight;
    }

    private void setBestItem(List<Item> items) {
        int sumCost = calculateCost(items);//считаем сумму набора
        int sumWeight = calculateWeight(items);//считаем вес набора
        if (sumWeight <= maxWeight && sumCost > bestCost) {//если все влезает в ранец и сумма больше максимальной на данный момент
            bestItem = items;//набор становится лучшим
            bestCost = sumCost;//лучшая цена = цена данного набора
        }
    }

    //поиск лучшего набора
    public void searchBestItem(List<Item> items) {
        if (items.isEmpty()) {
            return;
        }

        setBestItem(items);//проверяем текущий набор, является ли он лучшим

        for (int i = 0; i < items.size(); i++) {
            List<Item> list = new ArrayList<>(items);//копия исходного набора
            list.remove(i);//удаляем текущий элемент
            searchBestItem(list);//проверяем, является ли лучшим набор без удаленного элемента
        }

    }


    public List<Item> getBestItem() {
        return bestItem;
    }

    public int getBestCost() {
        return bestCost;
    }


}
