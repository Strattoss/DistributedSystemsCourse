package hosp;

import hosp.messages.ExaminationRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class UtilsDialog {
    public static ExaminationRequest readRequestFromUser(BufferedReader in, String doctorId) {
        String patientName = null;
        InjuryType injuryType = null;

        try {
            System.out.print("Patient name: ");
            patientName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (injuryType == null) {
            System.out.print("Injury type " + Arrays.toString(InjuryType.values()) + ": ");
            try {
                String line = in.readLine();
                var optionalInjuryType = InjuryType.getInjuryType(line);
                if (optionalInjuryType.isEmpty()) {
                    System.out.println("Invalid injury type");
                    continue;
                }
                injuryType = optionalInjuryType.get();
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return new ExaminationRequest(patientName, injuryType, doctorId);
    }

    public static void readKnownInjuryTypes(InjuryType[] knownInjuryTypes, BufferedReader in) {
        // read known injury types
        try {
            System.out.println("Which two types of injuries you can examine? " + Arrays.toString(InjuryType.values()));

            Optional<InjuryType> l1 = InjuryType.getInjuryType(in.readLine());
            while (l1.isEmpty()) {
                System.out.println("Incorrect. Try again");
                l1 = InjuryType.getInjuryType(in.readLine());
            }
            knownInjuryTypes[0] = l1.get();

            Optional<InjuryType> l2 = InjuryType.getInjuryType(in.readLine());
            while (l2.isEmpty()) {
                System.out.println("Incorrect. Try again");
                l2 = InjuryType.getInjuryType(in.readLine());
            }
            knownInjuryTypes[1] = l2.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
