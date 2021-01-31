package mono.back.monoback.form;

import lombok.Data;

/**
 * ユーザー情報取得Form
 * 
 * @author Hiroshi Watanabe
 * @version 1.0
 */
@Data
public class UserForm {

    /** ユーザーID */
    private String id;

    /** 検索ボックスに入力されたユーザ名 */
    private String nameLike;
}
