package thundermarket.domain;

import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

@Data
@ToString
public class ProductAdded extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private String productName;
    private String qty;
    private String price;
}
