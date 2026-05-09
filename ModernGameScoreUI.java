import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ===================== BACKEND CLASS =====================
class GameScoreBackend {

    private String playerName;
    private int currentScore;
    private int highScore;

    // Constructor
    public GameScoreBackend(String playerName) {
        this.playerName = playerName;
        this.currentScore = 0;
        this.highScore = 0;
    }

    // Method to Add Score
    public void addScore() {

        currentScore += 10;

        if (currentScore > highScore) {
            highScore = currentScore;
        }
    }

    // Method to Minus Score
    public void minusScore() {

        currentScore -= 5;

        if (currentScore < 0) {
            currentScore = 0;
        }
    }

    // Method to Reset Score
    public void resetScore() {
        currentScore = 0;
    }

    // Getter Methods
    public String getPlayerName() {
        return playerName;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getHighScore() {
        return highScore;
    }
}

// ===================== FRONTEND CLASS =====================
public class ModernGameScoreUI extends JFrame implements ActionListener {

    // Labels
    JLabel titleLabel;
    JLabel playerLabel;
    JLabel currentScoreLabel;
    JLabel highScoreLabel;

    // Buttons
    JButton addButton;
    JButton minusButton;
    JButton resetButton;

    // Panel
    JPanel mainPanel;

    // Backend Object
    GameScoreBackend score;

    // Constructor
    public ModernGameScoreUI() {

        // Input Player Name
        String playerName = JOptionPane.showInputDialog(
                null,
                "Enter Player Name"
        );

        // Backend Object
        score = new GameScoreBackend(playerName);

        // ================= FRAME =================
        setTitle("Modern Game Score Tracker");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ================= MAIN PANEL =================
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Modern Dark Background
        mainPanel.setBackground(new Color(18, 18, 35));

        // ================= TITLE =================
        titleLabel = new JLabel("GAME SCORE TRACKER");
        titleLabel.setBounds(180, 40, 700, 70);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);

        // ================= PLAYER NAME =================
        playerLabel = new JLabel(
                "PLAYER NAME : " + score.getPlayerName()
        );

        playerLabel.setBounds(240, 160, 600, 50);

        playerLabel.setFont(new Font("Arial", Font.BOLD, 32));
        playerLabel.setForeground(Color.CYAN);

        // ================= CURRENT SCORE =================
        currentScoreLabel = new JLabel(
                "CURRENT SCORE : " + score.getCurrentScore()
        );

        currentScoreLabel.setBounds(210, 280, 600, 50);

        currentScoreLabel.setFont(new Font("Arial", Font.BOLD, 34));
        currentScoreLabel.setForeground(Color.GREEN);

        // ================= HIGH SCORE =================
        highScoreLabel = new JLabel(
                "HIGHEST SCORE : " + score.getHighScore()
        );

        highScoreLabel.setBounds(220, 390, 600, 50);

        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 34));
        highScoreLabel.setForeground(Color.YELLOW);

        // ================= ADD BUTTON =================
        addButton = new JButton("ADD SCORE");

        addButton.setBounds(70, 540, 240, 70);

        addButton.setFont(new Font("Arial", Font.BOLD, 22));

        addButton.setBackground(new Color(0, 170, 0));
        addButton.setForeground(Color.WHITE);

        addButton.setFocusPainted(false);

        addButton.setBorder(BorderFactory.createLineBorder(
                Color.WHITE,
                2
        ));

        addButton.addActionListener(this);

        // ================= MINUS BUTTON =================
        minusButton = new JButton("MINUS");

        minusButton.setBounds(380, 540, 240, 70);

        minusButton.setFont(new Font("Arial", Font.BOLD, 22));

        minusButton.setBackground(new Color(220, 20, 60));
        minusButton.setForeground(Color.WHITE);

        minusButton.setFocusPainted(false);

        minusButton.setBorder(BorderFactory.createLineBorder(
                Color.WHITE,
                2
        ));

        minusButton.addActionListener(this);

        // ================= RESET BUTTON =================
        resetButton = new JButton("RESET");

        resetButton.setBounds(690, 540, 240, 70);

        resetButton.setFont(new Font("Arial", Font.BOLD, 22));

        resetButton.setBackground(new Color(0, 102, 255));
        resetButton.setForeground(Color.WHITE);

        resetButton.setFocusPainted(false);

        resetButton.setBorder(BorderFactory.createLineBorder(
                Color.WHITE,
                2
        ));

        resetButton.addActionListener(this);

        // ================= ADD COMPONENTS =================
        mainPanel.add(titleLabel);
        mainPanel.add(playerLabel);

        mainPanel.add(currentScoreLabel);
        mainPanel.add(highScoreLabel);

        mainPanel.add(addButton);
        mainPanel.add(minusButton);
        mainPanel.add(resetButton);

        add(mainPanel);

        setVisible(true);
    }

    // ================= UPDATE METHOD =================
    public void updateDisplay() {

        currentScoreLabel.setText(
                "CURRENT SCORE : " + score.getCurrentScore()
        );

        highScoreLabel.setText(
                "HIGHEST SCORE : " + score.getHighScore()
        );
    }

    // ================= BUTTON EVENTS =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            score.addScore();
        }

        if (e.getSource() == minusButton) {
            score.minusScore();
        }

        if (e.getSource() == resetButton) {
            score.resetScore();
        }

        updateDisplay();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // Modern Look
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ModernGameScoreUI();
    }
}