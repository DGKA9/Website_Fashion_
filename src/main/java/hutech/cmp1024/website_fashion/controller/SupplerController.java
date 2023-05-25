package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Supplier;
import hutech.cmp1024.website_fashion.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplerController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String showAllSupplier(Model model)
    {
        List<Supplier> suppliers = supplierService.getAllSupplier();
        model.addAttribute("suppliers", suppliers);
        return "supplier/list";
    }

    @GetMapping("/add")
    public String addSupplierForm(Model model)
    {
        model.addAttribute("suppliers", new Supplier());
        return "supplier/add";
    }
    @PostMapping("/add")
    public String addSupplier(@ModelAttribute("suppliers") Supplier supplier)
    {
        supplierService.addSupplier(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/edit/{id}")
    public String editSupplierForm (@PathVariable("id") Long id, Model model) {
        Supplier editSupplier = supplierService.getSupplierById(id);
        if (editSupplier != null) {
            model.addAttribute("suppliers", editSupplier);
            return "supplier/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editSupplier (@ModelAttribute("suppliers") Supplier supplier) {
        supplierService.updateSupplier(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") Long id)
    {
        supplierService.deleteSupplier(id);
        return "redirect:/supplier";
    }

    @GetMapping("/detail/{id}")
    public Supplier SupplierDetails(@PathVariable Long id) {
        return supplierService.detailsSupplier(id);
    }
}
