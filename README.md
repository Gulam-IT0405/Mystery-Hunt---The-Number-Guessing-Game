
# 🎮 Mystery Hunt - The Number Guessing Game!

A fun and interactive Java console-based game where you guess a randomly generated number between 0 and 99. Smart hints, score tracking, and replay option included!

---

## 📌 Features

- 👤 Enter your name and start playing
- 🔢 Guess a number between 0 to 99
- 💡 Smart hints: “Close”, “Too Low”, or “Too High”
- ⏳ Only 5 attempts to guess correctly
- 🧾 Score saved in `scoreboard.txt`
- 📋 Displays full scoreboard after each round
- 🔁 Option to play again

---

## 🚀 How To Run

### Prerequisites:
- Java must be installed on your system

### Steps:
```bash
javac Main.java
java Main
```

---

## 🧠 Game Logic

- Generates a random number from 0 to 99
- User enters guesses (max 5 attempts)
- Shows helpful hints after each guess
- Score is saved as:
  ```
  Name: [Player Name] | Status: [Won/Lost] | Attempts: [Number]
  ```
- Scoreboard shown after every game

---

## 📂 Files

| File Name        | Description                            |
|------------------|----------------------------------------|
| `Main.java`      | Game launcher                          |
| `scoreboard.txt` | Stores player name, status, attempts   |

---

## 🎥 Demo (Sample Output)

```
🎮 Welcome To Mystery Hunt - The Number Guessing Game!

📝 Enter Your Name: Ashrafi
🔢 Guess Any Number (0 To 99): 45
⏳ Remaining Attempts: 4
📈 Too High! Try Again.

...
🎯 The Correct Number Was: 38
👤 Name: Ashrafi
📊 Status: Lost
🔁 Attempts: 5
✅ Score Saved To Scoreboard.txt

📋 Full Scoreboard:
Name: Ashrafi | Status: Lost | Attempts: 5
```

---

## 🤝 Contribution

Feel free to fork this project and make it better. Pull Requests are welcome!

---

## 📄 License

This project is free and open source. Made By Gulam Mohyudin Memon
