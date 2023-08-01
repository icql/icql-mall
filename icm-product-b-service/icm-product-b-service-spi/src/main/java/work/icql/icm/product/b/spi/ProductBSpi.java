package work.icql.icm.product.b.spi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import work.icql.icm.dependence.spi.model.IcmResp;
import work.icql.icm.product.b.spi.request.CreateProductBatchReq;
import work.icql.icm.product.b.spi.request.CreateProductReq;
import work.icql.icm.product.b.spi.response.CreateProductBatchResp;
import work.icql.icm.product.b.spi.response.CreateProductResp;

@RequestMapping("/product-b-service")
public interface ProductBSpi {

    @PostMapping("/product/createProduct")
    IcmResp<CreateProductResp> createProduct(@RequestBody CreateProductReq req);

    @PostMapping("/product/createProductBatch")
    IcmResp<CreateProductBatchResp> createProductBatch(@RequestBody CreateProductBatchReq req);
}
