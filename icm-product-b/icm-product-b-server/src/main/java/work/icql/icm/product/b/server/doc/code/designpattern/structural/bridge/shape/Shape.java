package work.icql.icm.product.b.server.doc.code.designpattern.structural.bridge.shape;


import work.icql.java.designpattern.structural.bridge.color.Color;

public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void printShape();
}
