package cn.bjtu.bjtu.demofourth.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class UserList extends ResourceSupport {

    private List<UserVO> userList;

    @JsonCreator
    public UserList(@JsonProperty List<UserVO> userList) {
        this.userList = userList;
    }

    public List<UserVO> getUserList(){
        return this.userList;
    }
}
