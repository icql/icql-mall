package work.icql.icm.dependence.spi.model;

public enum IcmRespCode {
    SUCCESS("0", ""),
    ERROR("-1","系统异常")
    ;


    /**
     * 状态码
     */
    private final String code;

    /**
     * 状态提示信息
     */
    private final String message;

    IcmRespCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
