package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Product;
import hutech.cmp1024.website_fashion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public String home()
    {
        return "home/index";
    }

}
