package mono.back.monoback.response;

import java.util.List;

import lombok.Data;
import mono.back.monoback.dto.UserDto;

/**
 * ユーザー情報取得レスポンス
 * 
 * @author Hiroshi Watanabe
 * @version 1.0
 */
@Data
public class UserGetResponse {

    /** ステータスコード */
    private int code;

    /** ユーザー情報リスト */
    private List<UserDto> users;
}
