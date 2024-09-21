package thundermarket.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thundermarket.config.kafka.KafkaProcessor;
import thundermarket.domain.*;

@Service
public class CheckStockViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private CheckStockRepository checkStockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            CheckStock checkStock = new CheckStock();
            // view 객체에 이벤트의 Value 를 set 함
            checkStock.setId(orderPlaced.getProductId());
            checkStock.setOrderId(orderPlaced.getId());
            checkStock.setProductName(orderPlaced.getProductName());
            

            // view 레파지 토리에 save
            checkStockRepository.save(checkStock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockDecreased_then_UPDATE_1(
        @Payload StockDecreased stockDecreased
    ) {
        try {
            if (!stockDecreased.validate()) return;
            // view 객체 조회

            List<CheckStock> checkStockList = checkStockRepository.findByOrderId(
                stockDecreased.getId()
            );
            for (CheckStock checkStock : checkStockList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                checkStock.setQty(stockDecreased.getStock());
                // view 레파지 토리에 save
                checkStockRepository.save(checkStock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockIncreased_then_UPDATE_2(
        @Payload StockIncreased stockIncreased
    ) {
        try {
            if (!stockIncreased.validate()) return;
            // view 객체 조회

            List<CheckStock> checkStockList = checkStockRepository.findByOrderId(
                stockIncreased.getId()
            );
            for (CheckStock checkStock : checkStockList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                checkStock.setQty(stockIncreased.getStock());
                // view 레파지 토리에 save
                checkStockRepository.save(checkStock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
