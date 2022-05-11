package com.integratec.model.domain.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("request_id")
    private Long requestId;

    @NotNull
    @Range(min = 1, max = 999)
    @JsonProperty("receiver_id")
    private Long receiver;

    @NotNull
    @Range(min = 1, max = 999)
    @JsonProperty("sender_id")
    private Long sender;

    @NotEmpty
    @Size(min = 3, max = 70)
    @JsonProperty("title")
    private String title;

    @Size(max = 1000)
    @JsonProperty("text")
    private String text;

    @Size(max = 500)
    @JsonProperty("comment")
    private String comment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("send_date")
    private Date sendDate;

    @JsonProperty("request_category_id")
    private Long requestCategory;

    @JsonProperty("request_priority_id")
    private Long requestPriority;

    @JsonProperty("request_status_id")
    private Long requestStatus;


}
