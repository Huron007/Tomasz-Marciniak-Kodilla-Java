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
    private final JFrame frame = new JFrame("Tic-Tac-Toe");
    private final JPanel main_menu_panel = new JPanel();
    private final JPanel new_game_panel = new JPanel();
    private final JPanel game_text_panel = new JPanel();
    private final JPanel game_buttons_panel = new JPanel();
    private final JPanel game_options_panel = new JPanel();
    private final JLabel main_menu_textfield = new JLabel();
    private final JLabel new_game_textfield = new JLabel();
    private final JLabel game_textfield = new JLabel();
    private final JButton[] main_menu_buttons = new JButton[4];
    private final JButton[] game_buttons = new JButton[9];
    private final JButton[] new_game_buttons = new JButton[3];
    private final JButton[] game_options_buttons = new JButton[2];
    private GAMESTATE state = GAMESTATE.PVE;
    private int counter;
    private int index;
    private boolean draw;
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private int machineWins = 0;

    private boolean player1_turn;
    private boolean gameOver = false;

    private enum GAMESTATE{
        PVP,
        PVE
    }


    public Application() {
        //Main Menu Panel Setup
        main_menu_panel.setLayout(null);
        main_menu_panel.setBounds(0,0,800,800);
        main_menu_panel.setBackground(new Color(24, 99, 203, 189));
        main_menu_panel.setVisible(true);
        main_menu_textfield.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        main_menu_textfield.setText("Tic Tac Toe Game");
        main_menu_textfield.setBounds(30,50,800,100);
        main_menu_panel.add(main_menu_textfield);
        for (int i = 0; i < 4; i++) {
            main_menu_buttons[i] = new JButton();
            main_menu_panel.add(main_menu_buttons[i]);
            main_menu_buttons[i].setForeground(new Color(1, 2, 1, 184));
            main_menu_buttons[i].setBorder(BorderFactory.createEtchedBorder());
            main_menu_buttons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            main_menu_buttons[i].setFocusable(false);
            main_menu_buttons[i].addActionListener(this);
        }
        main_menu_buttons[0].setText("New Game");
        main_menu_buttons[0].setBounds(285,300,200,50);
        main_menu_buttons[1].setText("Load Game");
        main_menu_buttons[1].setBounds(285,375,200,50);
        main_menu_buttons[2].setText("Rankings");
        main_menu_buttons[2].setBounds(285,450,200,50);
        main_menu_buttons[3].setText("Quit");
        main_menu_buttons[3].setBounds(285,525,200,50);

        //New Game Panel Setup
        new_game_panel.setLayout(null);
        new_game_panel.setBounds(0,0,800,800);
        new_game_panel.setBackground(new Color(24, 99, 203, 189));
        new_game_panel.setVisible(false);
        new_game_textfield.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        new_game_textfield.setText("Select Game Mode");
        new_game_textfield.setBounds(30,50,800,100);
        new_game_panel.add(new_game_textfield);
        for (int i = 0; i < 3; i++) {
            new_game_buttons[i] = new JButton();
            new_game_panel.add(new_game_buttons[i]);
            new_game_buttons[i].setForeground(new Color(1, 2, 1, 184));
            new_game_buttons[i].setBorder(BorderFactory.createEtchedBorder());
            new_game_buttons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            new_game_buttons[i].setFocusable(false);
            new_game_buttons[i].addActionListener(this);
        }
        new_game_buttons[0].setText("Player Vs Machine");
        new_game_buttons[0].setBounds(285,300,200,50);
        new_game_buttons[1].setText("Player Vs Player");
        new_game_buttons[1].setBounds(285,375,200,50);
        new_game_buttons[2].setText("Return");
        new_game_buttons[2].setBounds(285,450,200,50);

        //Game Setup
        game_textfield.setBackground(new Color(25, 2, 2, 255));
        game_textfield.setForeground(new Color(8, 255, 0, 109));
        game_textfield.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        game_textfield.setHorizontalAlignment(JLabel.CENTER);
        game_textfield.setText("Tic-Tac-Toe");
        game_textfield.setOpaque(true);

        game_text_panel.setLayout(new BorderLayout());
        game_text_panel.setBounds(0, 0, 800, 100);

        game_buttons_panel.setLayout(new GridLayout(3, 3));
        game_buttons_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            game_buttons[i] = new JButton();
            game_buttons_panel.add(game_buttons[i]);
            game_buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
            game_buttons[i].setFocusable(false);
            game_buttons[i].addActionListener(this);
        }

        //Game Bottom Panel Setup
        game_options_panel.setLayout(new GridLayout(1,2));
        game_options_panel.setBackground(new Color(25, 2, 2, 255));
        for (int i = 0; i < 2; i++) {
            game_options_buttons[i] = new JButton();
            game_options_panel.add(game_options_buttons[i]);
            game_options_buttons[i].setForeground(new Color(1, 2, 1, 184));
            game_options_buttons[i].setBorder(BorderFactory.createEtchedBorder());
            game_options_buttons[i].setFont(new Font("MS Gothic", Font.BOLD, 18));
            game_options_buttons[i].setFocusable(false);
            game_options_buttons[i].addActionListener(this);
        }
        game_options_buttons[0].setText("Save Game");
        game_options_buttons[1].setText("Main Menu");

        game_text_panel.add(game_textfield);
        game_buttons_panel.setVisible(false);
        game_text_panel.setVisible(false);
        game_options_panel.setVisible(false);

        //Frame Setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(main_menu_panel);
        frame.add(new_game_panel);
        frame.add(game_text_panel, BorderLayout.NORTH);
        frame.add(game_buttons_panel, BorderLayout.CENTER);
        frame.add(game_options_panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //New Game
        if (e.getSource() == main_menu_buttons[0]) {
            main_menu_panel.setVisible(false);
            new_game_panel.setVisible(true);
            game_textfield.setText("Tic-Tac-Toe");
            gameOver = false;
        }
        //Load Game
        if (e.getSource() == main_menu_buttons[1]) {
        }
        //Rankings
        if (e.getSource() == main_menu_buttons[2]) {
        }
        //Quit
        if (e.getSource() == main_menu_buttons[3]) {
            System.exit(0);
        }
        //Player Vs Machine
        if (e.getSource() == new_game_buttons[0]) {
            state = GAMESTATE.PVE;
            counter = 0;
            player1_turn = true;
            new_game_panel.setVisible(false);
            game_buttons_panel.setVisible(true);
            game_text_panel.setVisible(true);
            game_options_panel.setVisible(true);
            for (int i = 0; i < 9; i++) {
                game_buttons[i].setEnabled(true);
                game_buttons[i].setText("");
                game_buttons[i].setBackground(Color.lightGray);
            }
        }
        //Player Vs Player
        if (e.getSource() == new_game_buttons[1]) {
            state = GAMESTATE.PVP;
            counter = 0;
            new_game_panel.setVisible(false);
            game_buttons_panel.setVisible(true);
            game_text_panel.setVisible(true);
            game_options_panel.setVisible(true);
            for (int i = 0; i < 9; i++) {
                game_buttons[i].setEnabled(true);
                game_buttons[i].setText("");
                game_buttons[i].setBackground(Color.lightGray);
            }
        }
        //Return to Main Menu
        if (e.getSource() == new_game_buttons[2]) {
            main_menu_panel.setVisible(true);
            new_game_panel.setVisible(false);
        }
        //Save Game
        if (e.getSource() == game_options_buttons[0]) {

        }
        //Return to Main Menu from game screen
        if (e.getSource() == game_options_buttons[1]) {
            main_menu_panel.setVisible(true);
            game_buttons_panel.setVisible(false);
            game_text_panel.setVisible(false);
            game_options_panel.setVisible(false);
        }

        //Player Vs Player gameplay
        if (state == GAMESTATE.PVP) {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == game_buttons[i]) {
                    if (player1_turn) {
                        if (game_buttons[i].getText() == "") {
                            draw = true;
                            game_buttons[i].setForeground(new Color(255, 0, 0));
                            game_buttons[i].setText("X");
                            player1_turn = false;
                            game_textfield.setText("O turn");
                            check();
                            counter++;
                            if(counter == 9 && draw == true){
                                draw();
                            }
                        }
                    } else {
                        if (game_buttons[i].getText() == "") {
                            draw = true;
                            game_buttons[i].setForeground(new Color(0, 0, 255));
                            game_buttons[i].setText("O");
                            player1_turn = true;
                            game_textfield.setText("X turn");
                            check();
                            counter++;
                            if(counter == 9 && draw == true){
                                draw();
                            }
                        }
                    }
                }
            }

        }
        if(state == GAMESTATE.PVE){
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == game_buttons[i]) {
                    if (player1_turn) {
                        if (game_buttons[i].getText() == "") {
                            draw = true;
                            game_buttons[i].setForeground(new Color(255, 0, 0));
                            game_buttons[i].setText("X");
                            player1_turn = false;
                            game_textfield.setText("X turn");
                            check();
                            counter++;
                            if(counter == 9 && draw == true){
                                draw();
                            }
                            machineMove();
                        }
                    }
                }
            }
        }
    }

    public void machineMove(){
        index = rnd.nextInt(9);
        while (game_buttons[index].getText().equals("X")){
            index = rnd.nextInt(9);
        }
        if(!gameOver) {
            if (!player1_turn) {
                if (game_buttons[index].getText() == "") {
                    game_buttons[index].setForeground(new Color(0, 0, 255));
                    game_buttons[index].setText("O");
                    player1_turn = true;
                    check();
                    counter++;
                    if (counter == 9 && draw == true) {
                        draw();
                    }
                }
            }
        }
    }

    public void check() {
        //check X win condition
        if (game_buttons[0].getText().equals("X") &&
            game_buttons[1].getText().equals("X") &&
            game_buttons[2].getText().equals("X")){
            xWins(0,1,2);
        }
        if (game_buttons[3].getText().equals("X") &&
            game_buttons[4].getText().equals("X") &&
            game_buttons[5].getText().equals("X")){
            xWins(3,4,5);
        }
        if (game_buttons[6].getText().equals("X") &&
            game_buttons[7].getText().equals("X") &&
            game_buttons[8].getText().equals("X")){
            xWins(6,7,8);
        }
        if (game_buttons[0].getText().equals("X") &&
            game_buttons[3].getText().equals("X") &&
            game_buttons[6].getText().equals("X")){
            xWins(0,3,6);
        }
        if (game_buttons[1].getText().equals("X") &&
            game_buttons[4].getText().equals("X") &&
            game_buttons[7].getText().equals("X")){
            xWins(1,4,7);
        }
        if (game_buttons[2].getText().equals("X") &&
            game_buttons[5].getText().equals("X") &&
            game_buttons[8].getText().equals("X")){
            xWins(2,5,8);
        }
        if (game_buttons[0].getText().equals("X") &&
            game_buttons[4].getText().equals("X") &&
            game_buttons[8].getText().equals("X")){
            xWins(0,4,8);
        }
        if (game_buttons[2].getText().equals("X") &&
            game_buttons[4].getText().equals("X") &&
            game_buttons[6].getText().equals("X")){
            xWins(2,4,6);
        }

        //check O win condition
        if (game_buttons[0].getText().equals("O") &&
            game_buttons[1].getText().equals("O") &&
            game_buttons[2].getText().equals("O")){
            oWins(0,1,2);
        }
        if (game_buttons[3].getText().equals("O") &&
            game_buttons[4].getText().equals("O") &&
            game_buttons[5].getText().equals("O")){
            oWins(3,4,5);
        }
        if (game_buttons[6].getText().equals("O") &&
            game_buttons[7].getText().equals("O") &&
            game_buttons[8].getText().equals("O")){
            oWins(6,7,8);
        }
        if (game_buttons[0].getText().equals("O") &&
            game_buttons[3].getText().equals("O") &&
            game_buttons[6].getText().equals("O")){
            oWins(0,3,6);
        }
        if (game_buttons[1].getText().equals("O") &&
            game_buttons[4].getText().equals("O") &&
            game_buttons[7].getText().equals("O")){
            oWins(1,4,7);
        }
        if (game_buttons[2].getText().equals("O") &&
            game_buttons[5].getText().equals("O") &&
            game_buttons[8].getText().equals("O")){
            oWins(2,5,8);
        }
        if (game_buttons[0].getText().equals("O") &&
            game_buttons[4].getText().equals("O") &&
            game_buttons[8].getText().equals("O")){
            oWins(0,4,8);
        }
        if (game_buttons[2].getText().equals("O") &&
            game_buttons[4].getText().equals("O") &&
            game_buttons[6].getText().equals("O")){
            oWins(2,4,6);
        }

    }

    public void xWins(int a, int b, int c){
        game_buttons[a].setBackground(Color.GREEN);
        game_buttons[b].setBackground(Color.GREEN);
        game_buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            game_buttons[i].setEnabled(false);
        }
        game_textfield.setText("X wins");
        gameOver = true;
        draw = false;
        playerOneWins++;
        saveRanking();
    }

    public void oWins(int a, int b, int c){
        game_buttons[a].setBackground(Color.GREEN);
        game_buttons[b].setBackground(Color.GREEN);
        game_buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++){
            game_buttons[i].setEnabled(false);
        }
        game_textfield.setText("O wins");
        gameOver = true;
        draw = false;
        if(state == GAMESTATE.PVP){
            playerTwoWins++;
        }
        if(state == GAMESTATE.PVE){
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
        for (int i = 0; i < 9; i++){
            game_buttons[i].setEnabled(false);
            game_buttons[i].setBackground(Color.GRAY);
        }
        game_textfield.setText("Draw");
    }
}
