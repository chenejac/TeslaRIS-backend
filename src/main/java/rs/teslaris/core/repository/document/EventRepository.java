package rs.teslaris.core.repository.document;

import org.springframework.stereotype.Repository;
import rs.teslaris.core.model.document.Event;
import rs.teslaris.core.repository.JPASoftDeleteRepository;

@Repository
public interface EventRepository extends JPASoftDeleteRepository<Event> {
}
