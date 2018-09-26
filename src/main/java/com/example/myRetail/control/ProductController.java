package com.example.myRetail.control;

import com.example.myRetail.model.dao.PriceDao;
import com.example.myRetail.model.entity.Price;
import com.example.myRetail.model.entity.Product;
import com.example.myRetail.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;
    Product product = new Product();
    PriceDao priceDao = new PriceDao();

    // GET
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, value="/product/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        String jsonString = null;
        try {
            jsonString = productService.getProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        product.setId(id);
        product = parseName(jsonString);
        Price price = priceDao.getPrice(id);
        product.setCurrent_price(price);
        return product;
    }

    // Parse id
    private Product parseName(String jsonString) {
        if (jsonString == null) {
            throw new IllegalArgumentException("The response from myRetail api was null. Check that you have a valid product id");
        }
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject productObj = jsonObject.getJSONObject("product");
        JSONObject itemObj = productObj.getJSONObject("item");
        JSONObject productDescription = itemObj.getJSONObject("product_description");
        product.setName(productDescription.getString("title"));
        return product;
    }

    // PUT
    @PutMapping
    @RequestMapping(method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, value="/product/{id}")
    ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product newProductPrice) {
        Double newPrice = newProductPrice.getCurrent_price().getValue();
        System.out.println("New price is: " + newPrice);
        PriceDao pd = new PriceDao();
        pd.setPrice(id, newPrice);
        String jsonString = null;
        try {
            jsonString = productService.getProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        product.setId(id);
        product = parseName(jsonString);
        Price price = priceDao.getPrice(id);
        product.setCurrent_price(price);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
