package rs.teslaris.core.dto.institution;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.teslaris.core.dto.commontypes.MultilingualContentDTO;
import rs.teslaris.core.dto.document.DocumentFileDTO;
import rs.teslaris.core.model.institution.OrganisationUnitRelationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationUnitsRelationDTO {

    private Integer id;

    @Valid
    private List<MultilingualContentDTO> sourceAffiliationStatement;

    @Valid
    private List<MultilingualContentDTO> targetAffiliationStatement;

    @NotNull(message = "You have to provide a valid relation type.")
    private OrganisationUnitRelationType relationType;

    @NotNull(message = "You have to provide a valid start date.")
    private LocalDate dateFrom;

    private LocalDate dateTo;

    @Valid
    private List<DocumentFileDTO> proofs;

    @Positive(message = "Organisation unit id must be a positive number.")
    private Integer sourceOrganisationUnitId;

    @Positive(message = "Organisation unit id must be a positive number.")
    private Integer targetOrganisationUnitId;
}
