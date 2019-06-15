public class TennisGame {

    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_0_POINT = "Love-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_1_POINT = "Fifteen-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_2_POINT = "Thirty-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_3_POINT = "Forty-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_ATLEAST_3_POINT1 = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_3_POINT;

    public static String getScore(String firstPlayer, String secondPlayer, int firstPlayerPoint, int secondPlayerPoint) {
        String finalScore = "";
        if (isTwoPlayersHasSamePoint(firstPlayerPoint, secondPlayerPoint)) {
            int point = firstPlayerPoint;
            finalScore = getScoreWhenTwoPlayersHasTheSamePoint(point);

        } else if (isOneOfTwoPlayersHasAtleast4Points(firstPlayerPoint, secondPlayerPoint)) {
            int differencePoint = firstPlayerPoint - secondPlayerPoint;
            if (differencePoint == 1) finalScore = "Advantage player1";
            else if (differencePoint == -1) finalScore = "Advantage player2";
            else if (differencePoint >= 2) finalScore = "Win for player1";
            else if (differencePoint <= -2) finalScore = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                int tempPoint;
                if (i == 1) tempPoint = firstPlayerPoint;
                else {
                    finalScore += "-";
                    tempPoint = secondPlayerPoint;
                }
                switch (tempPoint) {
                    case 0:
                        finalScore += "Love";
                        break;
                    case 1:
                        finalScore += "Fifteen";
                        break;
                    case 2:
                        finalScore += "Thirty";
                        break;
                    case 3:
                        finalScore += "Forty";
                        break;
                }
            }
        }
        return finalScore;
    }

    private static boolean isOneOfTwoPlayersHasAtleast4Points(int player1Point, int player2Point) {
        return player1Point >= 4 || player2Point >= 4;
    }

    private static String getScoreWhenTwoPlayersHasTheSamePoint(int sameplayerPoint) {
        String score;
        switch (sameplayerPoint) {
            case 0:
                score = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_0_POINT;
                break;
            case 1:
                score = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_1_POINT;
                break;
            case 2:
                score = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_2_POINT;
                break;
            default:
                score = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_ATLEAST_3_POINT1;


        }
        return score;
    }

    private static boolean isTwoPlayersHasSamePoint(int player1Point, int player2Point) {
        return player1Point == player2Point;
    }
}
