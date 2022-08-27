package repo;

import javax.enterprise.context.ApplicationScoped;

import entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class repository implements PanacheRepository<Person>{

    public Person findByName(String name) {
        return null;
    }

    @Override
    public void persist(Person entity) {
        // TODO Auto-generated method stub
        PanacheRepository.super.persist(entity);
    }


}