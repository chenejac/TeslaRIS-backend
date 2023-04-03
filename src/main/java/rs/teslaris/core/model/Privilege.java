package rs.teslaris.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "privileges")
public class Privilege extends BaseEntity implements GrantedAuthority {

    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}