package rs.teslaris.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.teslaris.core.exception.NotFoundException;
import rs.teslaris.core.model.institution.OrganisationUnit;
import rs.teslaris.core.repository.person.institution.OrganisationalUnitRepository;
import rs.teslaris.core.service.OrganisationUnitService;

@Service
@RequiredArgsConstructor
public class OrganisationUnitServiceImpl implements OrganisationUnitService {

    private final OrganisationalUnitRepository organisationalUnitRepository;

    @Override
    public OrganisationUnit findOrganisationalUnitById(Integer id) {
        return organisationalUnitRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(
                "Organisational unit with given ID does not exist."));
    }
}