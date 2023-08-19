package work.icql.icm.dependence.spi.model;

import lombok.Getter;

@Getter
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
    private final String msg;

    IcmRespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
