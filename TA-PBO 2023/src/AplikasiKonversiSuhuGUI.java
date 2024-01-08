import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AplikasiKonversiSuhuGUI extends JFrame {
    private JComboBox<String> jenisSuhuAwalComboBox;
    private JTextField suhuAwalTextField;
    private JComboBox<String> jenisSuhuKonversiComboBox;
    private JButton konversiButton;
    private JTextArea hasilKonversiTextArea;

    public AplikasiKonversiSuhuGUI() {
        setTitle("Aplikasi Konversi Suhu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addListeners();
    }

    private void initComponents() {
        String[] jenisSuhu = {"Celsius", "Fahrenheit", "Kelvin"};

        jenisSuhuAwalComboBox = new JComboBox<>(jenisSuhu);
        suhuAwalTextField = new JTextField(10);
        jenisSuhuKonversiComboBox = new JComboBox<>(jenisSuhu);

        konversiButton = new JButton("Konversi");
        konversiButton.setBackground(new Color(30, 144, 255)); // Warna biru
        konversiButton.setForeground(Color.WHITE); // Warna teks putih
        konversiButton.setFocusPainted(false); // Menghilangkan efek border focus
        konversiButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Mengubah kursor saat hover

        hasilKonversiTextArea = new JTextArea(5, 20);
        hasilKonversiTextArea.setEditable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Baris 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Jenis Suhu Awal:"), gbc);
        gbc.gridx = 1;
        panel.add(jenisSuhuAwalComboBox, gbc);

        // Baris 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Masukkan Suhu:"), gbc);
        gbc.gridx = 1;
        panel.add(suhuAwalTextField, gbc);

        // Baris 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Jenis Suhu Konversi:"), gbc);
        gbc.gridx = 1;
        panel.add(jenisSuhuKonversiComboBox, gbc);

        // Baris 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(konversiButton, gbc);

        // Baris 5
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Hasil Konversi:"), gbc);

        // Baris 6
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(hasilKonversiTextArea), gbc);

        // Menyesuaikan warna latar belakang panel
        panel.setBackground(Color.WHITE);

        add(panel);
    }

    private void addListeners() {
        konversiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konversiSuhu();
            }
        });

        // Menambahkan efek hover pada tombol
        konversiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                konversiButton.setBackground(new Color(70, 130, 180)); // Warna biru tua saat hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                konversiButton.setBackground(new Color(30, 144, 255)); // Warna biru kembali saat tidak di-hover
            }
        });
    }

    private void konversiSuhu() {
        try {
            int indeksJenisSuhuAwal = jenisSuhuAwalComboBox.getSelectedIndex() + 1;
            double suhuAwalValue = Double.parseDouble(suhuAwalTextField.getText());
            int indeksJenisSuhuKonversi = jenisSuhuKonversiComboBox.getSelectedIndex() + 1;

            KonversiSuhu konversiSuhu;

            switch (indeksJenisSuhuAwal) {
                case 1:
                    konversiSuhu = new KonversiCelcius();
                    break;
                case 2:
                    konversiSuhu = new KonversiFahrenheit();
                    break;
                case 3:
                    konversiSuhu = new KonversiKelvin();
                    break;
                default:
                    hasilKonversiTextArea.setText("Pilihan jenis suhu tidak valid");
                    return;
            }

            double hasilKonversi;

            switch (indeksJenisSuhuKonversi) {
                case 1:
                    hasilKonversi = konversiSuhu.konversiKeCelsius(suhuAwalValue);
                    hasilKonversiTextArea.setText("Hasil konversi: " + hasilKonversi + " Celsius");
                    break;
                case 2:
                    hasilKonversi = konversiSuhu.konversiKeFahrenheit(suhuAwalValue);
                    hasilKonversiTextArea.setText("Hasil konversi: " + hasilKonversi + " Fahrenheit");
                    break;
                case 3:
                    hasilKonversi = konversiSuhu.konversiKeKelvin(suhuAwalValue);
                    hasilKonversiTextArea.setText("Hasil konversi: " + hasilKonversi + " Kelvin");
                    break;
                default:
                    hasilKonversiTextArea.setText("Pilihan jenis suhu konversi tidak valid");
            }
        } catch (NumberFormatException ex) {
            hasilKonversiTextArea.setText("Masukkan suhu dengan format yang benar");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiKonversiSuhuGUI().setVisible(true);
            }
        });
    }
}
