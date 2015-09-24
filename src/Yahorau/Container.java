package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Андрей on 23.09.2015.
 */
abstract public class Container implements Comparable
{
    private Liquid liquid;
    private double height;
    private double lenghtBottom;

    public Container(Liquid liquid, double height, double lenghtBottom) throws IllegalArgumentException
    {
        this.liquid = liquid;
        this.height = height;
        this.lenghtBottom = lenghtBottom;
        if(height<=0||lenghtBottom<=0)
            throw new IllegalArgumentException("invalid arguments");
    }

    public Liquid getLiquid()
    {
        return liquid;
    }

    public double getHeight()
    {
        return height;
    }

    public double getLenghtBottom()
    {
        return lenghtBottom;
    }

    //абстрактный метод для вычисления объема налитой жидкости
    abstract public double getVolume ();


    // метод для вычисления массы жидкости
    public double getMass () {
        double mass;
        mass = getVolume()*this.getLiquid().getDensity();
        return  new BigDecimal(mass).setScale(3, RoundingMode.UP).doubleValue();
    }

    @Override
    public int compareTo(Object o)
    {
        double result = ((Container)o).getMass();
        return (int)(this.getMass()-result);
    }
}
