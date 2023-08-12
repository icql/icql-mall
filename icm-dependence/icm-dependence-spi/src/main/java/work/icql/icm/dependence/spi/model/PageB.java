package work.icql.icm.dependence.spi.model;

import lombok.Data;

import java.util.List;

@Data
public class PageB<T> {

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 总数量
     */
    private long total = 0;

    /**
     * 数据
     */
    private List<T> data;
}
