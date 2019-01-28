package com.siyuan.base.web;

import com.siyuan.base.domain.Greeting;
import com.siyuan.base.domain.Quote;
import com.siyuan.base.remote.QuoteRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private QuoteRestAPI quoteRestAPI;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/getQuoteInfo")
    public Quote getQuoteInfo() {
        return quoteRestAPI.getQuote();
    }
}
