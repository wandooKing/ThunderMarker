package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductDeleted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private String productName;
    private String qty;
    private String price;

    public ProductDeleted(Sale aggregate) {
        super(aggregate);
    }

    public ProductDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
