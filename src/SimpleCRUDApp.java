import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class SimpleCRUDApp {
    private JFrame frame;
    private JTextField textFiledNama;
    private JTextField textFieldHarga;
    private JTextArea textAreaOutput;
    private HashMap<String, String> data;

    public SimpleCRUDApp() {
        data = new HashMap<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Simple CRUD App");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel labelName = new JLabel("Nama Part:");
        frame.getContentPane().add(labelName);

        textFiledNama = new JTextField();
        frame.getContentPane().add(textFiledNama);
        textFiledNama.setColumns(10);

        JLabel labelPrice = new JLabel("Harga:");
        frame.getContentPane().add(labelPrice);

        textFieldHarga = new JTextField();
        frame.getContentPane().add(textFieldHarga);
        textFieldHarga.setColumns(10);

        JButton btnCreate = new JButton("Tambah");
        frame.getContentPane().add(btnCreate);

        JButton btnUpdate = new JButton("Ubah");
        frame.getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Hapus");
        frame.getContentPane().add(btnDelete);

        JButton btnListAll = new JButton("Lihat Semua");
        frame.getContentPane().add(btnListAll);

        textAreaOutput = new JTextArea(10, 40);
        textAreaOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaOutput);
        frame.getContentPane().add(scrollPane);

        // Action Listeners for buttons
        btnCreate.addActionListener(e -> {
            createRecord();
        });

        btnUpdate.addActionListener( e -> {
            updateRecord();
        });

        btnDelete.addActionListener(e -> {
            deleteRecord();
        });

        btnListAll.addActionListener(e -> {
            listAllRecords();
        });

        frame.setVisible(true);
    }

    private void createRecord() {
        String nama = textFiledNama.getText();
        String harga = textFieldHarga.getText();
        if (!nama.isEmpty() && !harga.isEmpty()) {
            data.put(nama, harga);
            textAreaOutput.append("Record telah dibuat: " + nama + " - " + harga + "\n");
        } else {
            textAreaOutput.append("Mohon masukkan Nama dan Harga.\n");
        }
    }

    private void updateRecord() {
        String nama = textFiledNama.getText();
        String harga = textFieldHarga.getText();
        if (data.containsKey(nama)) {
            data.put(nama, harga);
            textAreaOutput.append("Record di update: " + nama + " - " + harga + "\n");
        } else {
            textAreaOutput.append("Record tidak ditemukan\n");
        }
    }

    private void deleteRecord() {
        String nama = textFiledNama.getText();
        if (data.containsKey(nama)) {
            data.remove(nama);
            textAreaOutput.append("Record dihapus: " + nama + "\n");
        } else {
            textAreaOutput.append("Record tidak ditemukan\n");
        }
    }

    private void listAllRecords() {
        if (data.isEmpty()) {
            textAreaOutput.append("Tidak Ada barang\n");
        } else {
            textAreaOutput.append("Semua barang:\n");
            for (String nama : data.keySet()) {
                textAreaOutput.append("Nama: " + nama + " - Harga: " + data.get(nama) + "\n");
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimpleCRUDApp window = new SimpleCRUDApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
