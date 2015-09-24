package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 23.09.2015.
 */
public class ContainerRectangle extends Container
{
    private double widthBottom;

    // Конструктор для инициализации емкости с прямыми стенками, в основании - прямоугольник;
    public ContainerRectangle(Liquid liquid, double height, double lenghtBottom, double widthBottom) throws  IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.widthBottom = widthBottom;
        if(widthBottom<=0)
            throw new IllegalArgumentException("invalid arguments");
    }

    @Override
    public double getVolume()
    {
        double volume;
        volume = 0.95*getHeight()*getLenghtBottom()*this.widthBottom*Math.pow(10,(-6));
        return new BigDecimal(volume).setScale(3, RoundingMode.UP).doubleValue();
    }

    @Override
    public String toString()
    {
        StringBuilder container = new StringBuilder();
        container.append("Rectangle direct").append("\tvolume=")
                 .append(getVolume()).append("\tmass=").append(getMass())
                 .append("\t").append(getLiquid())
                 .append("\tsize A=").append(getLenghtBottom()).append("\tsize B=").append(this.widthBottom)
                 .append("\tHeight=").append(getHeight());
        return container.toString();
    }
}
