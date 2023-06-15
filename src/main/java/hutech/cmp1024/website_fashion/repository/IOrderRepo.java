package hutech.cmp1024.website_fashion.repository;

import hutech.cmp1024.website_fashion.entity.Donhang;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  IOrderRepo extends JpaRepository<Donhang, Long> {
}
