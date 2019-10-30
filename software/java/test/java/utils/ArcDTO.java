package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArcDTO {

    private Integer x;
    private Integer y;
    private Integer z;
    private Integer radius;
    private Integer startAngle;
    private Integer endAngle;
    private Boolean anticlockwise;
    private Integer delay;
}
