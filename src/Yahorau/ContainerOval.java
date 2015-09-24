package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 24.09.2015.
 */
public class ContainerOval extends Container
{
    private double radiusB;

    // Конструктор для инициализации емкости с прямыми стенками, в основании - овал;
    public ContainerOval(Liquid liquid, double height, double lenghtBottom, double radiusB) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.radiusB = radiusB;
        if(radiusB<=0)
           throw new IllegalArgumentException("invalid arguments");
    }

    @Override
    public double getVolume()
    {
        double volume;
        volume = 0.95 *Math.PI* getHeight() * getLenghtBottom() *this.radiusB*Math.pow(10,(-6));
        return new BigDecimal(volume).setScale(3, RoundingMode.UP).doubleValue();
    }

    @Override
    public String toString()
    {
        StringBuilder container = new StringBuilder();
        container.append("Oval direct").append("\t\t\tvolume=")
                .append(getVolume()).append("\tmass=").append(getMass())
                .append("\t").append(getLiquid()).append("\tradius A =").append(getLenghtBottom())
                .append("\tradius B=").append(this.radiusB).append("\tHeight=").append(getHeight());

        return container.toString();
    }
}
