package rs.teslaris.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.teslaris.core.exception.NotFoundException;
import rs.teslaris.core.model.Person;
import rs.teslaris.core.repository.PersonRepository;
import rs.teslaris.core.service.PersonService;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person findPersonById(Integer id) {
        return personRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Person with given ID does not exist."));
    }
}
