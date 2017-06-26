package Models;

import Figures.Figure;

import java.util.Scanner;

/**
 * Created by Андрей on 24.06.2017.
 */
public class User extends Model {

    public void makeStep() {
        System.out.println("Enter your number");
        figure=Figure.getFigureByNum(new Scanner(System.in).nextInt());
        setTime();
    }

}
