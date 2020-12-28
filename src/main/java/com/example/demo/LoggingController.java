package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/logging")
@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    private static final org.slf4j.Logger Logger =
            org.slf4j.LoggerFactory.getLogger(LoggingController.class);
    
    Journal journal;

    @Autowired
   public LoggingController(Journal journal) {
	 this.journal = journal;
   }
    
    @GetMapping("/get")
    public String index() {
    	
    	String json = "{ code: '0000', message: 'response success', data: 'true' }";
    	
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message" );
        logger.info("An INFO Message response:" + json);
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        journal.log("Message sent to journal DB");
        Logger.error("Something else is wrong here");
        System.out.println("JESUS MATOS");

        return "Howdy! Check out the Logs to see the output...";
    }
}