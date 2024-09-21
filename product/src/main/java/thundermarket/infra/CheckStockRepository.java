package thundermarket.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thundermarket.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "checkStocks",
    path = "checkStocks"
)
public interface CheckStockRepository
    extends PagingAndSortingRepository<CheckStock, Long> {
    List<CheckStock> findByProductId(Long productId);
}
