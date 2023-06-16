package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Pay;
import hutech.cmp1024.website_fashion.repository.IPayRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayService {
    @Autowired
    private IPayRepo payRepo;

    public List<Pay> getAllPay(){
        return payRepo.findAll();
    }

    public Pay getPayById(Long id) {
        return payRepo.findById(id).orElse(null);
    }

    public void addPay(Pay pay) {
        payRepo.save(pay);
    }

    public void updatePay(Pay pay) {
        payRepo.save(pay);
    }

    public void deletePay(Long id) {
        payRepo.deleteById(id);
    }

    public Pay detailsPay(Long id) {
        Optional<Pay> pay = payRepo.findById(id);
        if(pay.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy phương thức thanh toán này!");
        }

        return pay.get();
    }
}
