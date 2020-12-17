public class Game {
    String player1;
    String player2;
    int[] gamePoints;
    String servePlayer;
    Game(String player1, String player2, int serve) {
        this.player1 = player1;
        this.player2 = player2;
        gamePoints = new int[2];
        if (serve == 1) {
            servePlayer = player1;
        } else if (serve == 2) {
            servePlayer = player2;
        }
    }

    public boolean hasWinner() {
        if (gamePoints[0] >= 10 && gamePoints[1] >= 10) {
            if (gamePoints[0] - gamePoints[1] >= 2 || gamePoints[1] - gamePoints[0] >= 2) {
                return true;
            }
        } else if (gamePoints[0] > 10 || gamePoints[1] > 10) {
            return true;
        }

        return false;
    }

    public String getWinner() {
        return gamePoints[0] > gamePoints[1] ? player1 : player2;
    }

    public void updateServe() {
        int sum = gamePoints[0] + gamePoints[1];
        if (sum == 0) {
            return;
        }
        // Serving switches evey 2 points
        if (sum % 2 == 0) {
            // Change servePlayer to another one
            servePlayer = servePlayer.equals(player1) ? player2 : player1;
        }

        return;
    }
}
