package org.activiti.cloud.runtime.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {


    private final String currentTopic;

    public TopicController( @Value("${campaign.topic}") String currentTopic) {
        this.currentTopic = currentTopic;
        System.out.println("TopicController Created for topic: " + this.currentTopic);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/topic")
    public String getCurrentTopic() {
        return currentTopic;
    }

    public boolean matchTopic(String text) {
        return text.toLowerCase().contains(currentTopic.toLowerCase());
    }
}
