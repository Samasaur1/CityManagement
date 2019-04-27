package com.samgauck.CityManagement.Enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum Constructable
{
    //Format: NAME(String name,
    //              ArrayList of Material Types need per order using Arrays.asList,
    //              ArrayList of Integers for qty needed per order using Arrays.asList,
    //              cost per order
    //              total amount produced per order
    STEEL("steel",
            new ArrayList<Material>(Arrays.asList(Material.IRON, Material.CARBON)),
            new ArrayList<Integer>(Arrays.asList(19, 1)),
            1,
            19);

    private ArrayList<Integer> needed = new ArrayList<>();
    private int qtyPerOrder = 0;
    private int price = 0;
    private ArrayList<Material> mats = new ArrayList<>();
    String materialName = "";

    private Constructable(String name, ArrayList<Material> matsList, ArrayList<Integer> needed, int price, int qtyPerOrder)
    {
        //TODO change to add a Resource rather than 2 arrays
        for (int i = 0; i < matsList.size() && i < needed.size(); i++)
        {
            mats.add(matsList.get(i));
            this.needed.add(needed.get(i));
        }
        this.materialName = name;
        this.price = price;
        this.qtyPerOrder = qtyPerOrder;
    }

    public String getName()
    {
        return materialName;
    }

    public static Constructable fromString(String name)
    {
        for (Constructable mat : Constructable.values())
        {
            if (mat.materialName.equalsIgnoreCase(name)) {
                return mat;
            }
        }

        return null;
    }

    public static ArrayList<Material> getMaterialsNeeded(Constructable name)
    {
        return name.mats;
    }

    public ArrayList<Material> getMaterialsNeeded()
    {
        return mats;
    }

    public static ArrayList<Integer> getAmountNeeded(Constructable name)
    {
        return name.needed;
    }

    public ArrayList<Integer> getAmountNeeded()
    {
        return needed;
    }

    public int getPrice()
    {
        return price;
    }

    public int getQtyPerOrder()
    {
        return qtyPerOrder;
    }
};