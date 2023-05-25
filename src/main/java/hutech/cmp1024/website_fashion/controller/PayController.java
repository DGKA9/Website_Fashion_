package hutech.cmp1024.website_fashion.controller;

import hutech.cmp1024.website_fashion.entity.Pay;
import hutech.cmp1024.website_fashion.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pays")
public class PayController {
    @Autowired
    private PayService payService;

    @GetMapping
    public String showAllPay(Model model)
    {
        List<Pay> pays = payService.getAllPay();
        model.addAttribute("pays", pays);
        return "pay/list";
    }

    @GetMapping("/add")
    public String addPayForm(Model model)
    {
        model.addAttribute("pays", new Pay());
        return "pay/add";
    }
    @PostMapping("/add")
    public String addPay(@ModelAttribute("pays") Pay pay)
    {
        payService.addPay(pay);
        return "redirect:/pay";
    }

    @GetMapping("/edit/{id}")
    public String editPayForm (@PathVariable("id") Long id, Model model) {
        Pay editPay = payService.getPayById(id);
        if (editPay != null) {
            model.addAttribute("pays", editPay);
            return "pay/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editPay (@ModelAttribute("pays") Pay pay) {
        payService.updatePay(pay);
        return "redirect:/pay";
    }

    @GetMapping("/delete/{id}")
    public String deletePay(@PathVariable("id") Long id)
    {
        payService.deletePay(id);
        return "redirect:/pay";
    }

    @GetMapping("/detail/{id}")
    public Pay PayDetails(@PathVariable Long id) {
        return payService.detailsPay(id);
    }
}
