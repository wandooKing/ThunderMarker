package thundermarket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import thundermarket.PaymentApplication;
import thundermarket.domain.Paid;
import thundermarket.domain.PaymentCanceled;

@Entity
@Table(name = "Pay_table")
@Data
//<<< DDD / Aggregate Root
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer qty;

    private Long orderId;

    private String address;

    private String status;

    private Long productId;

    private String paymentStatus;

    @PostPersist
    public void onPostPersist() {
        // Paid paid = new Paid(this);
        // paid.publishAfterCommit();
        // PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        // paymentCanceled.publishAfterCommit();
    }

    public static PayRepository repository() {
        PayRepository payRepository = PaymentApplication.applicationContext.getBean(
            PayRepository.class
        );
        return payRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pay(OrderPlaced orderPlaced) {
        Pay pay = new Pay();
        pay.setOrderId(orderPlaced.getId());;
        pay.setProductId(orderPlaced.getProductId());
        pay.setProductName(orderPlaced.getProductName());
        pay.setQty(orderPlaced.getQty());
        pay.setStatus("PaymentSuccessed");

        repository().save(pay);
        
        Paid paid = new Paid(pay);
        paid.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelPay(OrderCanceled orderCanceled) {
        Pay pay = new Pay();
        pay.setOrderId(orderCanceled.getId());;
        pay.setProductId(orderCanceled.getProductId());
        pay.setProductName(orderCanceled.getProductName());
        pay.setQty(orderCanceled.getQty());
        pay.setStatus("PaymentFailed");

        repository().save(pay);
        
        PaymentCanceled paymentCanceled = new PaymentCanceled(pay);
        paymentCanceled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
