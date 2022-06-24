package dev.erlich.pjatkprojectapi.model;

import dev.erlich.pjatkprojectapi.model.security.User;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private Integer numberOfWins;
    private Integer allGames;

    public Double getWinRatio() {
        return numberOfWins.doubleValue() / allGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserHistory that = (UserHistory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


