package rs.teslaris.core.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.teslaris.core.model.document.ProceedingsPublication;
import rs.teslaris.core.repository.JPASoftDeleteRepository;

@Repository
public interface ProceedingsPublicationRepository
    extends JPASoftDeleteRepository<ProceedingsPublication> {
}
