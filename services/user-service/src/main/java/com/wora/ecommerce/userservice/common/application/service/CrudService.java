package com.wora.ecommerce.userservice.common.application.service;

import java.util.List;

public interface CrudService<I, R, S> {
    List<S> findAll();

    S findById(I id);

    S create(R dto);

    S update(I id, R dto);

    void delete(I id);
}
