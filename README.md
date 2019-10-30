# Tapster - Mobile Automation Robot

<span>
    ![Tapsterbot](http://hugs.github.io/img/tapster-2-desk.jpg)
</span>

## Tapsterbot software
### Dependencies
- Node.js
- One Tapster robot

### Getting Started
1. Download and install the Arduino Client: [http://arduino.cc/en/Guide/HomePage](http://arduino.cc/en/Guide/HomePage)
2. Follow the setup procedure, and use the "blink" test script to verify your Arduino is working.
3. From the Arduino IDE upload the "Firmata" script: File -> Open -> Examples > Firmata > StandardFirmata.
4. Install the dependencies: `cd software/node; npm install`.
5. Start'er up: `node src/bot.js`.
6. Start moving: `go(0,0,-140)`.

### Examples on execution
Once started, the Node.js server exposes 3 endpoints (go, circle and arc), that allows to operate Tapsterbot through HTTP requests.

See [documentation](https://github.com/sfrubio/tapsterbot/blob/master/software/node/doc/json-api.md) for further details.

## Test project
Test project designed using Java, Maven and JUnit to structure test architecture.
To operate Tapsterbot, it was abstracted some methods where some basic commands, such as `tapOnScreen`, `drawCircle`, `drawArc` and `dragAndDrop`.

### Dependencies
- Java 8
- Maven
- Appium Desktop
- Android device with app [Whiteboard](https://play.google.com/store/apps/details?id=com.vistrav.whiteboard&hl=en_US) installed

### Getting started
1. Prepare Tapsterbot by attaching Android device on it.
2. With the Android device connected to computer, start Appium Server on port 4723.
3. Go to folder `cd software/java`
4. Run Maven tests. Example:
```
$ mvn clean test -Dtest=WhiteboardTest
```
