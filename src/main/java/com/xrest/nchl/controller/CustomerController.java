package com.xrest.nchl.controller;

import com.xrest.nchl.dto.RestResponseDto;
import com.xrest.nchl.model.Customer;
import com.xrest.nchl.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("v1/customer")
public class CustomerController extends BaseController<Customer,Long> {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        super(customerService);
        this.customerService = customerService;
    }

    @PostMapping("/upload/{id}")
    private ResponseEntity<?> save(@RequestParam(required = false,name = "image")MultipartFile file, @PathVariable("id")Long id) throws IOException {
        return new RestResponseDto().successModel(customerService.uploadProfile(file, id));
    }

    @PostMapping("/spec")
    private ResponseEntity<?> get(@RequestBody Map<String,String> obj) {
    return  new RestResponseDto().successModel(customerService.getAll(obj));
    }
}
