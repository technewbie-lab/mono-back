package mono.back.monoback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mono.back.monoback.form.UserForm;
import mono.back.monoback.response.UserGetResponse;
import mono.back.monoback.service.UserGetService;

/**
 * ユーザー情報取得コントローラー
 * 
 * @author Hiroshi Watanabe
 * @version 1.0
 */
@RestController
public class UserGetController {

    // ユーザ情報取得サービス
    @Autowired
    UserGetService userGetService;

    /**
     * ユーザー情報取得コントローラー
     * 
     * @param form リクエストフォーム
     * @return UserResponse ユーザー情報のレスポンス
     */
    @GetMapping(value = "/users")
    @ResponseBody
    @CrossOrigin
    public UserGetResponse getUser(@ModelAttribute UserForm form) {

        // ユーザー情報取得レスポンスを生成
        UserGetResponse response = new UserGetResponse();

        try {
            // ユーザー情報取得サービスの実行
            response = userGetService.getUser(form);
            return response;
        } catch (Exception e) {
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return response;
        }
    }
}
