package cn.bjtu.bjtu.demofourth.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainerVO {
    private String name;
    private String phone;

    @JsonCreator
    public TrainerVO(@JsonProperty String name, @JsonProperty String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }
    public String getPhone() { return this.phone;}
}
