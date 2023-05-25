package hutech.cmp1024.website_fashion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "condition")
    private String condition;


    @ManyToOne
    @JoinColumn(name = "pay_id")
    private Pay pay;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> orderDetails;

}
