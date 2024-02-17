package IHM1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class MainFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton printButton;

    public MainFrame() {
        setTitle("Data Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        printButton = new JButton("Print Ticket");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    printTicket(selectedRow);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(printButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        fetchAndDisplayData();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        displayRowData(selectedRow);
                    }
                }
            }
        });

        setVisible(true);
    }

    private void fetchAndDisplayData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ONCF", "postgres", "admin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ticket");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(columnNames);

            while (resultSet.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(resultSet.getObject(i));
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayRowData(int rowIndex) {
        StringBuilder rowData = new StringBuilder();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            Object value = tableModel.getValueAt(rowIndex, i);
            rowData.append(tableModel.getColumnName(i)).append(": ").append(value).append("\n");
        }

        JOptionPane.showMessageDialog(this, rowData.toString(), "Row Data", JOptionPane.INFORMATION_MESSAGE);
    }

    private void printTicket(int rowIndex) {
        StringBuilder ticketData = new StringBuilder();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            Object value = tableModel.getValueAt(rowIndex, i);
            ticketData.append(tableModel.getColumnName(i)).append(": ").append(value).append("\n");
        }

        // Simulate printing by printing to console
        System.out.println("Printing Ticket:\n" + ticketData.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
