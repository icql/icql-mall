package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略使用工厂
 */
public class StrategyFactory {

    private static final Map<String, Strategy> STRATEGY_BY_TYPE = new HashMap<>();

    static {
        STRATEGY_BY_TYPE.put("A", new ConcreteStrategyA());
        STRATEGY_BY_TYPE.put("B", new ConcreteStrategyB());
    }

    public Strategy getStrategy(String type) {
        //校验type
        return STRATEGY_BY_TYPE.get(type);
    }
}
