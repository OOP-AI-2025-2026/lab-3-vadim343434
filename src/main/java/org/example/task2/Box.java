package org.example.task2;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина повинна бути більшою за 0!");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина повинна бути більшою за 0!");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Висота повинна бути більшою за 0!");
        }
        this.height = height;
    }

    public double getSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double getLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double getVolume() {
        return length * width * height;
    }
}
