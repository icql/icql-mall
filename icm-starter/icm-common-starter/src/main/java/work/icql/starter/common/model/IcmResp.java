package work.icql.starter.common.model;

import lombok.Data;

import java.util.Objects;

@Data
public class IcmResp<T> {

    private String code;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return Objects.equals(this.code, IcmRespCode.SUCCESS.getCode());
    }

    public boolean isFail() {
        return !Objects.equals(this.code, IcmRespCode.SUCCESS.getCode());
    }

    public static <T> IcmResp<T> success() {
        return success(null);
    }

    public static <T> IcmResp<T> success(T data) {
        IcmResp<T> icmResp = new IcmResp<>();
        icmResp.setCode("0");
        icmResp.setMsg("");
        icmResp.setData(data);
        return icmResp;
    }

    public static <T> IcmResp<T> fail(IcmRespCode code) {
        IcmResp<T> icmResp = new IcmResp<>();
        icmResp.setCode(code.getCode());
        icmResp.setMsg(code.getMsg());
        return icmResp;
    }
}
