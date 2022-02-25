import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Application implements ActionListener {

    private Random rnd = new Random();
    private int rows = 3;
    private int cols = 3;
    private final JFrame frame = new JFrame("Tic-Tac-Toe");
    private final JPanel mainMenuPanel = new JPanel();
    private final JPanel newGamePanel = new JPanel();
    private final JPanel gameTextPanel = new JPanel();
    private final JPanel gameButtonsPanel = new JPanel();
    private final JPanel gameOptionsPanel = new JPanel();
    private final JLabel mainMenuTextField = new JLabel();
    private final JLabel newGameTextField = new JLabel();
    private final JLabel gameTextField = new JLabel();
    private final JButton[] mainMenuButtons = new JButton[4];
    private final JButton[][] gameButtons = new JButton[rows][cols];
    private final JButton[] newGameButtons = new JButton[3];
    private final JButton[] gameOptionsButtons = new JButton[2];
    private GAMESTATE state = GAMESTATE.PVE;
    private int counter;
    private int rollRow;
    private int rollCol;
    private boolean draw;
    private String xSymbol = "X";
    private String oSymbol = "O";
    private int maxNumberOfTurns = 9;
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private int machineWins = 0;

    private boolean isPlayerOneTurn;
    private boolean gameOver = false;

    private enum GAMESTATE{
        PVP,
        PVE
    }


    public Application() {
        //Main Menu Panel Setup
        mainMenuPanel.setLayout(null);
        mainMenuPanel.setBounds(0,0,800,800);
        mainMenuPanel.setBackground(new Color(24, 99, 203, 189));
        mainMenuPanel.setVisible(true);
        mainMenuTextField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        mainMenuTextField.setText("Tic Tac Toe Game");
        mainMenuTextField.setBounds(30,50,800,100);
        mainMenuPanel.add(mainMenuTextField);
        for (int i = 0; i < 4; i++) {
            mainMenuButtons[i] = new JButton();
            mainMenuPanel.add(mainMenuButtons[i]);
            mainMenuButtons[i].setForeground(new Color(1, 2, 1, 184));
            mainMenuButtons[i].setBorder(BorderFactory.createEtchedBorder());
            mainMenuButtons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            mainMenuButtons[i].setFocusable(false);
            mainMenuButtons[i].addActionListener(this);
        }
        mainMenuButtons[0].setText("New Game");
        mainMenuButtons[0].setBounds(285,300,200,50);
        mainMenuButtons[1].setText("Load Game");
        mainMenuButtons[1].setBounds(285,375,200,50);
        mainMenuButtons[2].setText("Rankings");
        mainMenuButtons[2].setBounds(285,450,200,50);
        mainMenuButtons[3].setText("Quit");
        mainMenuButtons[3].setBounds(285,525,200,50);

        //New Game Panel Setup
        newGamePanel.setLayout(null);
        newGamePanel.setBounds(0,0,800,800);
        newGamePanel.setBackground(new Color(24, 99, 203, 189));
        newGamePanel.setVisible(false);
        newGameTextField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        newGameTextField.setText("Select Game Mode");
        newGameTextField.setBounds(30,50,800,100);
        newGamePanel.add(newGameTextField);
        for (int i = 0; i < 3; i++) {
            newGameButtons[i] = new JButton();
            newGamePanel.add(newGameButtons[i]);
            newGameButtons[i].setForeground(new Color(1, 2, 1, 184));
            newGameButtons[i].setBorder(BorderFactory.createEtchedBorder());
            newGameButtons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            newGameButtons[i].setFocusable(false);
            newGameButtons[i].addActionListener(this);
        }
        newGameButtons[0].setText("Player Vs Machine");
        newGameButtons[0].setBounds(285,300,200,50);
        newGameButtons[1].setText("Player Vs Player");
        newGameButtons[1].setBounds(285,375,200,50);
        newGameButtons[2].setText("Return");
        newGameButtons[2].setBounds(285,450,200,50);

        //Game Setup
        gameTextField.setBackground(new Color(25, 2, 2, 255));
        gameTextField.setForeground(new Color(8, 255, 0, 109));
        gameTextField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        gameTextField.setHorizontalAlignment(JLabel.CENTER);
        gameTextField.setText("Tic-Tac-Toe");
        gameTextField.setOpaque(true);

        gameTextPanel.setLayout(new BorderLayout());
        gameTextPanel.setBounds(0, 0, 800, 100);

        gameButtonsPanel.setLayout(new GridLayout(3, 3));
        gameButtonsPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < rows; i++) {
            for(int k = 0; k < cols; k++) {
                gameButtons[i][k] = new JButton();
                gameButtonsPanel.add(gameButtons[i][k]);
                gameButtons[i][k].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
                gameButtons[i][k].setFocusable(false);
                gameButtons[i][k].addActionListener(this);
            }
        }

        //Game Bottom Panel Setup
        gameOptionsPanel.setLayout(new GridLayout(1,2));
        gameOptionsPanel.setBackground(new Color(25, 2, 2, 255));
        for (int i = 0; i < 2; i++) {
            gameOptionsButtons[i] = new JButton();
            gameOptionsPanel.add(gameOptionsButtons[i]);
            gameOptionsButtons[i].setForeground(new Color(1, 2, 1, 184));
            gameOptionsButtons[i].setBorder(BorderFactory.createEtchedBorder());
            gameOptionsButtons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            gameOptionsButtons[i].setFocusable(false);
            gameOptionsButtons[i].addActionListener(this);
        }
        gameOptionsButtons[0].setText("Save Game");
        gameOptionsButtons[1].setText("Main Menu");

        gameTextPanel.add(gameTextField);
        gameButtonsPanel.setVisible(false);
        gameTextPanel.setVisible(false);
        gameOptionsPanel.setVisible(false);

        //Frame Setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainMenuPanel);
        frame.add(newGamePanel);
        frame.add(gameTextPanel, BorderLayout.NORTH);
        frame.add(gameButtonsPanel, BorderLayout.CENTER);
        frame.add(gameOptionsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //New Game
        if (e.getSource() == mainMenuButtons[0]) {
            mainMenuPanel.setVisible(false);
            newGamePanel.setVisible(true);
            gameTextField.setText("Tic-Tac-Toe");
            gameOver = false;
        }
        //Load Game
        if (e.getSource() == mainMenuButtons[1]) {
        }
        //Rankings
        if (e.getSource() == mainMenuButtons[2]) {
        }
        //Quit
        if (e.getSource() == mainMenuButtons[3]) {
            System.exit(0);
        }
        //Player Vs Machine
        if (e.getSource() == newGameButtons[0]) {
            state = GAMESTATE.PVE;
            counter = 0;
            isPlayerOneTurn = true;
            newGamePanel.setVisible(false);
            gameButtonsPanel.setVisible(true);
            gameTextPanel.setVisible(true);
            gameOptionsPanel.setVisible(true);
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    gameButtons[i][k].setEnabled(true);
                    gameButtons[i][k].setText("");
                    gameButtons[i][k].setBackground(Color.lightGray);
                }
            }
        }
        //Player Vs Player
        if (e.getSource() == newGameButtons[1]) {
            state = GAMESTATE.PVP;
            counter = 0;
            newGamePanel.setVisible(false);
            gameButtonsPanel.setVisible(true);
            gameTextPanel.setVisible(true);
            gameOptionsPanel.setVisible(true);
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    gameButtons[i][k].setEnabled(true);
                    gameButtons[i][k].setText("");
                    gameButtons[i][k].setBackground(Color.lightGray);
                }
            }
        }
        //Return to Main Menu
        if (e.getSource() == newGameButtons[2]) {
            mainMenuPanel.setVisible(true);
            newGamePanel.setVisible(false);
        }
        //Save Game
        if (e.getSource() == gameOptionsButtons[0]) {

        }
        //Return to Main Menu from game screen
        if (e.getSource() == gameOptionsButtons[1]) {
            mainMenuPanel.setVisible(true);
            gameButtonsPanel.setVisible(false);
            gameTextPanel.setVisible(false);
            gameOptionsPanel.setVisible(false);
        }

        //Player Vs Player gameplay
        if (state == GAMESTATE.PVP) {
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    if (e.getSource() == gameButtons[i][k]) {
                        if (isPlayerOneTurn) {
                            if (gameButtons[i][k].getText().equals("")) {
                                draw = true;
                                gameButtons[i][k].setForeground(new Color(255, 0, 0));
                                gameButtons[i][k].setText(xSymbol);
                                isPlayerOneTurn = false;
                                gameTextField.setText("O turn");
                                check(xSymbol);
                                counter++;
                                if (counter == maxNumberOfTurns && draw) {
                                    draw();
                                }
                            }
                        } else {
                            if (gameButtons[i][k].getText().equals("")) {
                                draw = true;
                                gameButtons[i][k].setForeground(new Color(0, 0, 255));
                                gameButtons[i][k].setText(oSymbol);
                                isPlayerOneTurn = true;
                                gameTextField.setText("X turn");
                                check(oSymbol);
                                counter++;
                                if (counter == maxNumberOfTurns && draw) {
                                    draw();
                                }
                            }
                        }
                    }
                }
            }

        }
        if(state == GAMESTATE.PVE){
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    if (e.getSource() == gameButtons[i][k]) {
                        if (isPlayerOneTurn) {
                            if (gameButtons[i][k].getText().equals("")) {
                                draw = true;
                                gameButtons[i][k].setForeground(new Color(255, 0, 0));
                                gameButtons[i][k].setText(xSymbol);
                                isPlayerOneTurn = false;
                                gameTextField.setText("X turn");
                                check(xSymbol);
                                counter++;
                                if (counter == maxNumberOfTurns && draw) {
                                    draw();
                                }
                                machineMove();
                            }
                        }
                    }
                }
            }
        }
    }

    public void machineMove(){
        rollRow = rnd.nextInt(rows);
        rollCol = rnd.nextInt(cols);
        while (gameButtons[rollRow][rollCol].getText().equals(xSymbol) || gameButtons[rollRow][rollCol].getText().equals(oSymbol)){
            rollRow = rnd.nextInt(rows);
            rollCol = rnd.nextInt(cols);
        }
        if(!gameOver) {
            if (!isPlayerOneTurn) {
                if (gameButtons[rollRow][rollCol].getText().equals("")) {
                    gameButtons[rollRow][rollCol].setForeground(new Color(0, 0, 255));
                    gameButtons[rollRow][rollCol].setText(oSymbol);
                    isPlayerOneTurn = true;
                    check(oSymbol);
                    counter++;
                    if (counter == maxNumberOfTurns && draw) {
                        draw();
                    }
                }
            }
        }
    }

    public void check(String move) {
        if (gameButtons[0][0].getText().equals(move) &&
            gameButtons[0][1].getText().equals(move) &&
            gameButtons[0][2].getText().equals(move)){
            whoWins(0,0,0, 1, 0, 2, move);
        }
        if (gameButtons[1][0].getText().equals(move) &&
            gameButtons[1][1].getText().equals(move) &&
            gameButtons[1][2].getText().equals(move)){
            whoWins(1,0,1, 1, 1, 2, move);
        }
        if (gameButtons[2][0].getText().equals(move) &&
            gameButtons[2][1].getText().equals(move) &&
            gameButtons[2][2].getText().equals(move)){
            whoWins(2,0,2, 1, 2, 2, move);
        }
        if (gameButtons[0][0].getText().equals(move) &&
            gameButtons[1][0].getText().equals(move) &&
            gameButtons[2][0].getText().equals(move)){
            whoWins(0,0,1, 0, 2, 0, move);
        }
        if (gameButtons[0][1].getText().equals(move) &&
            gameButtons[1][1].getText().equals(move) &&
            gameButtons[2][1].getText().equals(move)){
            whoWins(0,1,1, 1, 2, 1, move);
        }
        if (gameButtons[0][2].getText().equals(move) &&
            gameButtons[1][2].getText().equals(move) &&
            gameButtons[2][2].getText().equals(move)){
            whoWins(0,2,1, 2, 2, 2, move);
        }
        if (gameButtons[0][0].getText().equals(move) &&
            gameButtons[1][1].getText().equals(move) &&
            gameButtons[2][2].getText().equals(move)){
            whoWins(0,0,1, 1, 2, 2, move);
        }
        if (gameButtons[0][2].getText().equals(move) &&
            gameButtons[1][1].getText().equals(move) &&
            gameButtons[2][0].getText().equals(move)){
            whoWins(0,2,1, 1, 2, 0, move);
        }
    }

    public void whoWins(int rowA, int colA, int rowB, int colB, int rowC, int colC, String winner){
        gameButtons[rowA][colA].setBackground(Color.GREEN);
        gameButtons[rowB][colB].setBackground(Color.GREEN);
        gameButtons[rowC][colC].setBackground(Color.GREEN);

        for (int i = 0; i < rows; i++){
            for (int k = 0; k < cols; k++) {
                gameButtons[i][k].setEnabled(false);
            }
        }
        gameTextField.setText(winner + " wins");
        gameOver = true;
        draw = false;
        if(winner.equals("X")){
            playerOneWins++;
        }
        if(state == GAMESTATE.PVP && winner.equals("O")){
            playerTwoWins++;
        }
        if(state == GAMESTATE.PVE && winner.equals("O")){
            machineWins++;
        }
        saveRanking();
    }

    public void saveRanking(){
        Path path = Paths.get("ranking.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Player 'X' wins: "+ playerOneWins + "\nPlayer 'O' wins: "+playerTwoWins + "\nMachine wins: "+machineWins);
        } catch (IOException e){
            System.out.println("Wystapil blad");
            e.printStackTrace();
        }
    }

    public void draw(){
        for (int i = 0; i < rows; i++){
            for (int k = 0; k < cols; k++) {
                gameButtons[i][k].setEnabled(false);
                gameButtons[i][k].setBackground(Color.GRAY);
            }
        }
        gameTextField.setText("Draw");
    }
}
