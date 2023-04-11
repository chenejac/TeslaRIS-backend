package rs.teslaris.core.model.project;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.teslaris.core.model.commontypes.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_relations")
public class ProjectsRelation extends BaseEntity {

    @Column(name = "relation_type", nullable = false)
    ProjectsRelationType relationType;

    @Column(name = "date_from", nullable = false)
    LocalDate from;

    @Column(name = "date_to", nullable = false)
    LocalDate to;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_project_id")
    Project sourceProject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_project_id")
    Project targetProject;
}
