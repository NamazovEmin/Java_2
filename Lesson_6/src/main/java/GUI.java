import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {
    private JTextField messageTextField;
    private JTextArea chatTextArea;

    private final  EchoClient client;

    public GUI() {
        prepareGUI();
        client = new EchoClient(chatTextArea);
    }

    private void prepareGUI() {
        setBounds(600, 300,500,500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true);

        add(new JScrollPane(chatTextArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton button = new JButton("SEND");
        bottomPanel.add(button, BorderLayout.EAST);

        messageTextField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(messageTextField, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = messageTextField.getText();
                if (!text.isBlank()){
                    client.sendMessage(text);
                    messageTextField.setText("");
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                client.closeConnection();
            }
        });
        setVisible(true);
    }
}
