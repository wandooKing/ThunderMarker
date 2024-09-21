package thundermarket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import thundermarket.SaleApplication;
import thundermarket.domain.ProductRegistered;

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
        ProductRegistered productRegistered = new ProductRegistered(this);
        productRegistered.publishAfterCommit();
    }

    public static SaleRepository repository() {
        SaleRepository saleRepository = SaleApplication.applicationContext.getBean(
            SaleRepository.class
        );
        return saleRepository;
    }

    public void registerProduct() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
