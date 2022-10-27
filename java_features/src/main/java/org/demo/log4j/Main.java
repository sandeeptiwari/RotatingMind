package org.demo.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {

        System.setProperty("ENV", "prod");

        Logger logger = LoggerFactory.getLogger(Main.class);

        MDC.put("MDC_KEY", "VALUE");

        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.error("Error Message Logged !!!", new NullPointerException("Something is NULL"));

        logger.info("Article fecthed for id : {} is : {}", 1, 2);

        //Data masking example
        Map<String, String> customer = new HashMap<String, String>();

        customer.put("id", "12345");
        customer.put("ssn", "856-45-6789");
        customer.put("email", "admin@email.com");

        logger.info("Customer found with : {}", "Test1234");
        logger.debug("Customer found with : {}", "Test1234");
        logger.info("Customer found with : {}", "Test1234");
        logger.error("Customer found with : {}", "Test1234");
        logger.error("Customer found with : {}", "Test1234");
    }
}
