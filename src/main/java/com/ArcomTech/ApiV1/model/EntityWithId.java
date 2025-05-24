package com.ArcomTech.ApiV1.model;

import java.io.Serializable;

public interface EntityWithId<ID> extends Serializable {
    void setId(ID id);
    ID getId();
}
