package com.kafka.wikimedia.consumer;

import com.kafka.wikimedia.consumer.entity.WikimediaData;
import com.kafka.wikimedia.consumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recent_changes",groupId = "myGroup")
    public void consumer(String eventMessage){
      LOGGER.info("Event message received -> {}",eventMessage);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}
