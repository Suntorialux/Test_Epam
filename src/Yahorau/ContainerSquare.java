package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 23.09.2015.
 */
public class ContainerSquare extends Container
{
    private double lenghtTop;
    private int numberOfType;

    // Конструктор для инициализации емкости с прямыми стенками, в основании - квадрат;
    public ContainerSquare(Liquid liquid, double height, double lenghtBottom) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.numberOfType=1;

    }

    // Конструктор для инициализации емкости с наклонными стенками, в основании - квадрат;
    public ContainerSquare(Liquid liquid, double height, double lenghtBottom, double lenghtTop) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.lenghtTop = lenghtTop;
        this.numberOfType=2;
        if(lenghtTop<=0||lenghtBottom>lenghtTop)
            throw new IllegalArgumentException("invalid arguments");
        if(lenghtBottom==lenghtTop)
            this.numberOfType=1;
    }

    @Override
    public double getVolume()
    {
        double volume = 0;
        switch(this.numberOfType)
        {
            case 1:
            {
                volume = 0.95 * getHeight() * getLenghtBottom() * getLenghtBottom()*Math.pow(10,(-6));
                break;
            }
            case 2:
            {
                double baseSquare=getLenghtBottom()*getLenghtBottom();
                double topSquare=this.lenghtTop*this.lenghtTop;
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
                container.append("Square direct").append("\t\tvolume=")
                         .append(getVolume()).append("\tmass=").append(getMass())
                         .append("\t").append(getLiquid()).append("\tsize A=").append(getLenghtBottom())
                         .append("\tHeight=").append(getHeight());
                break;
            }
            case 2:
            {
                container.append("Square incline").append("\t\tvolume=")
                         .append(getVolume()).append("\tmass=").append(getMass())
                         .append("\t").append(getLiquid()).append("\tsize A Bottom=").append(getLenghtBottom())
                         .append("\tsize A Top=").append(this.lenghtTop).append("\tHeight=").append(getHeight());
                break;
            }
        }
        return container.toString();
    }
}
