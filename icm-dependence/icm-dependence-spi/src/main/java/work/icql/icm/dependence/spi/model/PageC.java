package work.icql.icm.dependence.spi.model;

import lombok.Data;

import java.util.List;

@Data
public class PageC<T> {

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 是否有下一页
     */
    private boolean pageNext = false;

    /**
     * 序列标识
     */
    private String seq = "";

    /**
     * 数据
     */
    private List<T> data;
}
