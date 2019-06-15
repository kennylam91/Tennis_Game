public class TennisGame {

    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_0_POINT = "Love-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_1_POINT = "Fifteen-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_2_POINT = "Thirty-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_3_POINT = "Forty-All";
    public static final String SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_ATLEAST_3_POINT1 = SCORE_WHEN_TWO_PLAYERS_HAS_THE_SAME_3_POINT;

    public static String getScore(String player1, String player2, int player1Point, int player2Point) {
        String score = "";
        int tempPoint = 0;
        if (isTwoPlayersHasSamePoint(player1Point, player2Point)) {
            int point = player1Point;
            score = getScoreWhenTwoPlayersHasTheSamePoint(point);

        } else if (isOneOfTwoPlayersHasAtleast4Points(player1Point, player2Point)) {
            int differencePoint = player1Point - player2Point;
            if (differencePoint == 1) score = "Advantage player1";
            else if (differencePoint == -1) score = "Advantage player2";
            else if (differencePoint >= 2) score = "Win for player1";
            else if (differencePoint <= -2) score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempPoint = player1Point;
                else {
                    score += "-";
                    tempPoint = player2Point;
                }
                switch (tempPoint) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
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
