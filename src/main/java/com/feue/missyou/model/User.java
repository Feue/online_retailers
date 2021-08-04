package com.feue.missyou.model;

import com.feue.missyou.util.MapAndJson;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Feue
 * @create 2021-08-04 13:16
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "delete_time is null")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String openid;
    private String nickname;
    private Long unifyUid;
    private String email;
    private String password;
    private String mobile;

    @Convert(converter = MapAndJson.class)
    private Map<String, Object> wxProfile;
}
