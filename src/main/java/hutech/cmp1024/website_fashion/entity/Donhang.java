package hutech.cmp1024.website_fashion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "donhang")
public class Donhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "condition_dh")
    private String condition;


    @ManyToOne
    @JoinColumn(name = "pay_id")
    private Pay pay;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "donhang", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

}
