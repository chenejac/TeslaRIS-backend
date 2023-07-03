package rs.teslaris.core.service;

import org.springframework.stereotype.Service;
import rs.teslaris.core.dto.document.ProceedingsDTO;
import rs.teslaris.core.dto.document.ProceedingsResponseDTO;
import rs.teslaris.core.model.document.Proceedings;

@Service
public interface ProceedingsService {

    ProceedingsResponseDTO readProceedingsById(Integer proceedingsId);

    Proceedings findProceedingsById(Integer proceedingsId);

    Proceedings createProceedings(ProceedingsDTO proceedingsDTO);

    void updateProceedings(Integer proceedingsId, ProceedingsDTO proceedingsDTO);

    void deleteProceedings(Integer proceedingsId);
}