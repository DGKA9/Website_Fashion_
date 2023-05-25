package hutech.cmp1024.website_fashion.repository;

import hutech.cmp1024.website_fashion.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Long> {

}
