package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Supplier;
import hutech.cmp1024.website_fashion.repository.ISupplierRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private ISupplierRepo supplierRepo;

    public List<Supplier> getAllSupplier(){
        return supplierRepo.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepo.findById(id).orElse(null);
    }

    public void addSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepo.deleteById(id);
    }

    public Supplier detailsSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if(supplier.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy Nhà cung cấp có id là: !"+id);
        }

        return supplier.get();
    }
}
