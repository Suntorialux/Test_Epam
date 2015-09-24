package Yahorau;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Андрей on 19.09.2015.
 */
public class Main
{
    public static final double HEIGHT=100;
    public static void main(String[] args)
    {
        Liquid gasoline = new Liquid("Gasoline",740);
        Liquid kerosene = new Liquid("Kerosene",820);
        Liquid oil = new Liquid("Engine oil",910);

      //  try
       // {
            List<Container> list = new ArrayList<Container>();

            list.add(new ContainerSquare(gasoline,HEIGHT,40));
            list.add(new ContainerSquare(kerosene,HEIGHT,30,50));
            list.add(new ContainerRectangle(gasoline,HEIGHT,115,160));
            list.add(new ContainerCircle(oil,HEIGHT,145));
            list.add(new ContainerCircle(gasoline,HEIGHT,145,155));
            list.add(new ContainerOval(oil,HEIGHT,45,55));
            list.add(new ContainerTrapeze(kerosene,HEIGHT,34,45,45));
            list.add(new ContainerTrapeze(gasoline,HEIGHT,150,170,160,190,20,30));
            list.add(new ContainerHexagon(gasoline,HEIGHT,25));
            list.add(new ContainerHexagon(gasoline,HEIGHT,135,160));


/*
            for(Container container : list)
            {
                System.out.println(container);
            }

        System.out.println();  */

        Collections.sort(list,Collections.reverseOrder());
        for(Container container : list)
        {
            System.out.println(container);
        }

        FoundMinMassGasoline(list);

     //   } catch (IllegalArgumentException e) {
       //     System.out.println("Introduced incorrect data: The square of the bottom must be smaller than the area of the top");
        //}

    }

    public static void FoundMinMassGasoline(List<Container> list) {
        double minMassGasoline=0;
        for(Container container : list) {
            if(container.getLiquid().getName().equals("Gasoline"))
            {
                minMassGasoline = container.getMass();
            }
        }

        for(Container container : list) {
            if(container.getLiquid().getName().equals("Gasoline"))
            {
               if(container.getMass()<minMassGasoline)
               {
                   minMassGasoline=container.getMass();
               }
            }
        }

        System.out.println("Min mass gasoline="+minMassGasoline);
    }
}
