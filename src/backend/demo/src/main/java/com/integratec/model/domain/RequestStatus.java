package com.integratec.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "requeststatus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestStatusId;

    @Column(name = "request_status")
    private String requestStatus;

}
