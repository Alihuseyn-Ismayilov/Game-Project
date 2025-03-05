---

# **Game Project**

## **Overview**
This is a **Java-based 2D game** featuring different types of enemies, collectible coins, a health system, and a progressive difficulty increase. The game is designed to challenge players by introducing enemies with unique behaviors while allowing them to collect coins and health to survive.

## **Game Features**
### **Different Types of Enemies**
- **SimpleEnemy:** Moves in a straight direction and bounces off walls.
- **UnpredictableEnemy:** Changes speed dynamically, making movement unpredictable.
- **SmartEnemy:** Actively follows the player, making avoidance difficult.



### **Coins & Coin System**
- Coins spawn at intervals and must be collected to win.
- The **CoinBar** keeps track of the total collected coins.



### **Health System**
- The player has a health bar that decreases upon enemy collision.
- **Health items** spawn randomly and can be collected to restore health.


### **Game Win & Lose Conditions**
- **Win:** Collect **1,500 coins**.
- **Lose:** If health reaches **zero**, the game ends with a "Game Over" screen.

### **Increasing Difficulty Over Time**
- More enemies spawn as time progresses.
- The **UnpredictableEnemy** speeds up after hitting walls multiple times.

---

## **Installation & Setup**
### **Prerequisites**
Ensure you have the following installed:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Version 8 or later)
- [Git](https://git-scm.com/downloads) (Optional, for cloning the repository)

### **Downloading the Game**
You can download the game by either:

#### **1. Cloning via Git**
```bash
git clone https://github.com/Alihuseyn-Ismayilov/Game-Project.git
```

#### **2. Downloading Manually**
- Go to [Game Project Repository](https://github.com/Alihuseyn-Ismayilov/Game-Project).
- Click on **Code > Download ZIP** and extract the files.

### **Running the Game**
#### **Option 1: Running via Source Code**
1. **Navigate to the Project Directory:**
   ```bash
   cd Game-Project
   ```
2. **Compile the Game:**
   ```bash
   javac -d bin src/*.java
   ```
   *(Ensure that the source files are correctly placed inside the `src/` folder.)*
3. **Run the Game:**
   ```bash
   java -cp bin Main
   ```
   *(Replace `Main` with the actual main class if it has a different name.)*

#### **Option 2: Running via JAR File**
Alternatively, if a **JAR file** is available, you can directly run it without compiling:
```bash
java -jar GameProject.jar
```

---

## **Gameplay Instructions**
- **Move the Player** using the **arrow keys**.
- **Avoid Enemies** to prevent health loss.
- **Collect Coins** to increase your score.
- **Pick Up Health Items** to restore health.
- **Survive and collect 1,500 coins** to win the game.
- If health reaches **zero**, the game ends.

---

## **Enemies & Their Behavior**
| Enemy Type         | Behavior |
|-------------------|---------------------------------------------------------------|
| **SimpleEnemy**   | Moves in a straight line, bouncing off walls. |
| **UnpredictableEnemy** | Changes speed every 3 wall collisions, doubling speed before resetting. |
| **SmartEnemy**    | Follows the player, making it the most dangerous enemy. |

## **Collectibles**
| Item       | Function |
|------------|-----------------------------------------------------------|
| **Coins**  | Increases score. Needed to win the game. |
| **Health** | Restores player health. |

---

## **Game Over Conditions**
- **Win:** If the player collects **1,500 coins**, the game displays a **"YOU ARE WINNER"** message.
- **Lose:** If the player's **health reaches 0**, the game ends with a **"GAME OVER"** message.

---

## **Contributing**
If you wish to contribute, feel free to:
- Report bugs or suggest improvements via [GitHub Issues](https://github.com/Alihuseyn-Ismayilov/Game-Project/issues).
- Fork the repository and submit a **Pull Request**.

---
