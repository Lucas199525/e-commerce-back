package com.ArcomTech.ApiV1.mapper;

import com.ArcomTech.ApiV1.service.AbstractEntityService;

/**
 * Class to extend to create a mapper compatible with {@link AbstractEntityService}
 *
 * @param <E> The type of the entity to map
 * @param <C> The type of the Creation DTO (used for writing the entity)
 * @param <D> The type of the DTO (used for reading the entity)
 */
public interface AbstractMapper<E, C, D>  {
    D fromEntity(E entity);

    E fromDto(C creationDto);
}
