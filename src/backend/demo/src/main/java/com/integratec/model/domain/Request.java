package com.integratec.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request {
    @Id
    @NotNull(message = "some error message")
    @Range(min = 1, max = 999999, message = "some error message")
    @SequenceGenerator(name = "requestSequence", sequenceName = "requestSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSequence")
    private Long requestId;
    @NotNull(message = "some error message")
    @Range(min = 1, max = 999, message = "some error message")
    @Column(name = "Receiver")
    private Long receiver;
    @NotNull(message = "some error message")
    @Range(min = 1, max = 999, message = "some error message")
    @Column(name = "Sender")
    private Long sender;
    @NotEmpty(message = "some error message")
    @Size(min = 3, max = 70, message = "some error message")
    @Column(name = "Title")
    private String title;
    @Size(max = 1000, message = "some error message")
    @Column(name = "Text")
    private String text;
    @Size(max = 500, message = "some error message")
    @Column(name = "Comment")
    private String comment;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "SendDate")
    @Temporal(TemporalType.DATE)
    private Date sendDate;
    @Column(name = "TaskList")
    private Long taskList;
    @Column(name = "RequestStatusStatus")
    private Long requestStatus;
    @Column(name = "RequestCategoryCategory")
    private Long requestCategory;
    @Column(name = "RequestPriority")
    private Long requestPriority;

    public Request(Long requestid, Long receiver, Long sender, String title, String text, String comment) {
        this.requestId = requestid;
        this.receiver = receiver;
        this.sender = sender;
        this.title = title;
        this.text = text;
        this.comment = comment;
    }

}
