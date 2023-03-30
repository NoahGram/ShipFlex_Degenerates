class Motor {
    private String type;
    private String instrument;

    public Motor(String type, String instrument) {
        this.type = type;
        this.instrument = instrument;
    }

    public String getType() {
        return type;
    }

    public String getInstrument() {
        return instrument;
    }
}