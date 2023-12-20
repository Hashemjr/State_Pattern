import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GumballMachineGUI {
    private static JTextArea outputTextArea;

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(3);
       
        JFrame frame = new JFrame("Gumball Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel mainPanel = new JPanel() {
            // Override the paintComponent method to set the background image
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Images/Gumball.gif");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
    

        JPanel panel = new JPanel(new GridBagLayout()); // Use GridBagLayout for panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(75, 5, 75, 5); // Padding for the label
        
        JLabel label = createMulticoloredLabel("Gumball Machine");
        label.setFont(new Font("Serif", Font.BOLD, 70));
        panel.add(label, gbc);

        JButton insertQuarterButton = createButton("Insert Quarter");
        insertQuarterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output = gumballMachine.insertQuarter() + "\n";
                updateOutput(output);
            }
        });

        JButton ejectQuarterButton = createButton("Eject Quarter");
        ejectQuarterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output = gumballMachine.ejectQuarter() + "\n";
                updateOutput(output);
            }
        });

        JButton turnCrankButton = createButton("Turn Crank");
        turnCrankButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output = gumballMachine.turnCrank() + "\n";
                updateOutput(output); 
            }
        });

        gbc.gridy = 1;
        panel.add(insertQuarterButton, gbc);
        gbc.gridy = 2;
        panel.add(ejectQuarterButton, gbc);
        gbc.gridy = 3;
        panel.add(turnCrankButton, gbc);
    
        // Create and add the JTextArea to the frame
        outputTextArea = new JTextArea(10, 50);
        outputTextArea.setEditable(false);
        
        // Set the font for the JTextArea
        Font textAreaFont = new Font("Arial", Font.PLAIN, 30); // Change the font family, style, and size as needed
        outputTextArea.setFont(textAreaFont);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        
        gbc.gridy = 4;
        panel.add(Box.createRigidArea(new Dimension(0, 50)), gbc); // Add some space between the buttons and the JTextArea
        panel.add(scrollPane, gbc);
        gbc.insets = new Insets(100, 0, 50, 0); // Add more space above the label
        mainPanel.add(panel, BorderLayout.CENTER);
        
        frame.setContentPane(mainPanel);
        frame.setSize(3000, 2000); // Set the size of the frame
        frame.setVisible(true); // Make the frame visible

        Timer timer = new Timer(500, new ActionListener() {
            boolean changeColor = false;

            public void actionPerformed(ActionEvent e) {
                if (changeColor) {
                    insertQuarterButton.setBackground(Color.PINK);
                    ejectQuarterButton.setBackground(Color.GREEN);
                    turnCrankButton.setBackground(Color.CYAN);
                } else {
                    insertQuarterButton.setBackground(Color.WHITE);
                    ejectQuarterButton.setBackground(Color.WHITE);
                    turnCrankButton.setBackground(Color.WHITE);
                }
                changeColor = !changeColor;
            }
        });
        timer.start();
    }

    private static JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(500,100));
        button.setFont(new Font("Serif", Font.BOLD, 30));
        return button;
    }

    private static JLabel createMulticoloredLabel(String text) {
        StringBuilder htmlText = new StringBuilder("<html><div style='text-align: center;'>");
        for (char c : text.toCharArray()) {
            String colorHex = String.format("#%06X", (int) (Math.random() * 0xFFFFFF)); // Random color for each letter
            htmlText.append("<span style='color:").append(colorHex).append("'>").append(c).append("</span>");
        }
        htmlText.append("</div></html>");
        JLabel label = new JLabel(htmlText.toString());
        label.setFont(new Font("Serif", Font.BOLD, 70));
        return label;
    }


    private static void updateOutput(String message) {
        outputTextArea.append(message); // Appending the message to the JTextArea
    }
}
