package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figureList = new ArrayList<>();

    public void addFigure(Shape shape){
        figureList.add(shape);
    }

    public void removeFigure(Shape shape){
        figureList.remove(shape);
    }

    public Shape getFigure(int n){
        return figureList.get(n);
    }

    public String showFigures(){
        String listOfFigures = "";
        for (Shape e : figureList){
            listOfFigures += (e.getShapeName()+", ");
        }
        return listOfFigures;
    }

    public List<Shape> getFigureList() {
        return figureList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeCollector collector = (ShapeCollector) o;

        return figureList != null ? figureList.equals(collector.figureList) : collector.figureList == null;
    }

    @Override
    public int hashCode() {
        return figureList != null ? figureList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShapeCollector{" +
                "figureList=" + figureList +
                '}';
    }
}
