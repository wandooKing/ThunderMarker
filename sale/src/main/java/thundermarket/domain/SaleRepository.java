package thundermarket.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thundermarket.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "sales", path = "sales")
public interface SaleRepository
    extends PagingAndSortingRepository<Sale, Long> {}
