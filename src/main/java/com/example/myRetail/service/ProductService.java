package com.example.myRetail.service;

import com.example.myRetail.model.dao.PriceDao;
import com.example.myRetail.model.entity.Price;
import com.example.myRetail.model.entity.Product;
import com.example.myRetail.util.IdNotFoundException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Produces;

@Service
public class ProductService {
    public static final String myRetailURL = "https://redsky.target.com/v2/pdp/tcin/";
    public static final String endURI = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
    RestTemplate restTemplate = new RestTemplate();

    private PriceDao priceDao = new PriceDao();

    public String getProduct(int id) throws RestClientException {
        return restTemplate.getForObject(myRetailURL + id + endURI, String.class);
    }


    public void addProductDetails(Product product, int id) {
        setProductId(product, id);
        setTitle(product, getMyRetailJSON(id));
        setPrice(product, id);
    }

    private String getMyRetailJSON(int id) {
        String myRetailJSON;
        try {
            myRetailJSON = this.getProduct(id);
        } catch (RestClientException e) {
            throw new IdNotFoundException("The product id \'" + id + "\' was not found in MyRetail. Please check that you have a valid tcin.");
        }
        return myRetailJSON;
    }

    private void setTitle(Product product, String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        String title = jsonObject.getJSONObject("product").getJSONObject("item").getJSONObject("product_description").getString("title");
        product.setName(title);
    }

    private void setProductId(Product product, int id) {
        product.setId(id);
    }

    private void setPrice(Product product, int id) {
        Price price = priceDao.getPrice(id);
        product.setCurrent_price(price);
    }

}