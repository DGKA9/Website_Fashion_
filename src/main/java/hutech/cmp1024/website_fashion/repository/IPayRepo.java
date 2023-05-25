package hutech.cmp1024.website_fashion.repository;

import hutech.cmp1024.website_fashion.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPayRepo extends JpaRepository<Pay, Long> {
}
