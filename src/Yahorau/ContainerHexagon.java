package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 24.09.2015.
 */
public class ContainerHexagon extends Container
{
    private double lenghtTop;
    private int numberOfType;

    // Конструктор для инициализации емкости с прямыми стенками, в основании - правильный шестиугольник;
    public ContainerHexagon(Liquid liquid, double height, double lenghtBottom) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.numberOfType=1;
    }

    // Конструктор для инициализации емкости с наклонными стенками, в основании - правильный шестиугольник;
    public ContainerHexagon(Liquid liquid, double height, double lenghtBottom, double lenghtTop) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.lenghtTop = lenghtTop;
        this.numberOfType=2;
        if(lenghtTop<=0||lenghtTop<lenghtBottom)
            throw new IllegalArgumentException("invalid arguments");
    }

    @Override
    public double getVolume()
    {
        double volume = 0;
        switch(this.numberOfType)
        {
            case 1:
            {
                double square= getLenghtBottom() * getLenghtBottom() * Math.sqrt(27)/2;
                volume = 0.95 * getHeight() * square * Math.pow(10,(-6));
                break;
            }
            case 2:
            {
                double baseSquare=getLenghtBottom()*getLenghtBottom()*Math.sqrt(27)/2;
                double topSquare=this.lenghtTop*this.lenghtTop*Math.sqrt(27)/2;
                volume = 0.95*(baseSquare+topSquare+Math.sqrt(baseSquare*topSquare))*getHeight()*Math.pow(10,(-6))/3;
                break;
            }
        }
        return  new BigDecimal(volume).setScale(3, RoundingMode.UP).doubleValue();


    }

    @Override
    public String toString()
    {
        StringBuilder container = new StringBuilder();
        switch(this.numberOfType) {
            case 1:
            {
                container.append("Hexagon direct").append("\t\tvolume=")
                        .append(getVolume()).append("\tmass=").append(getMass())
                        .append("\t").append(getLiquid()).append("\tlenght A Bottom =").append(getLenghtBottom())
                        .append("\tlenght A Top = ").append(getLenghtBottom())
                        .append("\tHeight=").append(getHeight());
                break;
            }
            case 2:
            {
                container.append("Hexagon incline").append("\t\tvolume=")
                        .append(getVolume()).append("\tmass=").append(getMass())
                        .append("\t").append(getLiquid()).append("\tlenght A Bottom =").append(getLenghtBottom())
                        .append("\tlenght A Top = ").append(getLenghtBottom())
                        .append("\tHeight=").append(getHeight());
                break;
            }
        }
        return container.toString();
    }
}
