package hutech.cmp1024.website_fashion.repository;

import hutech.cmp1024.website_fashion.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
