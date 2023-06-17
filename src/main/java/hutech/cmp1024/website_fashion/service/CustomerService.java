package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Customer;
import hutech.cmp1024.website_fashion.repository.ICustomerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class CustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    public Customer detailsCustomer(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy khách hàng có id là: " + id);
        }

        return customer.get();
    }
}
