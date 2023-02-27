package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Project {

    private int id;

    @SerializedName("suite_mode")
    private int suiteMode;

    private String name;
    private String announcement;

}
