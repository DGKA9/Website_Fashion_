package hutech.cmp1024.website_fashion.controller;
import hutech.cmp1024.website_fashion.entity.Donhang;
import hutech.cmp1024.website_fashion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showAllOrder(Model model)
    {
        List<Donhang> orders = orderService.getAllOrder();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/add")
    public String addOrderForm(Model model)
    {
        model.addAttribute("orders", new Donhang());
        return "order/add";
    }
    @PostMapping("/add")
    public String addOrder(@ModelAttribute("orders") Donhang order)
    {
        orderService.addOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm (@PathVariable("id") Long id, Model model) {
        Donhang editOrder = orderService.getOrderById(id);
        if (editOrder != null) {
            model.addAttribute("orders", editOrder);
            return "order/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editOrder (@ModelAttribute("orders") Donhang order) {
        orderService.updateOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id)
    {
        orderService.deleteOrder(id);
        return "redirect:/order";
    }

    @GetMapping("/detail/{id}")
    public Donhang OrderDetails(@PathVariable Long id) {
        return orderService.detailsOrder(id);
    }
}
