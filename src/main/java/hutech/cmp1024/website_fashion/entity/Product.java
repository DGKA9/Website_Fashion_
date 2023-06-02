package hutech.cmp1024.website_fashion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Double price;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "product_order",
//            joinColumns = {
//                    @JoinColumn(name = "product_id", referencedColumnName = "id",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "donhang_id", referencedColumnName = "id",
//                            nullable = false, updatable = false)})
//    private Set<Donhang> donhang = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
