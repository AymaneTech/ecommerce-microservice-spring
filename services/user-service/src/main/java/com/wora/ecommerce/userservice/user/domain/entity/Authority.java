package com.wora.ecommerce.userservice.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authorities")
    private List<Role> roles;

    public Authority(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
