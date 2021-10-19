package com.iit.elasticsearchgyak;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface ChatMessageRepository extends ElasticsearchRepository<ChatMessage, String> {

    Page<ChatMessage> findBySender(String sender, Pageable pageable);

    Page<ChatMessage> findByMessage(String message, Pageable pageable);

}
