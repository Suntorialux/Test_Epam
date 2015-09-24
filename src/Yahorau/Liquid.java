package Yahorau;

/**
 * Created by Андрей on 19.09.2015.
 */
public class Liquid
{
    private String name;
    private double density;

    public Liquid(String name, double density)
    {
        this.name = name;
        this.density = density;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getDensity()
    {
        return density;
    }

    public void setDensity(double density)
    {
        this.density = density;
    }

    @Override
    public String toString()
    {
        StringBuilder liquid = new StringBuilder();
        liquid.append("density=").append(getDensity()).append("\t").append(getName());
        return liquid.toString();
    }
}
