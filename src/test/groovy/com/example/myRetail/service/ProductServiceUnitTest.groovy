package com.example.myRetail.service

import com.example.myRetail.model.entity.Product
import org.mockito.Mock

class ProductServiceUnitTest extends GroovyTestCase {
    public static final int BIG_LEWBOWSKY_ID = 13860428
    public static final int INVALID_ID = 52690549
    public static final int ONE_THOUSAND = 1000.00

    ProductService productService = new ProductService()
    @Mock
    Product product

    void setUp() {
        super.setUp()
        product = new Product()
    }

    void tearDown() {
    }

    void testGetProduct() {
//    productService.getProduct(product, BIG_LEWBOWSKY_ID)
    }

    void testGetMyRetailJSON() {
    }

    void testSetTitle() {
    }

    void testGetTitle() {
    }

    void testSetProductId() {
        productService.setProductId(product, BIG_LEWBOWSKY_ID)
        assertEquals(BIG_LEWBOWSKY_ID, product.getId())
    }

    void testSetPrice() {
//        productService.getPriceFromDao(product, ONE_THOUSAND)
//        assertEquals(ONE_THOUSAND, product.getCurrent_price())
    }
}
