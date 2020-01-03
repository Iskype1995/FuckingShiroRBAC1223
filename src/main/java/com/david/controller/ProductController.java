package com.david.controller;

import com.david.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @RequestMapping("show")
    public List<Product> show(){
        List<Product> list = new LinkedList<>();
        for(int i=0;i<10;i++){
            Product product = new Product();
            product.setId(i);
            product.setName("name + "+i);
            product.setDesc("desc -> "+i);
            list.add(product);
        }
        return list;
    }
}
