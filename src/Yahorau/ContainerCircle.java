package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 24.09.2015.
 */
public class ContainerCircle extends Container
{
    private double lenghtTop;
    private int numberOfType;

    // Конструктор для инициализации емкости с прямыми стенками, в основании - круг;
    public ContainerCircle(Liquid liquid, double height, double lenghtBottom) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.numberOfType=1;
    }

    // Конструктор для инициализации емкости с наклонными стенками, в основании - круг;
    public ContainerCircle(Liquid liquid, double height, double lenghtBottom, double lenghtTop) throws IllegalArgumentException
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
                volume = 0.95 *Math.PI* getHeight() * getLenghtBottom() * getLenghtBottom()*Math.pow(10,(-6));
                break;
            }
            case 2:
            {
                double baseSquare=Math.PI*getLenghtBottom()*getLenghtBottom();
                double topSquare=Math.PI*this.lenghtTop*this.lenghtTop;
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
                container.append("Circle direct").append("\t\tvolume=")
                         .append(getVolume()).append("\tmass=").append(getMass())
                         .append("\t").append(getLiquid())
                         .append("\tradius Bottom=").append(getLenghtBottom())
                         .append("\tHeight=").append(getHeight());
                break;
            }
            case 2:
            {
                container.append("Circle incline").append("\t\tvolume=")
                         .append(getVolume()).append("\tmass=").append(getMass())
                         .append("\t").append(getLiquid())
                         .append("\tradius Bottom=").append(getLenghtBottom())
                         .append("\tradius Top=").append(this.lenghtTop).append("\tHeight=").append(getHeight());
                break;
            }
        }
        return container.toString();
    }
}
