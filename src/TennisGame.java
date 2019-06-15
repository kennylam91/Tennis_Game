public class TennisGame {

    public static String getScore(String player1, String player2, int player1Point, int player2Point) {
        String score = "";
        int tempScore = 0;
        if (player1Point == player2Point) {
            switch (player1Point) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1Point >= 4 || player2Point >= 4) {
            int differencePoint = player1Point - player2Point;
            if (differencePoint == 1) score = "Advantage player1";
            else if (differencePoint == -1) score = "Advantage player2";
            else if (differencePoint == 2) score = "Win for player1";
            else if (differencePoint == -2) score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Point;
                else {
                    score += "-";
                    tempScore = player2Point;
                }
                switch (tempScore) {
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
}
