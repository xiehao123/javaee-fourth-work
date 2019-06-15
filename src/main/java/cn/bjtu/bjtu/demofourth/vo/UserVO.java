package cn.bjtu.bjtu.demofourth.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO {

    private String name;

    @JsonCreator
    public UserVO(@JsonProperty String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
