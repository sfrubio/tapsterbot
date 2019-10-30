## Go to any point:
```text
curl -X POST \
  http://<robotURL>/go \
  -H 'Content-Type: application/json' \
  -d '{"x": -20, "y": -40, "z": -130}'
```
Where:
* x: Center of circle, millimeters (Number, float)
* y: Center of circle, millimeters (Number, float)
* z: Center of circle, millimeters (Number, float)

## Draw a Circle:
```text
curl -X POST \
  http://<robotURL>/circle \
  -H 'Content-Type: application/json' \
  -d '{ "x": 0, "y": 0, "z": -158, "radius": 20, "startAngle": 0, "anticlockwise": true, "delay": 5, "rotations": 5 }'
```
Where:
* x: Center of circle, millimeters (Number, float)
* y: Center of circle, millimeters (Number, float)
* z: Center of circle, millimeters (Number, float)
* radius: Radius of circle, millimeters (Number, float)
* startAngle: Starting angle, radians (Number, float)
* anticlockwise: Set to true to go anticlockwise, false to go clockwise (Boolean)
* delay: Number of milliseconds of delay to add between each point (Number, integer)
* rotations: Number of rotations (Number, integer)

> Note: This will draw complete circles. The end angle will be the same as the start angle.

## Draw an Arc:
```text
curl -X POST \
  http://<robotURL>/arc \
  -H 'Content-Type: application/json' \
  -d '{ "x": 0, "y": 0, "z": -158, "radius": 20, "startAngle": 1.57, "endAngle": 3.14, "anticlockwise": false, "delay": 5 }'
```
Where:
* x: Center of circle, millimeters (Number, float)
* y: Center of circle, millimeters (Number, float)
* z: Center of circle, millimeters (Number, float)
* radius: Radius of circle, millimeters (Number, float)
* startAngle: Starting angle, radians (Number, float)
* endAngle: Ending angle, radians (Number, float)
* anticlockwise: Set to true to go anticlockwise, false to go clockwise (Boolean)
* delay: Number of milliseconds of delay to add between each point (Number, integer)

> Note: This will draw one arc. If startAngle and endAngle are the same, it will draw one complete circle. If you want to draw more than one complete circle, use the "/circle" command.