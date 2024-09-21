package thundermarket.domain;

import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;
    private Long orderId;
}
