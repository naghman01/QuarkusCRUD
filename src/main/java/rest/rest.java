package rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import repo.repository;
import entity.Person;


@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class rest {
    @Inject
    repository Personrepo;
    Person p1=new Person();

    @GET
    public List<Person> list() {
        return Person.listAll();
    }

    @GET
    @Path("/{id}")
    public Person get(Long id){
    
        return Person.findById(id);
    }

    @POST
    @Transactional
    public Response create(Person person) {
        Personrepo.persist(person);
        return Response.created(URI.create("/persons/" + person.id)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Person update(Long id, Person person) {
        Person entity = Person.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the person parameter to the existing entity
        entity.name = person.name;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Person entity = Person.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @GET
    @Path("/search/{name}")
    public Person search(String name) {
        return Personrepo.findByName(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return Personrepo.count();
    }
}