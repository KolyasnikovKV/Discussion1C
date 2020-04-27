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
    private Integer userId;
    private Integer commentCount;
    private Integer collectCount;
    private Integer view;
    private Boolean top;
    private Boolean good;
    private String upIds;
}
