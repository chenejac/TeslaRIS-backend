package rs.teslaris.core.model.document;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.teslaris.core.model.commontypes.BaseEntity;
import rs.teslaris.core.model.commontypes.MultiLingualContent;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_files")
public class DocumentFile extends BaseEntity {

    @Column(name = "filename", nullable = false)
    String filename;

    @Column(name = "server_filename", nullable = false, unique = true)
    String serverFilename;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<MultiLingualContent> description;

    @Column(name = "mime_type", nullable = false)
    String mimeType;

    @Column(name = "file_size", nullable = false)
    int fileSize;

    @Column(name = "resource_type", nullable = false)
    ResourceType resourceType;

    @Column(name = "license", nullable = false)
    License license;
}