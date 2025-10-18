package ru.kuznetsov.shop.data.common;

public interface KafkaTopics {
    //Save
    String ADDRESS_SAVE_TOPIC = "shop_save_address";
    String PRODUCT_CATEGORY_SAVE_TOPIC = "shop_save_product_category";
    String PRODUCT_SAVE_TOPIC = "shop_save_product";
    String STOCK_SAVE_TOPIC = "shop_save_stock";
    String STORE_SAVE_TOPIC = "shop_save_store";

    //Save successful
    String ADDRESS_SAVE_SUCCESSFUL_TOPIC = "shop_save_address_successful";
    String PRODUCT_CATEGORY_SAVE_SUCCESSFUL_TOPIC = "shop_save_product_category_successful";
    String PRODUCT_SAVE_SUCCESSFUL_TOPIC = "shop_save_product_successful";
    String STOCK_SAVE_SUCCESSFUL_TOPIC = "shop_save_stock_successful";
    String STORE_SAVE_SUCCESSFUL_TOPIC = "shop_save_store_successful";

    //Save failed
    String ADDRESS_SAVE_FAIL_TOPIC = "shop_save_address_fail";
    String PRODUCT_CATEGORY_SAVE_FAIL_TOPIC = "shop_save_product_category_fail";
    String PRODUCT_SAVE_FAIL_TOPIC = "shop_save_product_fail";
    String STOCK_SAVE_FAIL_TOPIC = "shop_save_stock_fail";
    String STORE_SAVE_FAIL_TOPIC = "shop_save_store_fail";

    //Update
    String ADDRESS_UPDATE_TOPIC = "shop_update_address";
    String PRODUCT_CATEGORY_UPDATE_TOPIC = "shop_update_product_category";
    String PRODUCT_UPDATE_TOPIC = "shop_update_product";
    String STOCK_UPDATE_TOPIC = "shop_update_stock";
    String STORE_UPDATE_TOPIC = "shop_update_store";
}
