package mono.back.monoback.dto;

import lombok.Data;

/**
 * ユーザー情報DTO
 * 
 * @author Hiroshi Watanabe
 * @version 1.0
 */
@Data
public class UserDto {

    /** ユーザーID */
    private String id;

    /** ユーザー名 */
    private String name;
}
