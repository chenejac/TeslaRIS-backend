package rs.teslaris.core.dto.document;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import rs.teslaris.core.dto.commontypes.MultilingualContentDTO;
import rs.teslaris.core.model.document.License;
import rs.teslaris.core.model.document.ResourceType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentFileDTO {

    private Integer id;

    private MultipartFile file;

    private List<MultilingualContentDTO> description;

    private ResourceType resourceType;

    private License license;
}
