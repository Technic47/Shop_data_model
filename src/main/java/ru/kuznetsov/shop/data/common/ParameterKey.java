package ru.kuznetsov.shop.data.common;

public interface ParameterKey {

    String BASE_URL_PARAMETER = "BASE_URL";

    String ADDRESS_PORT_PARAMETER = "ADDRESS_PORT";
    String PRODUCT_PORT_PARAMETER = "PRODUCT_PORT";
    String PRODUCT_CATEGORY_PORT_PARAMETER = "PRODUCT_CATEGORY_PORT";
    String STOCK_PORT_PARAMETER = "STOCK_PORT";
    String STORE_PORT_PARAMETER = "STORE_PORT";
    String OPERATION_PORT_PARAMETER = "OPERATION_PORT";
    String ORDER_PORT_PARAMETER = "ORDER_PORT";

    String ADDRESS_MODULE = "/address";
    String PRODUCT_MODULE = "/product";
    String PRODUCT_CATEGORY_MODULE = "/product-category";
    String STOCK_MODULE = "/stock";
    String STORE_MODULE = "/store";
    String OPERATION_MODULE = "/operation";
    String ORDER_MODULE = "/order";
    String ORDER_STATUS_MODULE = "/order/status";
    String ORDER_BUCKET_MODULE = "/order/bucket";
}
