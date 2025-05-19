package work.icql.icm.product.c.spi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import work.icql.icm.product.c.spi.request.QueryProductBatchReq;
import work.icql.icm.product.c.spi.request.QueryProductReq;
import work.icql.icm.product.c.spi.response.QueryProductBatchRsp;
import work.icql.icm.product.c.spi.response.QueryProductRsp;

@RequestMapping("/product-c-service")
public interface ProductCSpi {

    @PostMapping("/product/queryProduct")
    IcmResp<QueryProductRsp> queryProduct(@RequestBody QueryProductReq req);

    @PostMapping("/product/queryProductBatch")
    IcmResp<QueryProductBatchRsp> queryProductBatch(@RequestBody QueryProductBatchReq req);
}
