package com.johnhenrygibbs.contentcalendar.config;

import com.johnhenrygibbs.contentcalendar.model.Content;
import com.johnhenrygibbs.contentcalendar.model.Status;
import com.johnhenrygibbs.contentcalendar.model.Type;
import com.johnhenrygibbs.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
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
