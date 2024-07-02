package hosp;

public class CommonRabbitMqNames {
    final static public String EXAMINATION_REQUESTS_EXCHANGE_NAME = "examination_requests";
    final static public String EXAMINATION_RESULTS_EXCHANGE_NAME = "examination_results";

    final static private String EXAMINATION_REQUESTS_QUEUES_PREFIX = "examination_requests.";

    final static public String LOGS_EXCHANGE_NAME = "logs";
    final static public String INFOS_EXCHANGE_NAME = "infos";

    public static String getExaminationRequestsQueueName(InjuryType injuryType) {
        return EXAMINATION_REQUESTS_QUEUES_PREFIX + injuryType.getText();
    }
}
