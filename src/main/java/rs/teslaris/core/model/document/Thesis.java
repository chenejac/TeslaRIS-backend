package rs.teslaris.core.model.document;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import rs.teslaris.core.model.commontypes.LanguageTag;
import rs.teslaris.core.model.commontypes.ResearchArea;
import rs.teslaris.core.model.institution.OrganisationUnit;

@Getter
@Setter
@Entity
@Table(name = "theses")
public class Thesis extends Document {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_unit_id", nullable = false)
    OrganisationUnit organisationUnit;

    @Column(name = "thesis_type", nullable = false)
    ThesisType thesisType;

    @Column(name = "number_of_pages")
    Integer numberOfPages;

    @OneToMany(fetch = FetchType.LAZY)
    Set<LanguageTag> languages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "research_area_id")
    ResearchArea researchArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    Publisher publisher;
}
