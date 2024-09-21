package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCanceld extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private String status;
    private String customerId;
    private String customerName;

    public OrderCanceld(Order aggregate) {
        super(aggregate);
    }

    public OrderCanceld() {
        super();
    }
}
//>>> DDD / Domain Event
