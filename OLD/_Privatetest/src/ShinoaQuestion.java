import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShinoaQuestion{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frage von Bob");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Frage
        JLabel questionLabel = new JLabel("I was crazy ones...");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(questionLabel, "North");

        // Ja-Button
        JButton yesButton = new JButton("they locked me in a room...");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "a RubERrOom... hHahAhahaAhhaAhHa");
            }
        });

        // Nein-Button
        JButton noButton = new JButton("aha");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "u may be safe for now");
            }
        });

        // Panel für die Buttons
        JPanel panel = new JPanel();
        panel.add(yesButton);
        panel.add(noButton);

        frame.getContentPane().add(panel, "South");

        // Fenster sichtbar machen
        frame.setVisible(true);
    }
}