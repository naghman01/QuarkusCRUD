package entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Builder;
@Entity
@Builder
@Cacheable
@Setter
@Getter
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;
    public Status status;
    public Person() {
    }
    public Person(String name, LocalDate birth, Status status) {
        this.name = name;
        this.birth = birth;
        this.status = status;
    }
}