package com.kafka.wikimedia.consumer.repository;

import com.kafka.wikimedia.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
