package work.icql.icm.product.b.server.service.biz;

public class PaymentStrategyDemo {
    // 1. 策略接口
    public interface PaymentStrategy {
        void pay(double amount);
    }

    // 2. 具体策略实现
    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.printf("信用卡支付成功：¥%.2f（扣除1%%手续费）%n", amount * 1.01);
        }
    }

    public static class WeChatPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.printf("微信支付成功：¥%.2f（实时到账）%n", amount);
        }
    }

    public static class CouponPayment implements PaymentStrategy {
        private final double discount;

        public CouponPayment(double discount) {
            this.discount = discount;
        }

        @Override
        public void pay(double amount) {
            double finalAmount = amount * (1 - discount);
            System.out.printf("优惠券支付：原价¥%.2f → 实付¥%.2f（%.0f折）%n",
                    amount, finalAmount, (1 - discount) * 10);
        }
    }

    // 3. 上下文类（策略容器）
    public static class PaymentContext {
        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {
            if(strategy == null) {
                throw new IllegalStateException("未设置支付策略");
            }
            strategy.pay(amount);
        }
    }

    // 4. 客户端使用示例
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // 使用信用卡支付
        context.setStrategy(new CreditCardPayment());
        context.executePayment(500.0);

        // 切换微信支付
        context.setStrategy(new WeChatPayment());
        context.executePayment(200.0);

        // 使用优惠券支付
        context.setStrategy(new CouponPayment(0.3)); // 7折优惠
        context.executePayment(1000.0);
    }
}
