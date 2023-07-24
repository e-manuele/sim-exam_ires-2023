package it.ires.exam.dataobject;

public enum SimStatus {
    OCCUPATO(false),
    LIBERO(true);

    private final boolean value;

    SimStatus(boolean value) {
        this.value =value;
    }

    public boolean isValue() {
        return value;
    }
}
