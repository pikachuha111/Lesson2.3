package models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
public class User {
    @Expose
    private String name;

    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    private String email;

    private String password;

    @Expose
    @SerializedName(value = "is_active")
    private boolean isActive;

    @Expose
    @SerializedName(value = "is_admin")
    private  boolean isAdmin;

    @Expose
    @SerializedName(value = "role_id")
    private int roleId;

    @Expose
    private String role;

    @EqualsAndHashCode.Exclude
    private String email_notification;
}
