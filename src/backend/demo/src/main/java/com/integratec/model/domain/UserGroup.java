package com.integratec.model.domain;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_group_name")
    private String name;

    /*@ManyToMany(mappedBy = "user_group")
    private Set<Account> users;*/
}
