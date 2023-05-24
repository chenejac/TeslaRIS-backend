package rs.teslaris.core.service.impl;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.teslaris.core.dto.institution.ResearchAreaDTO;
import rs.teslaris.core.exception.ResearchAreaInUseException;
import rs.teslaris.core.model.commontypes.ResearchArea;
import rs.teslaris.core.repository.commontypes.ResearchAreaRepository;
import rs.teslaris.core.service.MultilingualContentService;
import rs.teslaris.core.service.ResearchAreaService;

@Service
@RequiredArgsConstructor
@Transactional
public class ResearchAreaServiceImpl implements ResearchAreaService {

    private final ResearchAreaRepository researchAreaRepository;

    private final MultilingualContentService multilingualContentService;


    @Override
    public ResearchArea getReferenceToResearchAreaById(Integer id) {
        return researchAreaRepository.getReferenceById(id);
    }

    @Override
    public ResearchArea createResearchArea(ResearchAreaDTO researchAreaDTO) {
        var newResearchArea = new ResearchArea();
        newResearchArea.setName(
            multilingualContentService.getMultilingualContent(researchAreaDTO.getName()));
        newResearchArea.setDescription(
            multilingualContentService.getMultilingualContent(researchAreaDTO.getDescription()));
        newResearchArea.setSuperResearchArea(
            researchAreaRepository.getReferenceById(researchAreaDTO.getSuperResearchAreaId()));

        return researchAreaRepository.save(newResearchArea);
    }

    @Override
    public void editResearchArea(ResearchAreaDTO researchAreaDTO, Integer researchAreaId) {
        var reserchAreaToUpdate = getReferenceToResearchAreaById(researchAreaId);

        reserchAreaToUpdate.getName().clear();
        reserchAreaToUpdate.setName(
            multilingualContentService.getMultilingualContent(researchAreaDTO.getName()));
        reserchAreaToUpdate.getDescription().clear();
        reserchAreaToUpdate.setDescription(
            multilingualContentService.getMultilingualContent(researchAreaDTO.getDescription()));

        reserchAreaToUpdate.setSuperResearchArea(
            researchAreaRepository.getReferenceById(researchAreaDTO.getSuperResearchAreaId()));

        researchAreaRepository.save(reserchAreaToUpdate);
    }

    @Override
    public void deleteResearchArea(Integer researchAreaId) {
        if (researchAreaRepository.isSuperArea(researchAreaId) ||
            researchAreaRepository.isResearchedBySomeone(researchAreaId) ||
            researchAreaRepository.isResearchedInMonograph(researchAreaId) ||
            researchAreaRepository.isResearchedInThesis(researchAreaId)) {
            throw new ResearchAreaInUseException(
                "Research area with id " + researchAreaId + " cannot be deleted as it is in use.");
        }

        var researchAreaToDelete = getReferenceToResearchAreaById(researchAreaId);
        researchAreaRepository.delete(researchAreaToDelete);
    }
}