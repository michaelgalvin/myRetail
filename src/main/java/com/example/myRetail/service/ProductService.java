package com.example.myRetail.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    public static final String myRetailURL = "https://redsky.target.com/v2/pdp/tcin/";
    public static final String URI = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

    RestTemplate restTemplate = new RestTemplate();

    public String getProduct(int id)  {
        return restTemplate.getForObject(myRetailURL + id + URI, String.class);
    }

}