package com.example.myRetail.service

import com.example.myRetail.model.entity.Price
import com.example.myRetail.model.entity.Product
import org.mockito.InjectMocks
import org.mockito.Mock

class ProductServiceUnitTest extends GroovyTestCase {
    public static final int BIG_LEBOWSKY_ID = 13860428
    public static final int INVALID_ID = 52690549
    public static final int ONE_THOUSAND = 1000.00
    public static final String BIG_LEBOWSKY_TITLE = "The Big Lebowski (Blu-ray)"

    public static final String MY_RETAIL_JSON = "{\"product\":{\"deep_red_labels\":{\"total_count\":2,\"labels\":[{\"id\":\"gqwm8i\",\"name\":\"TAC\",\"type\":\"relationship type\",\"priority\":0,\"count\":1},{\"id\":\"twbl94\",\"name\":\"Movies\",\"type\":\"merchandise type\",\"priority\":0,\"count\":1}]},\"available_to_promise_network\":{\"product_id\":\"13860428\",\"id_type\":\"TCIN\",\"available_to_promise_quantity\":17,\"street_date\":\"2011-11-15T06:00:00.000Z\",\"availability\":\"AVAILABLE\",\"online_available_to_promise_quantity\":17,\"stores_available_to_promise_quantity\":0,\"availability_status\":\"IN_STOCK\",\"multichannel_options\":[],\"is_infinite_inventory\":false,\"loyalty_availability_status\":\"IN_STOCK\",\"loyalty_purchase_start_date_time\":\"1970-01-01T00:00:00.000Z\",\"is_loyalty_purchase_enabled\":false,\"is_out_of_stock_in_all_store_locations\":false,\"is_out_of_stock_in_all_online_locations\":false},\"bulk_ship\":{\"tcins\":[{\"tcin\":\"13860428\",\"handlingItemCharge\":{\"itemBulky\":false}}]},\"rating_and_review_reviews\":{\"hasErrors\":false,\"offset\":0,\"totalResults\":0,\"limit\":10,\"duration\":2},\"promotion\":{\"subscriptionShippingMessage\":\"free shipping\",\"callout\":{\"text\":\"\",\"type\":{\"appliedTo\":\"\",\"description\":\"\"}},\"promotionList\":[]},\"question_answer_statistics\":{\"questionCount\":0,\"answerCount\":0},\"rating_and_review_statistics\":{\"hasErrors\":false,\"result\":{\"13860428\":{\"coreStats\":{\"RatingsOnlyReviewCount\":0,\"TotalReviewCount\":0,\"SecondaryRatingsAveragesOrder\":[],\"OverallRatingRange\":5,\"SecondaryRatingsAverages\":{},\"AverageOverallRating\":0.0,\"RatingDistribution\":[{\"Count\":0,\"RatingValue\":1},{\"Count\":0,\"RatingValue\":2},{\"Count\":0,\"RatingValue\":3},{\"Count\":0,\"RatingValue\":4},{\"Count\":0,\"RatingValue\":5}],\"RatingReviewTotal\":0},\"photoInfoList\":[],\"secondaryRatingFields\":[],\"expertReviewContentMetadata\":[{\"url\":\"/expertContent/13860428?vendor=common_sense\",\"lastUpdated\":\"2018-08-08T13:20:43.017+0000\",\"vendor\":\"COMMON_SENSE\",\"partNumber\":\"13860428\"}]}}},\"price\":{\"partNumber\":\"13860428\",\"channelAvailability\":\"0\",\"listPrice\":{\"minPrice\":0.0,\"maxPrice\":0.0,\"price\":19.98,\"formattedPrice\":\"\$19.98\",\"priceType\":\"MSRP\",\"null\":false},\"offerPrice\":{\"minPrice\":0.0,\"maxPrice\":0.0,\"price\":14.99,\"formattedPrice\":\"\$14.99\",\"priceType\":\"Reg\",\"startDate\":1538118000000,\"endDate\":253402236000000,\"saveDollar\":\"4.99\",\"savePercent\":\"25\",\"eyebrow\":\"\",\"null\":false},\"ppu\":\"\",\"mapPriceFlag\":\"N\"},\"item\":{\"tcin\":\"13860428\",\"bundle_components\":{\"is_assortment\":false,\"is_kit_master\":false,\"is_standard_item\":true,\"is_component\":false},\"dpci\":\"058-34-0436\",\"upc\":\"025192110306\",\"product_description\":{\"title\":\"The Big Lebowski (Blu-ray)\",\"bullet_description\":[\"<B>Movie Studio:</B> Universal Studios\",\"<B>Movie Genre:</B> Comedy\",\"<B>Software Format:</B> Blu-ray\"],\"general_description\":\"Blu-ray BIG LEBOWSKI, THE Movies\"},\"parent_items\":\"46767107\",\"buy_url\":\"https://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428\",\"variation\":{},\"enrichment\":{\"images\":[{\"base_url\":\"https://target.scene7.com/is/image/Target/\",\"primary\":\"GUEST_44aeda52-8c28-4090-85f1-aef7307ee20e\",\"content_labels\":[{\"image_url\":\"GUEST_44aeda52-8c28-4090-85f1-aef7307ee20e\",\"displayed_in_image\":{}}]}],\"sales_classification_nodes\":[{\"node_id\":\"5xswx\"},{\"node_id\":\"hp0vg\"},{\"node_id\":\"yzuww\"},{\"node_id\":\"5t0ak\"}]},\"return_method\":\"This item can be returned to any Target store or Target.com.\",\"handling\":{},\"recall_compliance\":{\"is_product_recalled\":false},\"tax_category\":{\"tax_class\":\"G\",\"tax_code_id\":99999,\"tax_code\":\"99999\"},\"display_option\":{\"is_size_chart\":false,\"is_warranty\":false},\"fulfillment\":{\"is_po_box_prohibited\":true,\"po_box_prohibited_message\":\"We regret that this item cannot be shipped to PO Boxes.\"},\"package_dimensions\":{\"weight\":\"0.18\",\"weight_unit_of_measure\":\"POUND\",\"width\":\"5.33\",\"depth\":\"6.65\",\"height\":\"0.46\",\"dimension_unit_of_measure\":\"INCH\"},\"environmental_segmentation\":{\"is_lead_disclosure\":false},\"manufacturer\":{},\"product_vendors\":[{\"id\":\"4667999\",\"manufacturer_style\":\"61119422\",\"vendor_name\":\"UNIVERSAL HOME VIDEO\"},{\"id\":\"1258738\",\"manufacturer_style\":\"025192110306\",\"vendor_name\":\"BAKER AND TAYLOR\"},{\"id\":\"1979650\",\"manufacturer_style\":\"61119422\",\"vendor_name\":\"Universal Home Ent PFS\"}],\"product_classification\":{\"product_type\":\"542\",\"product_type_name\":\"ELECTRONICS\",\"item_type_name\":\"Movies\",\"item_type\":{\"category_type\":\"Item Type: MMBV\",\"type\":300752,\"name\":\"Movies\"}},\"product_brand\":{\"brand\":\"Universal Home Video\"},\"item_state\":\"READY_FOR_LAUNCH\",\"specifications\":[],\"attributes\":{\"gift_wrapable\":\"N\",\"has_prop65\":\"N\",\"is_hazmat\":\"N\",\"max_order_qty\":10,\"street_date\":\"2011-11-15\",\"media_format\":\"Blu-ray\",\"merch_class\":\"MOVIES\",\"merch_classid\":58,\"merch_subclass\":34,\"return_method\":\"This item can be returned to any Target store or Target.com.\"},\"country_of_origin\":\"US\",\"relationship_type_code\":\"Title Authority Child\",\"subscription_eligible\":false,\"ribbons\":[],\"tags\":[],\"estore_item_status_code\":\"A\",\"return_policies\":{\"user\":\"Regular Guest\",\"policyDays\":\"30\",\"guestMessage\":\"This item must be returned within 30 days of the ship date. See return policy for details.\"},\"gifting_enabled\":true}}}"

    @Mock
    Product product
    @Mock
    Price price
    @InjectMocks
    ProductService productService = new ProductService()


    void setUp() {
        super.setUp()
        product = new Product()
        price = new Price()
    }

    void tearDown() {

    }

    void testGetProduct() {
//    productService.getProduct(product, BIG_LEBOWSKY_ID)
    }

    void testGetMyRetailJSON() {

    }

    void testSetTitle() {
        productService.setTitle(product, "foo")

        assertEquals("foo", product.getName())
    }

    void testGetTitle() {
        String response = productService.getTitle(MY_RETAIL_JSON)

        assertEquals(BIG_LEBOWSKY_TITLE, response)
    }

    void testSetProductId() {
        productService.setProductId(product, BIG_LEBOWSKY_ID)

        assertEquals(BIG_LEBOWSKY_ID, product.getId())
    }

    void testSetPriceFromDao() {
        price.setValue(ONE_THOUSAND)
        productService.setPriceFromDao(product, price)

        assertEquals(ONE_THOUSAND, product.getCurrent_price().getValue())
    }
}
