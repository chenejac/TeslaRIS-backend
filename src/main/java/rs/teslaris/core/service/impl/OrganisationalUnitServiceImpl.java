package rs.teslaris.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.teslaris.core.exception.NotFoundException;
import rs.teslaris.core.model.institution.OrganisationUnit;
import rs.teslaris.core.repository.OrganisationalUnitRepository;
import rs.teslaris.core.service.OrganisationalUnitService;

@Service
@RequiredArgsConstructor
public class OrganisationalUnitServiceImpl implements OrganisationalUnitService {

    private final OrganisationalUnitRepository organisationalUnitRepository;

    @Override
    public OrganisationUnit findOrganisationalUnitById(Integer id) {
        return organisationalUnitRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(
                "Organisational unit with given ID does not exist."));
    }
}
