package com.ArcomTech.ApiV1.service;

import com.ArcomTech.ApiV1.exceptions.NotFoundException;
import com.ArcomTech.ApiV1.model.EntityWithId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import com.ArcomTech.ApiV1.mapper.AbstractMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * A base service which can create, update, delete and get entities in a repository. It maps creation DTOs to entities,
 * and entities to DTOs. If there is no entity corresponding to the given id, it throws a {@link NotFoundException}.
 *
 * @param <E> The type of the entity
 * @param <ID> The type of the id of the entity
 * @param <R> The type of the {@link JpaRepository} to use
 * @param <C> The type of the creation DTO
 * @param <D> The type of the DTO (used to read the entity)
 * @param <M> The mapper to use to convert creation DTOs to entities and entities to DTOs
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractEntityService<E extends EntityWithId<ID>, ID, R extends JpaRepository<E, ID>, C, D, M extends AbstractMapper<E, C, D>>
        implements EntityService<ID, C, D> {

    protected R repository;
    protected M mapper;
    /** The name of the element to display in exception messages */
    protected String elementName;

    public List<D> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    public D get(ID id) {
        return mapper.fromEntity(repository.findById(id).orElseThrow(() -> new NotFoundException(elementName, id)));
    }

    public D create(C creationDto) {
        return mapper.fromEntity(repository.save(mapper.fromDto(creationDto)));
    }

    public void update(ID id, C creationDto) {

        repository.findById(id)
                .map(old -> {
                    E entity = mapper.fromDto(creationDto);
                    entity.setId(id);
                    return mapper.fromEntity(repository.save(entity));
                }).orElseThrow(() -> new NotFoundException("Region", id));
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}
