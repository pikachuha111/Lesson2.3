package models;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Item {
    private String itemName;
    private String locatorValue;
    @EqualsAndHashCode.Exclude
    private boolean deleted;
}
