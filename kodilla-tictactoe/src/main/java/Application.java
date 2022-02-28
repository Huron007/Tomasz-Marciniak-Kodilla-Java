import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.util.Random;
import java.util.Scanner;

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
    private final JPanel rankingPanel = new JPanel();
    private final JLabel mainMenuTextField = new JLabel();
    private final JLabel newGameTextField = new JLabel();
    private final JLabel gameTextField = new JLabel();
    private final JLabel[] rankingTextField = new JLabel[3];
    private final JButton[] mainMenuButtons = new JButton[4];
    private final JButton[][] gameButtons = new JButton[rows][cols];
    private final JButton[] newGameButtons = new JButton[3];
    private final JButton[] gameOptionsButtons = new JButton[2];
    private final JButton rankingReturnButton = new JButton();
    private final JFileChooser fileChooser = new JFileChooser();
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
    private String tempPlayerX;
    private String tempPlayerO;
    private String tempMachine;

    private boolean isPlayerOneTurn;
    private boolean gameOver = false;

    private enum GAMESTATE{
        PVP,
        PVE
    }


    public Application() throws IOException {

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
        fileChooser.setCurrentDirectory(new File("."));

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

        //Ranking Setup
        rankingPanel.setLayout(null);
        rankingPanel.setBounds(0,0,800,800);
        rankingPanel.setBackground(new Color(24, 99, 203, 189));
        rankingPanel.setVisible(false);
        for (int i = 0; i < 3; i++) {
            rankingTextField[i] = new JLabel();
            rankingPanel.add(rankingTextField[i]);
            rankingTextField[i].setFont(new Font("MS Gothic", Font.BOLD, 36));
        }
        rankingTextField[0].setBounds(250,125,800,200);
        rankingTextField[1].setBounds(250,200,800,200);
        rankingTextField[2].setBounds(250,275,800,200);
        rankingReturnButton.setForeground(new Color(1, 2, 1, 184));
        rankingReturnButton.setBorder(BorderFactory.createEtchedBorder());
        rankingReturnButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
        rankingReturnButton.setFocusable(false);
        rankingReturnButton.addActionListener(this);
        rankingReturnButton.setText("Return");
        rankingReturnButton.setBounds(285,650,200,50);
        rankingPanel.add(rankingReturnButton);
        loadRanking();

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
        frame.add(rankingPanel);
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
            gameOptionsButtons[0].setEnabled(true);
            gameOver = false;
        }
        //Load Game
        if (e.getSource() == mainMenuButtons[1]) {

            int returnValue = fileChooser.showOpenDialog(null);

            if(returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    loadGame(selectedFile);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                mainMenuPanel.setVisible(false);
                gameButtonsPanel.setVisible(true);
                gameTextPanel.setVisible(true);
                gameOptionsPanel.setVisible(true);
                for (int i = 0; i < rows; i++) {
                    for (int k = 0; k < cols; k++) {
                        gameButtons[i][k].setEnabled(true);
                        gameButtons[i][k].setBackground(Color.lightGray);
                        if (gameButtons[i][k].getText().equals(xSymbol)){
                            gameButtons[i][k].setForeground(new Color(255, 0, 0));
                        } else if (gameButtons[i][k].getText().equals(oSymbol)){
                            gameButtons[i][k].setForeground(new Color(0, 0, 255));
                        }
                    }
                }
                if(isPlayerOneTurn){
                    gameTextField.setText("X turn");
                } else {
                    gameTextField.setText("O turn");
                }
                gameOptionsButtons[0].setEnabled(true);
            }
        }
        //Rankings
        if (e.getSource() == mainMenuButtons[2]) {
            mainMenuPanel.setVisible(false);
            rankingPanel.setVisible(true);
        }
        //Return from ranking screen to main menu
        if (e.getSource() == rankingReturnButton) {
            mainMenuPanel.setVisible(true);
            gameButtonsPanel.setVisible(false);
            gameTextPanel.setVisible(false);
            gameOptionsPanel.setVisible(false);
            rankingPanel.setVisible(false);
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

            int returnValue = fileChooser.showSaveDialog(null);

            if(returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                saveGame(selectedFile);
            }

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

    public void whoWins(int rowA, int colA, int rowB, int colB, int rowC, int colC, String winner) {
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
        gameOptionsButtons[0].setEnabled(false);
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
        try {
            loadRanking();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }

    public void saveRanking(){

        try {
            FileWriter rankingWriter = new FileWriter("C:/Users/Tomek/IdeaProjects/kodilla-course/kodilla-tictactoe/src/main/resources/ranking.txt");
            String rankingContent = "Player 'X': "+ playerOneWins + "\nPlayer 'O': "+playerTwoWins + "\nMachine: "+machineWins;
            rankingWriter.write(rankingContent);
            rankingWriter.close();
        } catch (IOException e){
            System.out.println("Wystapil blad");
            e.printStackTrace();
        }
    }

    public void loadRanking() throws FileNotFoundException {
        File ranking = new File("C:/Users/Tomek/IdeaProjects/kodilla-course/kodilla-tictactoe/src/main/resources/ranking.txt");
        Scanner scan = new Scanner(ranking);
        tempPlayerX = scan.nextLine();
        playerOneWins = Integer.parseInt(tempPlayerX.replaceAll("[^0-9]", ""));
        tempPlayerO = scan.nextLine();
        playerTwoWins = Integer.parseInt(tempPlayerO.replaceAll("[^0-9]", ""));
        tempMachine = scan.nextLine();
        machineWins = Integer.parseInt(tempMachine.replaceAll("[^0-9]", ""));
        rankingTextField[0].setText(tempPlayerX);
        rankingTextField[1].setText(tempPlayerO);
        rankingTextField[2].setText(tempMachine);
        scan.close();
    }

    public void saveGame(File file){
        try {
            FileWriter gameSaver = new FileWriter(file.getAbsolutePath());
            String gameSave = gameButtons[0][0].getText() + "\n" + gameButtons[0][1].getText() + "\n" + gameButtons[0][2].getText() + "\n" +
                              gameButtons[1][0].getText() + "\n" + gameButtons[1][1].getText() + "\n" + gameButtons[1][2].getText() + "\n" +
                              gameButtons[2][0].getText() + "\n" + gameButtons[2][1].getText() + "\n" + gameButtons[2][2].getText() + "\n" +
                              isPlayerOneTurn + "\n" + counter + "\n" + state;
            gameSaver.write(gameSave);
            gameSaver.close();
        } catch (IOException e){
            System.out.println("Wystapil blad");
            e.printStackTrace();
        }
    }

    public void loadGame(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        gameButtons[0][0].setText(scan.nextLine());
        gameButtons[0][1].setText(scan.nextLine());
        gameButtons[0][2].setText(scan.nextLine());
        gameButtons[1][0].setText(scan.nextLine());
        gameButtons[1][1].setText(scan.nextLine());
        gameButtons[1][2].setText(scan.nextLine());
        gameButtons[2][0].setText(scan.nextLine());
        gameButtons[2][1].setText(scan.nextLine());
        gameButtons[2][2].setText(scan.nextLine());
        isPlayerOneTurn = Boolean.parseBoolean(scan.nextLine());
        counter = Integer.parseInt(scan.nextLine());
        if(scan.nextLine().equals("PVP")){
            state = GAMESTATE.PVP;
        } else if (scan.nextLine().equals("PVE")){
            state = GAMESTATE.PVE;
        }
        scan.close();
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
