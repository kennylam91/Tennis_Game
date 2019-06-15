public class TennisGame {

    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_0_POINT = "Love-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_1_POINT = "Fifteen-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_2_POINT = "Thirty-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_ATLEAST_3_POINT = "Deuce";
    public static final String POINT_0_NAME = "Love";
    public static final String POINT_1_NAME = "Fifteen";
    public static final String POINT_2_NAME = "Thirty";
    public static final String POINT_3_NAME = "Forty";
    public static final int ZERO_POINT = 0;
    public static final int ONE_POINT = 1;
    public static final int TWO_POINT = 2;
    public static final int THREE_POINT = 3;

    public static String getScore(String firstPlayer, String secondPlayer, int firstPlayerPoint, int secondPlayerPoint) {

        String finalScore = "";

        if (isTwoPlayersHasSamePoint(firstPlayerPoint, secondPlayerPoint)) {
            finalScore = getScoreWhenTwoPlayersHasTheSamePoint(firstPlayerPoint);

        } else if (isOneOfTwoPlayersHasAtleast4Points(firstPlayerPoint, secondPlayerPoint)) {
            finalScore = getScoreWhenOneOfTwoPlayersHasAtleast4Points(firstPlayerPoint, secondPlayerPoint);

        } else {
            int[] playerPointArray = {firstPlayerPoint, secondPlayerPoint};
            for (int point :
                    playerPointArray) {
                if (point == secondPlayerPoint) finalScore += "-";
                switch (point) {
                    case ZERO_POINT:
                        finalScore += POINT_0_NAME;
                        break;
                    case ONE_POINT:
                        finalScore += POINT_1_NAME;
                        break;
                    case TWO_POINT:
                        finalScore += POINT_2_NAME;
                        break;
                    case THREE_POINT:
                        finalScore += POINT_3_NAME;
                        break;
                }
            }
        }
        return finalScore;
    }

    private static String getScoreWhenOneOfTwoPlayersHasAtleast4Points(int firstPlayerPoint, int secondPlayerPoint) {

        String finalScore = "";

        int differencePoint = firstPlayerPoint - secondPlayerPoint;
        if (differencePoint == 1) finalScore = "Advantage player1";
        else if (differencePoint == -1) finalScore = "Advantage player2";
        else if (differencePoint >= 2) finalScore = "Win for player1";
        else if (differencePoint <= -2) finalScore = "Win for player2";
        return finalScore;
    }

    private static boolean isOneOfTwoPlayersHasAtleast4Points(int player1Point, int player2Point) {
        return player1Point >= 4 || player2Point >= 4;
    }

    private static String getScoreWhenTwoPlayersHasTheSamePoint(int samePoint) {

        String finalScore="";

        switch (samePoint) {
            case ZERO_POINT:
                finalScore = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_0_POINT;
                break;
            case ONE_POINT:
                finalScore = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_1_POINT;
                break;
            case TWO_POINT:
                finalScore = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_2_POINT;
                break;
            default:
                finalScore = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_ATLEAST_3_POINT;
        }
        return finalScore;
    }

    private static boolean isTwoPlayersHasSamePoint(int player1Point, int player2Point) {
        return player1Point == player2Point;
    }
}
