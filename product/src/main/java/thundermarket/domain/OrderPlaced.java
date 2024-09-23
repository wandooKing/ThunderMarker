package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import thundermarket.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer qty;
    private String status;
    private String customerId;
    private String customerName;
    private Long productId;
    private Integer price;
}
