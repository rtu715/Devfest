public enum ScriptType {
    CPU_INFO("CPU"), WEATHER("Weather"), CALENDAR("Calendar"), 
    SPEED_TEST("SpeedTest"), DIR_TREE("DirectoryTree");

    private final String type;
    private ScriptType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
};