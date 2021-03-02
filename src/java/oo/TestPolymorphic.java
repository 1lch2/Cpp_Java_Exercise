package oo;

public class TestPolymorphic {
    public static void main(String[] args) {
        SquareArea[] areas = new SquareArea[] {
            new SquareArea(2),
            new CircleArea(2),
            new TriangleArea(2)
        };

        for (SquareArea a : areas) {
            System.out.println(a.getArea()); // 多态在运行时决定使用哪一个方法
        }
    }
}

class SquareArea {
    protected double length;

    public SquareArea(double x) {
        this.length = x;
    }

    public double getArea() {
        return Math.pow(length, 2);
    }
}

class CircleArea extends SquareArea {
    public CircleArea(double x) {
        super(x);
    }

    @Override
    public double getArea() {
        return 3.14 * Math.pow(length, 2);
    }
}

class TriangleArea extends SquareArea {
    public TriangleArea(double x) {
        super(x);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.pow(length, 2);
    }
}