package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Product;
import hutech.cmp1024.website_fashion.service.CategoryService;
import hutech.cmp1024.website_fashion.service.ProductService;
import hutech.cmp1024.website_fashion.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public String showAllProduct(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/add6")
    public String addProductForm(Model model)
    {
        model.addAttribute("products", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        return "product/add";
    }
    @PostMapping("/add6")
    public String addProduct(@ModelAttribute("products") Product product)
    {
        productService.addProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edits/{id}")
    public String editProductForm (@PathVariable("id") Long id, Model model) {
        Product editProduct = productService.getProductById(id);
        if (editProduct != null) {
            model.addAttribute("products", editProduct);
            return "product/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edits")
    public String editProduct (@ModelAttribute("products") Product product) {
        productService.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }

    @GetMapping("/detail/{id}")
    public Product ProductDetails(@PathVariable Long id) {
        return productService.detailsProduct(id);
    }
}
