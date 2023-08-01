package work.icql.icm.dependence.spi.model;

import lombok.Data;

/**
 * 分页
 */
@Data
public class Page<T> {

    /**
     * 页码
     */
    private int page = 1;

    /**
     * 每页数量
     */
    private int size = 10;

    /**
     * 是否有下一页
     */
    private boolean next = false;

    /**
     * 数据
     */
    private T data;
}
