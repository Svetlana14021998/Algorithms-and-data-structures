package homework5;

public class Item {

    private final String name;
    private final int weight;
    private final int cost;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public Item (String name, int weight, int cost){
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
    @Override
    public String toString(){
        return "Предмет: " + "название - " +  name  +"; "+ " вес -  " + weight  + "; "+" цена " + cost;
    }

}
