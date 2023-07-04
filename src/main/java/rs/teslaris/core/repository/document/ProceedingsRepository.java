package rs.teslaris.core.repository.document;

import org.springframework.stereotype.Repository;
import rs.teslaris.core.model.document.Proceedings;
import rs.teslaris.core.repository.JPASoftDeleteRepository;

@Repository
public interface ProceedingsRepository extends JPASoftDeleteRepository<Proceedings> {
}
