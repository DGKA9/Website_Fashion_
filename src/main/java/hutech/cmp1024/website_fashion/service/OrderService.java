package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Order;
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

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    public void updateOrder(Order order) {
        orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    public Order detailsOrder(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        if(!order.isPresent())
        {
            throw new EntityNotFoundException("Không tìm thấy!");
        }

        return order.get();
    }
}
