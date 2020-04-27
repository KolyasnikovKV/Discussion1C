package ru.kolyasnikovkv.discussion1c.dto;
import lombok.*;

import java.io.Serializable;

@Getter // сгенерировать get'еры для всех полей
@Setter // сгенерировать set'еры для всех полей
@NoArgsConstructor // сгенерировать конструктор без параметров
@AllArgsConstructor // сгенерировать конструктор со всеми параметрами
@EqualsAndHashCode
//@RequiredArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String name;
}
