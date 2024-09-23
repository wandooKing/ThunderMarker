package thundermarket.domain;

import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private String status;
    private String customerId;
    private String customerName;
    private Long productId;
    private Integer price;
}
