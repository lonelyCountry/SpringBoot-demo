package com.lonelycountry.controller;

import com.lonelycountry.vo.GreetingVo;
import com.lonelycountry.vo.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author YeFan
 * 2018/4/2.
 */
@RestController
@RequestMapping(value = "/api")
public class GreetingController {
    private static final String TEMPLATE = "hello,%s!";
    private final AtomicLong counter = new AtomicLong();
    private final RestTemplate restTemplate;

    @Autowired
    public GreetingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/greeting", method = GET)
    public GreetingVo greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingVo(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @RequestMapping(value = "/greeting2/{name}", method = GET)
    public GreetingVo greeting2(@PathVariable(value = "name") String name) {
        return new GreetingVo(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @RequestMapping(value = "/client", method = GET)
    public Quote client() {
        RestTemplate restTemplate2 = new RestTemplate();
        return restTemplate2.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

    @RequestMapping(value = "/client2", method = GET)
    public Quote client2() {
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

}
