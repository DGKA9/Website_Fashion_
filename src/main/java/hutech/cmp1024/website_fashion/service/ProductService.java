package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Product;
import hutech.cmp1024.website_fashion.repository.IProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepo productRepo;

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Product detailsProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy sản phẩm có id là: !" + id);
        }

        return product.get();
    }
}
