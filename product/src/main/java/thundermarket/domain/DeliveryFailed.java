package thundermarket.domain;

import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

@Data
@ToString
public class DeliveryFailed extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private Long orderId;
    private String address;
    private String status;
}
