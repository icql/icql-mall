package work.icql.icm.infra.util.sdk.utils;

import java.util.Objects;

public final class NoNullUtils {

    private NoNullUtils() {
    }

    public static int value(Integer value) {
        if (Objects.isNull(value)) {
            return 0;
        }
        return value;
    }

    public static int value(Integer value, int defaultValue) {
        if (Objects.isNull(value)) {
            return defaultValue;
        }
        return value;
    }

    public static long value(Long value) {
        if (Objects.isNull(value)) {
            return 0L;
        }
        return value;
    }

    public static long value(Long value, long defaultValue) {
        if (Objects.isNull(value)) {
            return defaultValue;
        }
        return value;
    }

    public static float value(Float value) {
        if (Objects.isNull(value)) {
            return 0F;
        }
        return value;
    }

    public static float value(Float value, float defaultValue) {
        if (Objects.isNull(value)) {
            return defaultValue;
        }
        return value;
    }

    public static double value(Double value) {
        if (Objects.isNull(value)) {
            return 0D;
        }
        return value;
    }

    public static double value(Double value, double defaultValue) {
        if (Objects.isNull(value)) {
            return defaultValue;
        }
        return value;
    }

    public static String value(String value) {
        if (Objects.isNull(value)) {
            return "";
        }
        return value;
    }

    public static String value(String value, String defaultValue) {
        if (Objects.isNull(value)) {
            return defaultValue;
        }
        return value;
    }
}
