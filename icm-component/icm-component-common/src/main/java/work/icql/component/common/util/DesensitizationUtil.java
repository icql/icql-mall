package work.icql.component.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * 敏感信息脱敏工具类
 * 说明：支持常见数据类型脱敏，空值安全处理
 */
public class DesensitizationUtil {

    /**
     * 手机号脱敏（保留前3后4）
     *
     * @param phone 手机号
     * @return 脱敏结果（如：138****5678）或原值（输入不合法时）
     */
    public static String maskPhone(String phone) {
        return Optional.ofNullable(phone)
                .filter(p -> p.length() == 11)
                .map(p -> p.substring(0, 3) + "****" + p.substring(7))
                .orElse(phone);
    }

    /**
     * 身份证号脱敏（保留前6后4）
     *
     * @param idCard 身份证号
     * @return 脱敏结果（如：110105********1234）或原值（输入不合法时）
     */
    public static String maskIdCard(String idCard) {
        return Optional.ofNullable(idCard)
                .filter(id -> id.length() >= 15)
                .map(id -> id.substring(0, 6) + "********" + id.substring(id.length() - 4))
                .orElse(idCard);
    }

    /**
     * 车牌号脱敏（普通车牌保留前2后1，新能源车牌保留前2后2）
     *
     * @param plate 车牌号
     * @return 脱敏结果（如：京A****8 或 京AD****12）或原值（输入不合法时）
     */
    public static String maskPlate(String plate) {
        if (StringUtils.isBlank(plate)) return plate;

        int length = plate.length();
        // 普通车牌（7位）保留前2后1，新能源车牌（8位）保留前2后2
        if (length == 7) {
            return plate.substring(0, 2) + "****" + plate.substring(6);
        } else if (length == 8) {
            return plate.substring(0, 2) + "****" + plate.substring(6);
        }
        return plate; // 非标准车牌返回原值
    }

    /**
     * 车架号脱敏（保留前3后4）
     *
     * @param vin 车架号（17位）
     * @return 脱敏结果（如：LGW****ZYX0123456）或原值（输入不合法时）
     */
    public static String maskVin(String vin) {
        return Optional.ofNullable(vin)
                .filter(v -> v.length() == 17)
                .map(v -> v.substring(0, 3) + "****" + v.substring(v.length() - 4))
                .orElse(vin);
    }

    /**
     * 姓名脱敏
     *
     * @param name 姓名
     * @return 脱敏结果（如：张* 或 欧阳*阳）或原值（输入不合法时）
     */
    public static String maskName(String name) {
        if (StringUtils.isBlank(name)) return name;

        int len = name.length();
        if (len == 2) {
            return name.charAt(0) + "*"; // 两字姓名：张* 
        } else if (len >= 3) {
            // 三字及以上：保留首字和末字，中间用星号
            return name.charAt(0) +
                    StringUtils.repeat('*', len - 2) +
                    name.charAt(len - 1);
        }
        return name; // 单字姓名返回原值
    }
}