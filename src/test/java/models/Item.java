package models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Item {
    private String itemName;
    private String locatorValue;
    @EqualsAndHashCode.Exclude
    private boolean deleted;
}
