import java.util.*;
import java.io.*;

class Game {
    String playerName;
    int randomNumber;
    int attempts;
    String status;
    final int maxAttempts = 5;
    Scanner sc1;

    Game(String playerName, Scanner sc1) {
        this.playerName = playerName;
        this.randomNumber = (int)(Math.random() * 100);
        this.attempts = 0;
        this.status = "Quit";
        this.sc1 = sc1;
    }

    public void start() {
        int guess;

        while (attempts < maxAttempts) {
            System.out.print("🔢 Guess Any Number (0 To 99): ");
            guess = sc1.nextInt();

            attempts++;

            System.out.println("⏳ Remaining Attempts: " + (maxAttempts - attempts));

            if (guess == randomNumber) {
                System.out.println("🎉 Congratulations! Correct Number.");
                status = "Won";
                break;
            } else if (Math.abs(guess - randomNumber) <= 10) {
                if (guess < randomNumber) {
                    System.out.println("🤏 Close! But A Bit Low. Try A Higher Number.\n");
                } else {
                    System.out.println("🤏 Close! But A Bit High. Try A Lower Number.\n");
                }
            } else if (guess < randomNumber) {
                System.out.println("📉 Too Low! Try Again.\n");
            } else {
                System.out.println("📈 Too High! Try Again.\n");
            }
        }

        if (status.equals("Quit")) {
            status = "Lost";
        }

        showResult();
    }

    public void showResult() {
        if (status.equals("Won")) {
            System.out.println("\n🎯 You Won! Correct Number Was Guessed.");
        } else {
            System.out.println("\n🎯 The Correct Number Was: " + randomNumber);
        }

        System.out.println("👤 Name: " + playerName);
        System.out.println("📊 Status: " + status);
        System.out.println("🔁 Attempts: " + attempts);

        saveToScoreboard();
    }

    public void saveToScoreboard() {
        try {
            FileWriter writer = new FileWriter("scoreboard.txt", true);
            writer.write("Name: " + playerName + " | Status: " + status + " | Attempts: " + attempts + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("⚠️ Error Writing To Scoreboard: " + e.getMessage());
        }

        System.out.println("\n✅ Score Saved To Scoreboard.txt");
    }

    public static void showScoreboard() {
        try {
            File file = new File("scoreboard.txt");
            if (!file.exists()) {
                System.out.println("\n📜 No Previous Scoreboard Found.");
                return;
            }

            Scanner fileReader = new Scanner(file);
            System.out.println("\n📋 Full Scoreboard:");
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            fileReader.close();

        } catch (IOException e) {
            System.out.println("⚠️ Error Reading Scoreboard: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n🎮 Welcome To Mystery Hunt - The Number Guessing Game!");

        do {
            System.out.print("\n📝 Enter Your Name: ");
            String playerName = sc.nextLine();

            Game game = new Game(playerName, sc);
            game.start();

            Game.showScoreboard();

            System.out.print("\n🔁 Do You Want To Play Again? (Yes/No): ");
            sc.nextLine(); // consume leftover newline
            String playAgain = sc.nextLine();

            if (playAgain.equalsIgnoreCase("NO")) {
                System.out.println("👋 Thanks For Playing! See You Next Time!");
                break;
            }

        } while (true);

        sc.close();
    }
}
