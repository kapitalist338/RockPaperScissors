import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener {
    JLabel lab, bg;
    JButton R, P, S, res, bres;
    private static String playrs_Move, pcRun;

    String[] rps = {"r", "p", "s"};
    Random r = new Random();
    private ImageIcon ii1;
    public Game(){
        ii1 = new ImageIcon("src/RPs.png");
        res = new JButton("allow resizable");
        res.addActionListener(this);
        bres = new JButton("block resizable");
        bres.addActionListener(this);
        bg = new JLabel(ii1);
        bg.setSize(500,100);
        pcRun = rps[r.nextInt(rps.length)];
        this.setTitle("RockPaperScissors");
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200,300,500,400);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        R = new JButton("Rock");
        P = new JButton("Paper");
        S = new JButton("Scissors");
        R.addActionListener(this);
        P.addActionListener(this);
        S.addActionListener(this);
        R.setSize(300,150);
        P.setSize(300,150);
        S.setSize(300,150);
        lab = new JLabel();
        lab.setSize(300,200);

        this.add(lab);
        this.add(R);
        this.add(P);
        this.add(S);
        this.add(bg);
        this.add(res);
        this.add(bres);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == R){
            playrs_Move = "Rock!";
            if(pcRun == "s"){
                lab.setForeground(Color.GREEN);
                lab.setText(pcRun +":You win!");
            } else if (pcRun == "p") {
                lab.setForeground(Color.RED);
                lab.setText(pcRun + ":You lose!");
            }else {
                lab.setForeground(Color.LIGHT_GRAY);
                lab.setText(pcRun +":Draw!");
            }
            pcRun = rps[r.nextInt(rps.length)];
            System.out.println(playrs_Move);
        }
        if(e.getSource() == P){
            playrs_Move = "Paper";
            if(pcRun == "r"){
                lab.setForeground(Color.GREEN);
                lab.setText(pcRun +":You win!");
            } else if (pcRun == "s") {
                lab.setForeground(Color.RED);
                lab.setText(pcRun +":You lose!");
            }else {
                lab.setForeground(Color.LIGHT_GRAY);
                lab.setText(pcRun +":Draw!");
            }
            pcRun = rps[r.nextInt(rps.length)];
            System.out.println(playrs_Move);
        }
        if(e.getSource() == S){
            playrs_Move = "scissor";
            if(pcRun == "p"){
                lab.setForeground(Color.GREEN);
                lab.setText(pcRun +":You win!");
            } else if (pcRun == "r") {
                lab.setForeground(Color.RED);
                lab.setText(pcRun +":You lose!");
            }else {
                lab.setForeground(Color.LIGHT_GRAY);
                lab.setText(pcRun +":Draw!");
            }
            pcRun = rps[r.nextInt(rps.length)];
            System.out.println(playrs_Move);
        }

        if(e.getSource() == res){
            this.setResizable(true);
        }
        if(e.getSource() == bres){
            this.setResizable(false);
        }
    }
}
