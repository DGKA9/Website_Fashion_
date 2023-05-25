package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Customer;
import hutech.cmp1024.website_fashion.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String showAllCustomer(Model model)
    {
        List<Customer> customers = customerService.getAllCustomer();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/add")
    public String addCustomerForm(Model model)
    {
        model.addAttribute("customers", new Customer());
        return "customer/add";
    }
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customers") Customer customer)
    {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm (@PathVariable("id") Long id, Model model) {
        Customer editCustomer = customerService.getCustomerById(id);
        if (editCustomer != null) {
            model.addAttribute("customers", editCustomer);
            return "customer/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editCustomer (@ModelAttribute("customers") Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id)
    {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @GetMapping("/detail/{id}")
    public Customer CustomerDetails(@PathVariable Long id) {
        return customerService.detailsCustomer(id);
    }
}
