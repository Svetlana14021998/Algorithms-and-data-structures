package lesson7;

import java.util.Stack;

public class Homework7 {
    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула","Рязань","Калуга");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Курск","Воронеж");
        //graph.bfs("Москва");
      //  System.out.println("--------");
      //  graph.dfs("Москва");
       Stack<String> path =  graph.searchPath("Москва","Воронеж");
        //show(path);
        StringBuilder stringBuilder = new StringBuilder();
        while (!path.isEmpty()){
            stringBuilder.append(path.pop() + " ");

        }
        System.out.println(stringBuilder);







    }

}
