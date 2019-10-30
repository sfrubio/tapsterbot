package utils;

public enum Devices {
    SAMSUNG_GALAXY_J5_PRIME("Galaxy J5 Prime", "Android", "8.0", "4200a6b8de101579", true),
    SONY_XPERIA_M2("Sony Xperia M2", "Android", "5.1.1", "BY900ED0Y1", false),
    SONY_XPERIA_Z3_COMPACT("Sony Xperia Z3 Compact", "Android", "6.0", "BY900FQMZL", false),
    IPHONE_6("iPhone 6", "iOS", "12.4", null, true);

    private String deviceName;
    private String platformName;
    private String platformVersion;
    private String udid;
    private Boolean hasFingerprint;

    Devices(String deviceName, String platformName, String platformVersion, String udid, Boolean hasFingerprint) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.udid = udid;
        this.hasFingerprint = hasFingerprint;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getUdid() {
        return udid;
    }

    public Boolean hasFingerprint() {
        return hasFingerprint;
    }
}
