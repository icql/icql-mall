package work.icql.icm.product.b.server.doc.code.designpattern.structural.adapter.clazz;

import work.icql.java.designpattern.structural.adapter.adaptee.Adaptee1;
import work.icql.java.designpattern.structural.adapter.ITarget;

/**
 * 类适配器：缺陷，只能适配一个适配者
 */
public class ClazzAdaptor extends Adaptee1 implements ITarget {

    @Override
    public void operationA() {
        //不需要修改，直接返回
        super.operation1A();
    }

    @Override
    public void operationB() {
        //需要修改，重新实现
        super.operation1B();
    }
}
