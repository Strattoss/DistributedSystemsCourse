package hosp.messages;

import hosp.InjuryType;

import java.io.Serializable;

public record ExaminationResult(
        String patient,
        InjuryType injuryType,
        String result
) implements Serializable {

}
