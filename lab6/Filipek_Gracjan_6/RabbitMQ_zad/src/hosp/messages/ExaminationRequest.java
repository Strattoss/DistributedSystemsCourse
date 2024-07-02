package hosp.messages;

import hosp.InjuryType;

import java.io.Serializable;
import java.util.Random;

public record ExaminationRequest (
        String patient,
        InjuryType injuryType,
        String doctorId
) implements Serializable {
    public static ExaminationRequest getRandom(String doctorId) {
        return new ExaminationRequest(
                "p" + new Random().nextInt(100),
                InjuryType.values()[new Random().nextInt(InjuryType.values().length)],
                doctorId);
    }
}
