package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Donhang;
import hutech.cmp1024.website_fashion.repository.IOrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepo orderRepo;

    public List<Donhang> getAllOrder(){
        return orderRepo.findAll();
    }

    public Donhang getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public void addOrder(Donhang order) {
        orderRepo.save(order);
    }

    public void updateOrder(Donhang order) {
        orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    public Donhang detailsOrder(Long id) {
        Optional<Donhang> order = orderRepo.findById(id);
        if(order.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy!");
        }

        return order.get();
    }
}
