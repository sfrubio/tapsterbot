package utils;

import io.restassured.http.ContentType;
import lombok.SneakyThrows;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class Tapsterbot implements TapsterbotService {

    private static final Object TAPSTER_URL = "http://localhost:8080";
    private static final Integer HIGHER_Z = -138;

    public void tapOnScreen(Integer x, Integer y) {
        Integer lower_z = HIGHER_Z - 15;
        go(x, y, HIGHER_Z);
        go(x, y, lower_z);
        go(x, y, HIGHER_Z);
    }

    @Override
    public void tapOnTopScreen(Integer x, Integer y) {
        Integer lower_z = HIGHER_Z - 14;
        go(x, y, HIGHER_Z);
        go(x, y, lower_z);
        go(x, y, HIGHER_Z);
    }

    @Override
    public void tapOnMiddleScreen(Integer x, Integer y) {
        Integer lower_z = HIGHER_Z - 15;
        go(x, y, HIGHER_Z);
        go(x, y, lower_z);
        go(x, y, HIGHER_Z);
    }

    @Override
    public void tapOnBottomScreen(Integer x, Integer y) {
        Integer lower_z = HIGHER_Z - 18;
        go(x, y, HIGHER_Z);
        go(x, y, lower_z);
        go(x, y, HIGHER_Z);
    }

    public void returnToCenter() {
        go(0, 0, HIGHER_Z);
    }

    @Override
    public void drawCircle(Integer x, Integer y, Integer radius) {
        go(x, y, HIGHER_Z);
        circle(x, y, HIGHER_Z - 11, radius);
        go(x, y, HIGHER_Z);
    }

    @Override
    public void drawArc(Integer x, Integer y) {
        go(x, y, HIGHER_Z);
        arc(x, y, HIGHER_Z - 12, 20, 1100, 600);
        go(x, y, HIGHER_Z);
    }

    @Override
    @SneakyThrows
    public void dragAndDrop(Integer[] startCoords, Integer[] endCoords) {
        Integer lower_z = HIGHER_Z - 14;
        go(startCoords[0], startCoords[1], HIGHER_Z);
        go(startCoords[0], startCoords[1], lower_z);
        go(endCoords[0], endCoords[1], lower_z);
        Thread.sleep(500L);
        go(endCoords[0], endCoords[1], HIGHER_Z);
    }


    private void go(Integer x, Integer y, Integer z) {
        //@formatter:off
        given()
                .contentType(ContentType.JSON)
                .body(buildCoordinates(x, y, z))
        .when()
                .post(TAPSTER_URL + "/go")
        .then()
                .assertThat().statusCode(HTTP_OK);
        //@formatter:on
    }

    private CoordinatesDTO buildCoordinates(Integer x, Integer y, Integer z) {
        return CoordinatesDTO.builder()
                .x(x)
                .y(y)
                .z(z)
                .build();
    }

    private void circle(Integer x, Integer y, Integer z, Integer radius) {
        //@formatter:off
        given()
                .contentType(ContentType.JSON)
                .body(buildCircle(x, y, z, radius))
                .log().all()
        .when()
                .post(TAPSTER_URL + "/circle")
                .prettyPeek()
        .then()
                .assertThat().statusCode(HTTP_OK);
        //@formatter:on
    }

    private CircleDTO buildCircle(Integer x, Integer y, Integer z, Integer radius) {
        return CircleDTO.builder()
                .x(x)
                .y(y)
                .z(z)
                .radius(radius)
                .startAngle(0)
                .anticlockwise(false)
                .delay(15)
                .rotations(2)
                .build();
    }

    private void arc(Integer x, Integer y, Integer z, Integer radius, Integer startAngle, Integer endAngle) {
        //@formatter:off
        given()
                .contentType(ContentType.JSON)
                .body(buildArc(x, y, z, radius, startAngle, endAngle))
                .log().all()
        .when()
                .post(TAPSTER_URL + "/arc")
                .prettyPeek()
        .then()
                .assertThat().statusCode(HTTP_OK);
        //@formatter:on
    }

    private ArcDTO buildArc(Integer x, Integer y, Integer z, Integer radius, Integer startAngle, Integer endAngle) {
        return ArcDTO.builder()
                .x(x)
                .y(y)
                .z(z)
                .radius(radius)
                .startAngle(startAngle)
                .endAngle(endAngle)
                .anticlockwise(false)
                .delay(15)
                .build();
    }
}
