package hosp;

import java.util.Optional;

public enum InjuryType {
    KNEE("knee"),
    ELBOW("elbow"),
    HIP("hip");

    private final String text;

    InjuryType(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Optional<InjuryType> getInjuryType(String text) {
        for (InjuryType t : InjuryType.values()) {
            if (t.getText().equals(text)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return text;
    }
}
