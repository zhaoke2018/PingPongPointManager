import java.util.Scanner;

public class PingPong {
    public static void main(String[] args) {
        // Get players' name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Ping Pong Point Manager, please enter players' name.");
        System.out.println("Player1: ");
        String player1Name = scanner.next();
        System.out.println("Player2: ");
        String player2Name = scanner.next();

        // Create two players
//        Player player1 = new Player(player1Name);
//        Player player2 = new Player(player2Name);

        // Let's start the game
        System.out.println("Who serves first? Please enter 1 or 2.");
        int servePlayer = scanner.nextInt();
        Game game = new Game(player1Name, player2Name, servePlayer);
        while (!game.hasWinner()) {
            System.out.println("Current game points: ");
            System.out.println(player1Name + ": " + game.gamePoints[0]);
            System.out.println(player2Name + ": " + game.gamePoints[1]);
            game.updateServe();
            System.out.println(game.servePlayer + " is serving now.");
            System.out.println("Who wins this round? Please enter 1 or 2. If you want to quit, just enter quit.");
            String thisRoundResult = scanner.next();
            if (thisRoundResult.equals("1")) {
                game.gamePoints[0]++;
            } else if (thisRoundResult.equals("2")) {
                game.gamePoints[1]++;
            } else if (thisRoundResult.equals("quit")) {
                System.exit(0);
            }
        }
        System.out.println("We have a winner " + game.getWinner() + "!");
        Leaderboard leaderboard = new Leaderboard();
        if (!leaderboard.readFromFile()) {
            leaderboard.writeToFile();
        }
        leaderboard.update(game.getWinner());
        System.out.println("Below is the leaderboard");
        System.out.println("------------------------");
        leaderboard.printLeaderBoard();
        System.out.println("------------------------");
        leaderboard.writeToFile();
    }
}
