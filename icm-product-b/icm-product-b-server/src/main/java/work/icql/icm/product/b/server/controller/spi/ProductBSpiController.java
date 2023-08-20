package work.icql.icm.product.b.server.controller.spi;

import org.springframework.web.bind.annotation.RestController;
import work.icql.icm.dependence.spi.model.IcmResp;
import work.icql.icm.product.b.spi.ProductBSpi;
import work.icql.icm.product.b.spi.request.CreateProductBatchReq;
import work.icql.icm.product.b.spi.request.CreateProductReq;
import work.icql.icm.product.b.spi.response.CreateProductBatchResp;
import work.icql.icm.product.b.spi.response.CreateProductResp;

@RestController
public class ProductBSpiController implements ProductBSpi {

    @Override
    public IcmResp<CreateProductResp> createProduct(CreateProductReq req) {
        return IcmResp.success();
    }

    @Override
    public IcmResp<CreateProductBatchResp> createProductBatch(CreateProductBatchReq req) {
        return IcmResp.success();
    }
}
