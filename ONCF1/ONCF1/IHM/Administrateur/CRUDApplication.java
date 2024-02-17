package Administrateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CRUDApplication extends JFrame {
    private JTextField trainField, typeField, priceField, classeField;
    private JButton addButton, updateButton, deleteButton;
    private JList<String> trainList;
    private DefaultListModel<String> listModel;
    private ArrayList<Train> trains;

    public CRUDApplication() {
        setTitle("Train CRUD Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Train:"));
        trainField = new JTextField();
        inputPanel.add(trainField);

        inputPanel.add(new JLabel("Type:"));
        typeField = new JTextField();
        inputPanel.add(typeField);
        inputPanel.setBackground(Color.BLUE);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Class:"));
        classeField = new JTextField();
        inputPanel.add(classeField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        listModel = new DefaultListModel<>();
        trainList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(trainList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        scrollPane.setBackground(Color.BLUE);
        buttonPanel.setBackground(Color.WHITE);


        trains = new ArrayList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String train = trainField.getText();
                String type = typeField.getText();
                double price = Double.parseDouble(priceField.getText());
                String classe = classeField.getText();

                Train newTrain = new Train(train, type, price, classe);
                trains.add(newTrain);
                listModel.addElement(newTrain.getTrainInfo());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = trainList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Train train = trains.get(selectedIndex);
                    train.setType(typeField.getText());
                    train.setPrice(Double.parseDouble(priceField.getText()));
                    train.setClasse(classeField.getText());
                    listModel.set(selectedIndex, train.getTrainInfo());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = trainList.getSelectedIndex();
                if (selectedIndex != -1) {
                    trains.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CRUDApplication().setVisible(true);
            }
        });
    }
}

