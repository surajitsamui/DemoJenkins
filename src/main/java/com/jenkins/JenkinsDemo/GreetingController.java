package com.jenkins.JenkinsDemo;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {    
    private static final Logger logger = Logger.getLogger(GreetingController.class.getName());
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
       
        logger.log(Level.SEVERE, "hi this is SEVERE level");
        logger.log(Level.WARNING, "hi this is WARNING level");
        logger.log(Level.INFO, "hi this is INFO level");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
