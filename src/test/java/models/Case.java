package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;


@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Case {

    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    private String title;

    @Expose
    @SerializedName("section_id")
    private int sectionID;
}
