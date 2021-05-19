public class Settings  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Chrono().setVisible(true);
            }
        });
    }
}