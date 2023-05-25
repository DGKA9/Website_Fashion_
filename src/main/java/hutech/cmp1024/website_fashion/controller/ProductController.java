package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Product;
import hutech.cmp1024.website_fashion.service.ProductService;
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

    @GetMapping
    public String showAllProduct(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/add")
    public String addProductForm(Model model)
    {
        model.addAttribute("products", new Product());
        return "product/add";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("products") Product product)
    {
        productService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm (@PathVariable("id") Long id, Model model) {
        Product editProduct = productService.getProductById(id);
        if (editProduct != null) {
            model.addAttribute("products", editProduct);
            return "product/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editProduct (@ModelAttribute("products") Product product) {
        productService.updateProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public Product ProductDetails(@PathVariable Long id) {
        return productService.detailsProduct(id);
    }
}
