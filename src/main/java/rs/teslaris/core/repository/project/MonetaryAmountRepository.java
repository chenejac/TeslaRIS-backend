package rs.teslaris.core.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.teslaris.core.model.project.MonetaryAmount;
import rs.teslaris.core.repository.JPASoftDeleteRepository;

@Repository
public interface MonetaryAmountRepository extends JPASoftDeleteRepository<MonetaryAmount> {
}
