package hosp;

import hosp.user_actors.Admin;
import hosp.user_actors.Doctor;
import hosp.user_actors.Technician;
import hosp.user_actors.UserActor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("### ORTHOPEDIC UNIT ###");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        UserActor userActor = getUserType(br);

        System.out.println("Passing control to adequate UserType object\n");
        userActor.serveTheUser(br);
    }

    private static UserActor getUserType(BufferedReader br) {
        String userTypeAsString;
        int userId;
        UserActor userActor = null;

        while (userActor == null) {
            try {
                System.out.print("Logging as [doctor|d, technician|t, admin|a]: ");
                userTypeAsString = br.readLine();

                System.out.print("Your id: ");
                userId = Integer.parseInt(br.readLine());
            } catch (IOException | NumberFormatException e ) {
                System.out.println("Something went wrong:" + e.getMessage());
                System.out.println("Try again");
                continue;
            }

            switch (userTypeAsString) {
                case "d", "do", "doc", "doct", "doctor":
                    userActor = new Doctor(userId);
                    break;

                case "t", "te", "tech", "techn", "technician":
                    userActor = new Technician(userId);
                    break;

                case "a", "ad", "adm", "admin":
                    userActor = new Admin(userId);
                    break;
                default:
                    System.out.println("Incorrect profession. Try again");
            }
        }
        return userActor;
    }
}