import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import java.util.Random;

public class EightBall extends JFrame implements KeyListener{
    String question = "";
    JLabel questionLabel = new JLabel();
    JLabel answerLabel = new JLabel();
    JPanel displayQuestion = new JPanel();
    JPanel displayAnswer = new JPanel();

    EightBall(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);

        int width = 300;
        int height = 150;
        
        displayQuestion.setBounds(40,15,width,height);
        displayQuestion.setBackground(Color.white);
        displayQuestion.setLayout(new GridBagLayout());

        displayAnswer.setBounds(40,185,width,height);
        displayAnswer.setBackground(Color.red);
        displayAnswer.isOpaque();
        displayAnswer.setLayout(new GridBagLayout());

        questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
        answerLabel.setForeground(Color.white);
        answerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        this.add(displayQuestion);
        this.add(displayAnswer);
        displayQuestion.add(questionLabel);
        displayAnswer.add(answerLabel);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.questionLabel.setText(question);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int[] exceptTheseKeys = {
            16,17,18,33,34,35,36,37,38,39,40,127,144,155,524
        };

        boolean isNotExempted = true;

        for (int i = 0; i < exceptTheseKeys.length; i++) {
            if (exceptTheseKeys[i] == e.getKeyCode()){
                isNotExempted = false;
            }
        }

        if (e.getKeyCode() == 8){
            question = question.substring(0, question.length() - 1);
        }
        
        else if (isNotExempted){
            question += e.getKeyChar();
            this.questionLabel.setText(question);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("You released keycode: " + e.getKeyCode());
        if (e.getKeyCode() == 10){
            question = "";
            this.answerLabel.setText(eightBallAnswers());
        }
        
    }

    public String eightBallAnswers(){
        String[] possibleAnswers = {
            "As I see it, yes.",
            "Ask again later.",
            "Better not tell you now.",
            "Cannot predict now.",
            "Concentrate and ask again.",
             "Don't count on it.",
             "It is certain.",
             "It is decidedly so.",
             "Most likely.",
             "My reply is no.",
             "My sources say no.",
             "Outlook not so good.",
             "Outlook good.",
             "Reply hazy, try again.",
             "Signs point to yes.",
             "Very doubtful.",
             "Without a doubt.",
             "Yes.",
             "Yes - definitely.",
             "You may rely on it."
        };
        int chosenAnswerIndex = new Random().nextInt(possibleAnswers.length);
        String chosenAnswer = possibleAnswers[chosenAnswerIndex];
        return chosenAnswer;
    }
}
