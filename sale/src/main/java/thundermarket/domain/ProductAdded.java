package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductAdded extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private String productName;
    private String qty;
    private String price;

    public ProductAdded(Sale aggregate) {
        super(aggregate);
    }

    public ProductAdded() {
        super();
    }
}
//>>> DDD / Domain Event
