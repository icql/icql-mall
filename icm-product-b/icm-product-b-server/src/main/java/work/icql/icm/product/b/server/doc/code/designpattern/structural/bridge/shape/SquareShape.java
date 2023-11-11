package work.icql.icm.product.b.server.doc.code.designpattern.structural.bridge.shape;

import work.icql.java.designpattern.structural.bridge.color.Color;

public class SquareShape extends Shape {

    public SquareShape(Color color) {
        super(color);
    }

    @Override
    public void printShape() {
        color.printColor();
        System.out.println("正方形");
    }
}