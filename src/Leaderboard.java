import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class Leaderboard {
    Map<String, Integer> playerScores;

    Leaderboard() {
        playerScores = new HashMap<>();
    }

    public void update(String winner) {
        playerScores.put(winner, playerScores.getOrDefault(winner, 0) + 1);
    }

    public void printLeaderBoard() {
        playerScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public boolean readFromFile() {
        try {
            File toRead = new File("leaderboard");
            FileInputStream fis = new FileInputStream(toRead);
            ObjectInputStream ois = new ObjectInputStream(fis);
            playerScores = (HashMap<String, Integer>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("Seems like this is your first time to use Ping Pong Poing Manager, let's create leaderboard for you");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void writeToFile() {
        try {
            File file = new File("leaderboard");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerScores);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
