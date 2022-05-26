package dev.erlich.pjatkprojectapi.model.security;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long privilegeId;

    private String name;

    public Privilege(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "privileges")
    @ToString.Exclude
    private Collection<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Privilege privilege = (Privilege) o;
        return privilegeId != null && Objects.equals(privilegeId, privilege.privilegeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
