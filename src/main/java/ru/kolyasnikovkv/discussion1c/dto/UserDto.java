package ru.kolyasnikovkv.discussion1c.dto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@RequiredArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String name;
}
