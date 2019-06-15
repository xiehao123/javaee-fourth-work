package cn.bjtu.bjtu.demofourth.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class TrainerList extends ResourceSupport {

    private List<TrainerVO> trainerList;

    @JsonCreator
    public TrainerList(@JsonProperty List<TrainerVO> trainerList) {
        this.trainerList = trainerList;
    }

    public List<TrainerVO> getTrainerList(){
        return this.trainerList;
    }
}
