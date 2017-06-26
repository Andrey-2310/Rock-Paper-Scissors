package Models;

import Figures.Figure;

import java.util.Random;

/**
 * Created by Андрей on 24.06.2017.
 */
public class Opponent extends Model {

    private String key;

    public void makeStep() {
        figure=Figure.getRandomFigure();
        setTime();
    }

    public Opponent() {
        this.key = String.valueOf(new Random().nextLong());
    }

    public String getKey() {
        return key;
    }
}
