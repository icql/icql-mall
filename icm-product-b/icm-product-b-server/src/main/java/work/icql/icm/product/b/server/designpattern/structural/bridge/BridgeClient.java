package work.icql.icm.product.b.server.designpattern.structural.bridge;

import work.icql.java.designpattern.structural.bridge.color.RedColor;
import work.icql.java.designpattern.structural.bridge.shape.CircleShape;
import work.icql.java.designpattern.structural.bridge.shape.Shape;
import work.icql.java.designpattern.structural.bridge.shape.SquareShape;

public class BridgeClient {

    public static void main(String[] args) {
        Shape shape1 = new CircleShape(new RedColor());
        shape1.printShape();

        Shape shape2 = new SquareShape(new RedColor());
        shape2.printShape();
    }
}