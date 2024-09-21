package thundermarket.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thundermarket.config.kafka.KafkaProcessor;
import thundermarket.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_DecreaseStock(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener DecreaseStock : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductDeleted'"
    )
    public void wheneverProductDeleted_DecreaseStock(
        @Payload ProductDeleted productDeleted
    ) {
        ProductDeleted event = productDeleted;
        System.out.println(
            "\n\n##### listener DecreaseStock : " + productDeleted + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryFailed'"
    )
    public void wheneverDeliveryFailed_IncreaseStock(
        @Payload DeliveryFailed deliveryFailed
    ) {
        DeliveryFailed event = deliveryFailed;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + deliveryFailed + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductAdded'"
    )
    public void wheneverProductAdded_IncreaseStock(
        @Payload ProductAdded productAdded
    ) {
        ProductAdded event = productAdded;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + productAdded + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
