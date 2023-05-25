package hutech.cmp1024.website_fashion.repository;
import hutech.cmp1024.website_fashion.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Long> {
}
