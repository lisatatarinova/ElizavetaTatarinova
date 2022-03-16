package com.epam.tc.hw7.entities;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class MetalAndColors {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalAndColors(List<Integer> summary, List<String> elements, String color, String metals,
                          List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public MetalAndColors() {
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        return "MetalAndColors{"
            + "summary=" + summary
            + ", elements=" + elements
            + ", color='" + color + '\''
            + ", metals='" + metals + '\''
            + ", vegetables=" + vegetables
            + '}';
    }

    public static List<String> getExpectedResult(MetalAndColors input) {
        return new ArrayList<>() {
            {
                add(String.format("Summary: %d", input.getSummary().get(0) + input.getSummary().get(1)));
                add(String.format("Elements: %s", join(", ", input.getElements())));
                add(String.format("Color: %s", input.getColor()));
                add(String.format("Metal: %s", input.getMetals()));
                add(String.format("Vegetables: %s", join(", ", input.getVegetables())));
            }
        };
    }
}
