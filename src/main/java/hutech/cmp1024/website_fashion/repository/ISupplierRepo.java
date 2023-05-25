package hutech.cmp1024.website_fashion.repository;

import hutech.cmp1024.website_fashion.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepo extends JpaRepository<Supplier, Long> {
}
