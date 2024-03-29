package com.johnhenrygibbs.contentcalendar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.johnhenrygibbs.contentcalendar.model.Content;
import com.johnhenrygibbs.contentcalendar.model.Status;
import com.johnhenrygibbs.contentcalendar.model.Type;
import com.johnhenrygibbs.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }

    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {
            Content content = new Content(null,
                    "Hello Chat GPT",
                    "All about Chat GPT",
                    Status.IDEA,
                    Type.VIDEO,
                    LocalDateTime.now(),
                    null,
                    "");

            repository.save(content);
        };
    }

}
