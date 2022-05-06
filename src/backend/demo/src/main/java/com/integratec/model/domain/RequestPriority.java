package com.integratec.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "requestpriority")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestPriorityId;

    @Column(name = "request_priority")
    private String requestPriority;

}
