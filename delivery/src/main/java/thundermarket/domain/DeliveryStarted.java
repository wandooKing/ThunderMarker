package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private Long orderId;
    private String address;
    private String status;

    public DeliveryStarted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
//>>> DDD / Domain Event
