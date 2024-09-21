package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import thundermarket.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private Long orderId;
    private String address;
    private String status;
    private Long productId;
}
