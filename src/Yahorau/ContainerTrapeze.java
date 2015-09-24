package Yahorau;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by јндрей on 24.09.2015.
 */
public class ContainerTrapeze extends Container
{
    private double lenghtBofBottom;
    private double lenghtTop;
    private double lenghtBofTop;
    private double heightTrapezeBottom;
    private double heightTrapezeTop;
    private int numberOfType;

    //  онструктор дл€ инициализации емкости с пр€мыми стенками, в основании - равнобедренна€ трапеци€;
    public ContainerTrapeze(Liquid liquid, double height, double lenghtBottom,
                            double lenghtBofBottom,double heightTrapezeBottom) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.lenghtBofBottom = lenghtBofBottom;
        this.heightTrapezeBottom = heightTrapezeBottom;
        this.numberOfType=1;
        if(lenghtBofBottom<=0||heightTrapezeBottom<=0)
            throw new IllegalArgumentException("invalid arguments");
    }

    //  онструктор дл€ инициализации емкости с наклонными стенками, в основании - равнобедренна€ трапеци€;
    public ContainerTrapeze(Liquid liquid, double height, double lenghtBottom,
                            double lenghtBofBottom, double lenghtTop, double lenghtBofTop,
                            double heightTrapezeBottom, double heightTrapezeTop) throws IllegalArgumentException
    {
        super(liquid, height, lenghtBottom);
        this.lenghtBofBottom = lenghtBofBottom;
        this.lenghtTop = lenghtTop;
        this.lenghtBofTop = lenghtBofTop;
        this.heightTrapezeBottom = heightTrapezeBottom;
        this.heightTrapezeTop=heightTrapezeTop;
        this.numberOfType=2;
        if(lenghtBofBottom<=0 || lenghtBofTop<=0||lenghtTop<=0||heightTrapezeBottom<=0||heightTrapezeTop<=0
                ||lenghtBofBottom>lenghtBofTop||lenghtBottom>lenghtTop||heightTrapezeBottom>heightTrapezeTop)
            throw new IllegalArgumentException("invalid arguments");
        if((lenghtBofBottom==lenghtBofTop)&&(lenghtBottom==lenghtTop)&&(heightTrapezeBottom==heightTrapezeTop))
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
                volume = 0.95 * getHeight() * (getLenghtBottom()+this.lenghtBofBottom)*this.heightTrapezeBottom/2*Math.pow(10,(-6));
                break;
            }
            case 2:
            {
                double baseSquare=(getLenghtBottom()+this.lenghtBofBottom)*this.heightTrapezeBottom/2;
                double topSquare=(this.lenghtTop+this.lenghtBofTop)*this.heightTrapezeTop/2;
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
                container.append("Trapeze direct").append("\t\tvolume=")
                        .append(getVolume()).append("\tmass=").append(getMass())
                        .append("\t").append(getLiquid()).append("\tsize A=").append(getLenghtBottom())
                        .append("\tsize B=").append(this.lenghtBofBottom).append("\theight trapeze=")
                        .append(this.heightTrapezeBottom).append("\tHeight=").append(getHeight());
                break;
            }
            case 2:
            {
                container.append("Trapeze incline").append("\t\tvolume=")
                        .append(getVolume()).append("\tmass=").append(getMass())
                        .append("\t").append(getLiquid()).append("\tsize A bottom=").append(getLenghtBottom())
                        .append("\tsize B bottom=").append(this.lenghtBofBottom).append("\theight trapeze bottom=")
                        .append(this.heightTrapezeBottom).append("\tsize A top=").append(this.lenghtTop)
                        .append("\tsize B top=").append(this.lenghtBofBottom).append("\theight trapeze top=")
                        .append(this.heightTrapezeTop).append("\tHeight=").append(getHeight());
                break;
            }
        }
        return container.toString();

    }
}
