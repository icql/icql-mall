//package work.icql.icm.product.b.server.doc.code.designpattern.structural.adapter.object;
//
//import work.icql.java.designpattern.structural.adapter.ITarget;
//import work.icql.java.designpattern.structural.adapter.adaptee.Adaptee1;
//import work.icql.java.designpattern.structural.adapter.adaptee.Adaptee2;
//
///**
// * 对象适配器：可以综合适配多个适配者
// */
//public class ObjectAdaptor implements ITarget {
//
//    private Adaptee1 adaptee1;
//
//    private Adaptee2 adaptee2;
//
//    public ObjectAdaptor(Adaptee1 adaptee1, Adaptee2 adaptee2) {
//        this.adaptee1 = adaptee1;
//        this.adaptee2 = adaptee2;
//    }
//
//    @Override
//    public void operationA() {
//        //不需要修改，直接返回
//        adaptee1.operation1A();
//        //adaptee2.operation2A();
//    }
//
//    @Override
//    public void operationB() {
//        //需要修改，重新实现
//        adaptee1.operation1B();
//        adaptee2.operation2B();
//    }
//}
