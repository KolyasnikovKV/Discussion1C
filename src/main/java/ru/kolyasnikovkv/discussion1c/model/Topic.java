package ru.kolyasnikovkv.discussion1c.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "topic")
@Getter
@Setter
@EqualsAndHashCode
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String content;
    private Date inTime;
    private Date modifyTime;
//    @ManyToOne
//    @JoinColumn(name = "user_id",
//            foreignKey = @ForeignKey(name = "topic_ibfk_1"))
//    private User user;
    private Integer userId;
    private Integer commentCount;
    private Integer collectCount;
    private Integer view;
    private Boolean top;
    private Boolean good;
    private String upIds;
}
