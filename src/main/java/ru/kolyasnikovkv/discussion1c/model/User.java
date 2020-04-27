package ru.kolyasnikovkv.discussion1c.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = -5051120337175047163L;

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String telegramName;
    private String avatar;
    @JsonIgnore
    private String password;
    private String email;
    private String mobile;
    private String website;
    private String bio;
    private Integer score;
    private Date inTime;
    @JsonIgnore
    private String token;
    private Boolean emailNotification;
    private Boolean active;

    // private Boolean telegramNotification;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", telegramName='" + telegramName + '\'' + ", "
                + "avatar='" + avatar + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", mobile='" +
                mobile + '\'' + ", website='" + website + '\'' + ", bio='" + bio + '\'' + ", score=" + score + ", inTime=" +
                inTime + ", token='" + token + '\'' + ", emailNotification=" + emailNotification + ", active=" + active + '}';
    }
}
