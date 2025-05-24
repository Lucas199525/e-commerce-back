package com.ArcomTech.ApiV1.service;
import java.util.List;

/**
 *
 * @param <ID> The type of the ID (of the entity)
 * @param <C> The type of the creation DTO
 * @param <D> The type of the DTO (used to read the entity)
 */
public interface EntityService<ID, C, D> {
    public List<D> getAll();
    public D get(ID id);
    public D create(C creationDto);
    public void update(ID id, C creationDto);
    public void delete(ID id);
}
