package models;

import com.google.gson.annotations.Expose;
import lombok.*;

@Builder
@Data
public class Milestone {

    private int id;
    private int size;
    @Expose
    private String name;

    @Expose
    private int projectID;

    @Expose
    private String description;


}
