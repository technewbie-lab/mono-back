package mono.back.monoback.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mono.back.monoback.dto.UserDto;
import mono.back.monoback.form.UserForm;
import mono.back.monoback.response.UserGetResponse;

/**
 * ユーザー情報取得サービス
 * 
 * @author Hiroshi Watanabe
 * @version 1.0
 */
@Service
public class UserGetService {

    /**
     * ユーザー情報取得処理
     * 
     * @param form リクエストフォーム
     * @return UserResponse ユーザー情報のレスポンス
     */
    public UserGetResponse getUser(UserForm form) {
        // ユーザー情報DTOの生成
        List<UserDto> userList = new ArrayList<>();
        // ユーザー情報を詰めたレスポンスの生成
        UserGetResponse response = new UserGetResponse();

        // ユーザー情報のモックデータ
        Map<String, String> userMap = new HashMap<>();
        userMap.put("001", "Tanaka");
        userMap.put("002", "Tamura");
        userMap.put("003", "Nakata");

        // リクエストフォームにユーザー名が指定されていた場合の返却データ生成
        if (StringUtils.isNotEmpty(form.getNameLike())) {
            userMap.entrySet().stream().forEach(e -> {
                // ユーザー名は前方一致で検索
                if (e.getValue().startsWith(form.getNameLike())) {
                    UserDto user = new UserDto();
                    user.setId(e.getKey());
                    user.setName(e.getValue());
                    userList.add(user);
                }
            });
            // リクエストフォームにIDが指定されていた場合の返却データ生成
        } else if (StringUtils.isNotEmpty(form.getId())) {
            userMap.entrySet().stream().forEach(e -> {
                if (e.getKey().equals(form.getId())) {
                    UserDto user = new UserDto();
                    user.setId(e.getKey());
                    user.setName(e.getValue());
                    userList.add(user);
                }
            });
            // リクエストフォームが空の場合、モックデータを全件返却
        } else {
            userMap.entrySet().stream().forEach(e -> {
                UserDto user = new UserDto();
                user.setId(e.getKey());
                user.setName(e.getValue());
                userList.add(user);
            });
        }

        // レスポンスに値を設定し返却
        response.setCode(HttpStatus.OK.value());
        response.setUsers(userList);
        return response;
    }
}
