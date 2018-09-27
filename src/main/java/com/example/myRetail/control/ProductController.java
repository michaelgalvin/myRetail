package com.example.myRetail.control;

import com.example.myRetail.model.dao.PriceDao;
import com.example.myRetail.model.entity.Product;
import com.example.myRetail.service.ProductService;
import com.example.myRetail.util.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;


@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;
    Product product = new Product();

    // GET
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, value="/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {


        productService.addProductDetails(product, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    // PUT
    @PutMapping
    @RequestMapping(method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, value="/product/{id}")
    ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product newProductPrice) {
        Double newPrice = newProductPrice.getCurrent_price().getValue();
        PriceDao pd = new PriceDao();
        pd.setPrice(id, newPrice);

        productService.addProductDetails(product, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
