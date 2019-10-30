package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CircleDTO {

    private Integer x;
    private Integer y;
    private Integer z;
    private Integer radius;
    private Integer startAngle;
    private Boolean anticlockwise;
    private Integer delay;
    private Integer rotations;

}
