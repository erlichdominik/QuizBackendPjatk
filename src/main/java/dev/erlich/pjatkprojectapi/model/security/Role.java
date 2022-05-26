package dev.erlich.pjatkprojectapi.model.security;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @NotNull
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", privileges=" + privileges +
                '}';
    }

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "roleId"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilegeId"))
    @ToString.Exclude
    private Collection<Privilege> privileges;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return roleId != null && Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
