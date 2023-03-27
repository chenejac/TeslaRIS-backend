package rs.teslaris.core.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_READ')")
    public String returnDummyData() {
        return "TEST";
    }
}