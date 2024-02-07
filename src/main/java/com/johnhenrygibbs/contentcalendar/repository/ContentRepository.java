package com.johnhenrygibbs.contentcalendar.repository;

import com.johnhenrygibbs.contentcalendar.model.Content;
import com.johnhenrygibbs.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content
            where status = :status
            """)
    List<Content> listByStatus(Status status);

}
