package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Category;
import hutech.cmp1024.website_fashion.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategory(Model model)
    {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("category", categories);
        return "category/list";
    }

     @GetMapping("/add")
    public String addCategoryForm(Model model)
     {
         model.addAttribute("category", new Category());
         return "category/add";
     }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm (@PathVariable("id") Long id, Model model) {
        Category editCategory = categoryService.getCategoryById(id);
        if (editCategory != null) {
            model.addAttribute("category", editCategory);
            return "category/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editCategory (@ModelAttribute("category") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id)
    {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    @GetMapping("/detail/{id}")
    public Category CategoryDetails(@PathVariable Long id) {
        return categoryService.detailsCategory(id);
    }
}
