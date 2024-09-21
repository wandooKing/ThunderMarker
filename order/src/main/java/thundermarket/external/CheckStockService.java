package thundermarket.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "${api.url.product}")
public interface CheckStockService {
    @GetMapping(path = "/checkStocks")
    public List<CheckStock> getCheckStock();

    @GetMapping(path = "/checkStocks/{id}")
    public CheckStock getCheckStock(@PathVariable("id") Long id);
}
