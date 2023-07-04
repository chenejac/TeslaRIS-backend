package rs.teslaris.core.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.teslaris.core.model.document.DocumentFile;
import rs.teslaris.core.repository.JPASoftDeleteRepository;

@Repository
public interface DocumentFileRepository extends JPASoftDeleteRepository<DocumentFile> {

    DocumentFile getReferenceByServerFilename(String serverFilename);
}
