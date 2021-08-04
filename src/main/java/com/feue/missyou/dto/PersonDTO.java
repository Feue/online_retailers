package com.feue.missyou.dto;

import com.feue.missyou.dto.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

/**
 * @author Feue
 * @create 2021-07-18 21:33
 */
@Getter
//@Setter
//@EqualsAndHashCode
//@Data // equals hashcode toString
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
@PasswordEqual(min = 4)
public class PersonDTO {
//    @NonNull
    @Length(min = 2, max = 10)
    private String name;

    private Integer age;

    @Valid
    private SchoolDTO schoolDTO;

    private String password1;

    private String password2;
}
// DTO 数据传输对象
