package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 16:56
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserAccountVO implements Serializable {
    private String account;
    private String password;
    private String picture;
    private String name;
    private String sex;
    private String phone;
    private String wxOpenid;
    private String email;
}
