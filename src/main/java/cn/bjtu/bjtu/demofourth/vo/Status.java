package cn.bjtu.bjtu.demofourth.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data
@NoArgsConstructor
public class Status extends ResourceSupport {

    private String msg;

    @JsonCreator
    public Status(@JsonProperty String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
