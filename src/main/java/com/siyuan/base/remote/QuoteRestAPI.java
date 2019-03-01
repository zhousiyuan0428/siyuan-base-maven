package com.siyuan.base.remote;

import com.siyuan.base.domain.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteRestAPI {

    private static final Logger logger = LoggerFactory.getLogger(QuoteRestAPI.class);

    public Quote getQuote(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
