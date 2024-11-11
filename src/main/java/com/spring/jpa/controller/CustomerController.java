package com.spring.jpa.controller;



import com.spring.jpa.model.Customer;
import com.spring.jpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/show-list")
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", iCustomerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormSave() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        iCustomerService.save(customer);
        return new ModelAndView("redirect:/customers/show-list");
    }
}

