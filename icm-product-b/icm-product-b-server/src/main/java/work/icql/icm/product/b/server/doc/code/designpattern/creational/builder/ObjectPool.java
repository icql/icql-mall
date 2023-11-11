package work.icql.icm.product.b.server.doc.code.designpattern.creational.builder;

/**
 * 建造者模式
 */
public class ObjectPool {

    private int fieldA;

    private String fieldB;

    private ObjectPool(Builder builder) {
        this.fieldA = builder.fieldA;
        this.fieldB = builder.fieldB;
    }

    public static class Builder {

        private int fieldA;

        private String fieldB;

        public ObjectPool build() {
            //创建ObjectPool逻辑处理
            if (fieldA < 0) {
                throw new IllegalArgumentException("...");
            }
            if (fieldB == null || fieldB.isEmpty()) {
                throw new IllegalArgumentException("...");
            }
            return new ObjectPool(this);
        }

        public Builder setFieldA(int fieldA) {
            if (fieldA < 0) {
                throw new IllegalArgumentException("...");
            }
            this.fieldA = fieldA;
            return this;
        }

        public Builder setFieldB(String fieldB) {
            if (fieldB == null || fieldB.isEmpty()) {
                throw new IllegalArgumentException("...");
            }
            this.fieldB = fieldB;
            return this;
        }
    }
}
