package rs.teslaris.core.model.person;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contact {

    @Column(name = "contact_email", nullable = false)
    String contactEmail;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;
}