package dev.erlich.pjatkprojectapi.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<QuestionAnswer> questionAnswers = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
