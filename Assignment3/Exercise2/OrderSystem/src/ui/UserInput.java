package ui;

public enum UserInput {
    FINISH(0),
    ADD_PRODUCT(1),
    ADD_SERVICE(2),
    WAITING(3);

    private final int value;

    UserInput(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
