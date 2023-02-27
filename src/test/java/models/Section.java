package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {

    @SerializedName("id")
    private int sectionID;

    private String name;

}
