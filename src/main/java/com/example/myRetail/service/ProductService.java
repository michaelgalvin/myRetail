package com.example.myRetail.service;

import com.example.myRetail.model.dao.PriceDao;
import com.example.myRetail.model.entity.Price;
import com.example.myRetail.model.entity.Product;
import com.example.myRetail.util.IdNotFoundException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    private RestTemplate restTemplate = new RestTemplate();
    private Price price = new Price();
    private PriceDao priceDao = new PriceDao(price);

    private static final String myRetailURL = "https://redsky.target.com/v2/pdp/tcin/";
    private static final String endURI = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

    /*
    Serves as a single point of contact for the ProductService
     */
    public void getProduct(Product product, int id) {
        setProductId(product, id);
        setTitle(product, getTitle(getMyRetailJSON(id)));
        setPriceFromDao(product, priceDao.getPrice(id));
    }

    /*
    Connects to MyRetail.com's API and passes a tcin.
    The API responds with a JSON(String) representation of all the product details.
     */
    String getMyRetailJSON(int id) {
        String myRetailJSON;
        try {
            myRetailJSON = restTemplate.getForObject(myRetailURL + id + endURI, String.class);
        } catch (RestClientException e) {
            throw new IdNotFoundException("The product id \'" + id + "\' was not found in MyRetail. Please check that you have a valid tcin.");
        }
        return myRetailJSON;
    }

    /*
    Set the title in the product object.
     */
    void setTitle(Product product, String title) {
        product.setName(title);
    }

    /*
    Extract the products title from the myRetailJSON response string
     */
    String getTitle(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getJSONObject("product").getJSONObject("item").getJSONObject("product_description").getString("title");
    }

    /*
    Set the product id in the product object
     */
    void setProductId(Product product, int id) {
        product.setId(id);
    }

    /*
    Get the current price from priceDao, then set it in product
     */
    void setPriceFromDao(Product product, Price price) {
        product.setCurrent_price(price);
    }

}