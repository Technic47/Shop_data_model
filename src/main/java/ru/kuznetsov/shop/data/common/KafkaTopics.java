package ru.kuznetsov.shop.data.common;

public interface KafkaTopics {
    //Save
    String ADDRESS_SAVE_TOPIC = "shop_save_address";
    String PRODUCT_CATEGORY_SAVE_TOPIC = "shop_save_product_category";
    String PRODUCT_SAVE_TOPIC = "shop_save_product";
    String STOCK_SAVE_TOPIC = "shop_save_stock";
    String STORE_SAVE_TOPIC = "shop_save_store";

    //Update
    String ADDRESS_UPDATE_TOPIC = "shop_update_address";
    String PRODUCT_CATEGORY_UPDATE_TOPIC = "shop_update_product_category";
    String PRODUCT_UPDATE_TOPIC = "shop_update_product";
    String STOCK_UPDATE_TOPIC = "shop_update_stock";
    String STORE_UPDATE_TOPIC = "shop_update_store";
}
