package com.integratec.model.domain;

import lombok.*;

import java.util.Date;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request {
    @Id
    @NotNull
    @Range(min = 1, max = 999999)
    @SequenceGenerator(name = "requestSequence", sequenceName = "requestSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSequence")
    private Long requestId;
    @NotNull
    @Range(min = 1, max = 999)
    @Column(name = "Receiver")
    private Long receiver;
    @NotNull
    @Range(min = 1, max = 999)
    @Column(name = "Sender")
    private Long sender;
    @NotEmpty
    @Size(min = 3, max = 70)
    @Column(name = "Title")
    private String title;
    @Size(max = 1000)
    @Column(name = "Text")
    private String text;
    @Size(max = 500)
    @Column(name = "Comment")
    private String comment;
    @DateTimeFormat(pattern="dd/MM/yyyy")
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
