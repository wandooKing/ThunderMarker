package thundermarket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import thundermarket.SaleApplication;
import thundermarket.domain.ProductAdded;
import thundermarket.domain.ProductDeleted;

@Entity
@Table(name = "Sale_table")
@Data
//<<< DDD / Aggregate Root
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    private String productName;

    private String qty;

    private String price;

    @PostPersist
    public void onPostPersist() {
        ProductAdded productAdded = new ProductAdded(this);
        productAdded.publishAfterCommit();

        ProductDeleted productDeleted = new ProductDeleted(this);
        productDeleted.publishAfterCommit();
    }

    public static SaleRepository repository() {
        SaleRepository saleRepository = SaleApplication.applicationContext.getBean(
            SaleRepository.class
        );
        return saleRepository;
    }

    public void addProduct() {
        //implement business logic here:

    }

    public void deleteProduct() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
