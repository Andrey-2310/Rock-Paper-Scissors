package Main;

import Figures.Figure;
import Figures.ProcessingFigures;
import Models.Model;
import Models.Opponent;
import Models.User;

import java.util.Scanner;

/**
 * Created by Андрей on 24.06.2017.
 */

public class Launcher {
    public static void main(String[] args) {
        gameProcess();
    }

    private static void gameProcess() {
        Opponent opponent = (Opponent) smbdTurn(new Opponent());
        Figure.showFigures();
        System.out.println("Opponent's figure hash: " + ProcessingFigures.hmacDigest(opponent.getFigure().getName(),
                opponent.getKey(), "HmacSHA1"));
        Model user = smbdTurn(new User());
        System.out.println("Opponent's figure: " + opponent.getFigure().getName());

        ProcessingFigures.compareFigures(user.getFigure(), opponent.getFigure());

        System.out.println("Opponent: " + opponent.getTimestamp() + "\nUser:     " + user.getTimestamp()+
                "\nThe key is: "+ opponent.getKey());
        System.out.println("Press 1 to repeat ");
        if (new Scanner(System.in).nextInt() == 1)
            gameProcess();
    }

    private static Model smbdTurn(Model model) {
        model.makeStep();
        model.setTime();
        return model;
    }
}
