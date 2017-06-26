package Models;

import Figures.Figure;

import java.util.Date;

/**
 * Created by Андрей on 24.06.2017.
 */
public abstract class Model {
    Figure figure;
   private Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setTime(){
        timestamp=new Date(System.currentTimeMillis());
    }

    public abstract void makeStep();
}
