package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductRegistered extends AbstractEvent {

    private Long id;

    public ProductRegistered(Sale aggregate) {
        super(aggregate);
    }

    public ProductRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
