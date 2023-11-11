package work.icql.icm.product.b.server.doc.code.designpattern.structural.bridge.shape;

import work.icql.java.designpattern.structural.bridge.color.Color;

public class CircleShape extends Shape {

    public CircleShape(Color color) {
        super(color);
    }

    @Override
    public void printShape() {
        color.printColor();
        System.out.println("圆形");
    }
}