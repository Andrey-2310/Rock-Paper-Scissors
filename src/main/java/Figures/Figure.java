package Figures;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Андрей on 24.06.2017.
 */
public class Figure {
    private static List<String> order = Arrays.asList("rock", "scissors", "paper", "spock", "lizard");

    private String name;

    private Figure(String name) {
        this.name = name;
    }

    public static Figure getFigureByNum(int num) {
        try {
            return new Figure(order.get(num));
        }
        catch (Exception e){
            System.out.println("Incorrect input, try again");
        }
        return getFigureByNum(new Scanner(System.in).nextInt());
    }

    public static Figure getRandomFigure() {
        Random random = new Random();
        return new Figure(order.get(random.nextInt(order.size())));
    }

    public static List<String> getOrder() {
        return order;
    }

    public static void showFigures(){
        for(int i=0; i<order.size(); i++)
            System.out.println(i+" - "+order.get(i));
    }

    public String getName() {
        return name;
    }

}
