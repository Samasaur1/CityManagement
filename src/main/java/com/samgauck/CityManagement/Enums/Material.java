package com.samgauck.CityManagement.Enums;

public enum Material {
    MONEY("money"),
    FOOD("food"),
    WOOD("wood"),
    STONE("stone"),
    IRON("iron"),
    OIL("oil"),
    COAL("coal"),
    URANIUM("uranium"),
    WATER("water"),
    CARBON("carbon");

    private String name = "";

    private Material(String name)
    {
        this.name = name;
    }

    public String valueOf()
    {
        return name;
    }

    public static Material fromString(String name)
    {
        for (Material mat : Material.values())
        {
            if (mat.name == name)
            {
                return mat;
            }
        }

        return null;
    }
}