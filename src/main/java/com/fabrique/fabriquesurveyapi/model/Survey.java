package com.fabrique.fabriquesurveyapi.model;

import com.fabrique.fabriquesurveyapi.model.exception.IllegalOperationException;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant created;
    @UpdateTimestamp
    private Instant updated;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Column(columnDefinition="TEXT")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

    public void setStartDate(LocalDateTime startDate) {
        if (this.startDate == null) {
            this.startDate = startDate;
        } else {
            throw new IllegalOperationException("You cannot change start date after is was set.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Survey survey = (Survey) o;
        return id != null && Objects.equals(id, survey.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
