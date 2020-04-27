package ru.kolyasnikovkv.discussion1c.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
@EqualsAndHashCode
public class Comment implements Serializable {
    private static final long serialVersionUID = 8413239906874427490L;

    @Id
    @GeneratedValue
    private Integer id;
    private Integer topicId;
    private Integer userId;
    private String content;
    private Date inTime;
    private Integer commentId;
    private String upIds;

}
