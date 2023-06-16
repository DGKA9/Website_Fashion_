package hutech.cmp1024.website_fashion.service;

import hutech.cmp1024.website_fashion.entity.Category;
import hutech.cmp1024.website_fashion.repository.ICategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    public Category detailsCategory(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isEmpty())
        {
            throw new EntityNotFoundException("Không tìm thấy loại có id là: " + id);
        }

        return category.get();
    }

}
