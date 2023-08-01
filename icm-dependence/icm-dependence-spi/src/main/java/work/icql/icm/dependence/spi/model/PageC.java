package work.icql.icm.dependence.spi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageC<T> extends Page<T> {

    /**
     * 序列标识
     */
    private String seq = "";
}
