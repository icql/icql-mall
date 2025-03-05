package work.icql.starter.common.model;

import lombok.Data;

import java.util.List;

public class Page {

    /**
     * 用于小数据量分页
     */
    @Data
    public static class S<T> {

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


    /**
     * 用于大数据量分页
     */
    @Data
    public static class L<T> {

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
}
