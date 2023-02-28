package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Data
public class Milestone {

    private int id;
    private int size;
    @Expose
    private String name;

    @Expose
    @SerializedName("project_id")
    private int projectID;

    @Expose
    private String description;


}
