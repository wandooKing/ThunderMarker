package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryFailed extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private Long orderId;
    private String address;
    private String status;

    public DeliveryFailed(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryFailed() {
        super();
    }
}
//>>> DDD / Domain Event
