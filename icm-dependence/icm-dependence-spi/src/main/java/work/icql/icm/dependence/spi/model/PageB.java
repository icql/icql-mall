package work.icql.icm.dependence.spi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageB<T> extends Page<T> {

    /**
     * 总数量
     */
    private long total = 0;
}
