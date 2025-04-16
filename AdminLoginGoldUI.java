import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginGoldUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private GlitterButton loginButton;

    public AdminLoginGoldUI() {
        setTitle("Admin Login");
        setSize(500, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel titleLabel = new JLabel("    Admin Login");
        titleLabel.setBounds(140, 20, 220, 40);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 28));
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(80, 90, 100, 25);
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 90, 220, 30);
        usernameField.setBackground(new Color(30, 30, 30));
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(80, 140, 100, 25);
        passLabel.setForeground(Color.WHITE);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 140, 220, 30);
        passwordField.setBackground(new Color(30, 30, 30));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        add(passwordField);

        loginButton = new GlitterButton("Login");
        loginButton.setBounds(180, 200, 150, 40);
        add(loginButton);

        loginButton.addActionListener(e -> checkLogin());

        setVisible(true);
    }

    private void checkLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("aman3390") && password.equals("aman3390")) {
            JOptionPane.showMessageDialog(this, "Login Successful ✅", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new PlagiarismCheckerGUI(); // Open next screen
        } else {
            JOptionPane.showMessageDialog(this, "❌ Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminLoginGoldUI::new);
    }
}

// === GlitterButton Class ===
class GlitterButton extends JButton {
    private float shimmer = 0;
    private Timer timer;

    public GlitterButton(String text) {
        super(text);
        setFocusPainted(false);
        setFont(new Font("Georgia", Font.BOLD, 16));
        setForeground(Color.BLACK);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        timer = new Timer(40, e -> {
            shimmer += 0.05f;
            if (shimmer > 1) shimmer = 0;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(
                0, 0, new Color(255, 215, 0),
                (int) (w * shimmer), h, new Color(255, 255, 255, 80), true
        );

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, w, h, 20, 20);

        super.paintComponent(g2);
        g2.dispose();
    }
}
