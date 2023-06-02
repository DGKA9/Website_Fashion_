package hutech.cmp1024.website_fashion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pay")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payname")
    private String payName;

    @OneToMany(mappedBy = "pay", fetch = FetchType.LAZY)
    private List<Donhang> donhang;
}
