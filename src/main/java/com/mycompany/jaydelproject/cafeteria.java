package com.mycompany.jaydelproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class cafeteria extends JFrame {

    private static final Map<Integer, MenuItem> MENU = new LinkedHashMap<>();

    static {
        MENU.put(1, new MenuItem("Espresso", 60));
        MENU.put(2, new MenuItem("Americano", 70));
        MENU.put(3, new MenuItem("Cappuccino", 80));
        MENU.put(4, new MenuItem("Latte", 85));
        MENU.put(5, new MenuItem("Mocha", 90));
        MENU.put(6, new MenuItem("Caramel Macchiato", 95));
        MENU.put(7, new MenuItem("Cold Brew", 100));
        MENU.put(8, new MenuItem("Matcha Latte", 110));
        MENU.put(9, new MenuItem("Hot Chocolate", 75));
        MENU.put(10, new MenuItem("Tea", 50));
    }

    private JTextField txtItemCode, txtQuantity, txtCashGiven, txtTotal, txtVAT, txtChange;
    private JLabel lblOrder;

    public cafeteria() {
        setTitle("Canteen Ordering System");
        setSize(550, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        // Left: Menu display
        JTextArea menuArea = new JTextArea(20, 15);
        menuArea.setEditable(false);
        StringBuilder menuText = new StringBuilder("=== MENU ===\n");
        MENU.forEach((code, item) -> 
            menuText.append("[").append(code).append("] ")
                    .append(item.name).append(" - P").append(item.price).append("\n"));
        menuArea.setText(menuText.toString());
        add(new JScrollPane(menuArea), BorderLayout.WEST);

        // Right: Form panel with GridLayout (8 rows x 2 cols)
        JPanel mainPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Item Code
        mainPanel.add(new JLabel("Enter Item Code:"));
        txtItemCode = new JTextField();
        mainPanel.add(txtItemCode);

        // Quantity
        mainPanel.add(new JLabel("Quantity:"));
        txtQuantity = new JTextField();
        mainPanel.add(txtQuantity);

        // Order display label
        mainPanel.add(new JLabel("Order:"));
        lblOrder = new JLabel("-");
        mainPanel.add(lblOrder);

        // VAT (readonly)
        mainPanel.add(new JLabel("VAT (12%):"));
        txtVAT = new JTextField();
        txtVAT.setEditable(false);
        mainPanel.add(txtVAT);

        // Total (readonly)
        mainPanel.add(new JLabel("Total Amount:"));
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        mainPanel.add(txtTotal);

        // Cash Given
        mainPanel.add(new JLabel("Cash Given:"));
        txtCashGiven = new JTextField();
        mainPanel.add(txtCashGiven);

        // Change (readonly)
        mainPanel.add(new JLabel("Change:"));
        txtChange = new JTextField();
        txtChange.setEditable(false);
        mainPanel.add(txtChange);

        // Buttons: Select and Exit
        JButton btnSelect = new JButton("Select");
        btnSelect.addActionListener(this::processOrder);
        mainPanel.add(btnSelect);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> System.exit(0));
        mainPanel.add(btnExit);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void processOrder(ActionEvent e) {
        try {
            int code = Integer.parseInt(txtItemCode.getText().trim());
            int quantity = Integer.parseInt(txtQuantity.getText().trim());

            if (!MENU.containsKey(code)) {
                JOptionPane.showMessageDialog(this, "Invalid item code!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be at least 1!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            MenuItem item = MENU.get(code);
            lblOrder.setText(item.name);

            double subtotal = item.price * quantity;
            double vat = subtotal * 0.12;
            double total = subtotal + vat;

            txtVAT.setText(String.format("%.2f", vat));
            txtTotal.setText(String.format("%.2f", total));

            String cashInput = txtCashGiven.getText().trim();
            if (cashInput.isEmpty()) {
                txtChange.setText("");
                return;
            }

            double cash = Double.parseDouble(cashInput);
            if (cash < total) {
                JOptionPane.showMessageDialog(this, "Insufficient cash!", "Error", JOptionPane.ERROR_MESSAGE);
                txtChange.setText("");
                return;
            }
            double change = cash - total;
            txtChange.setText(String.format("%.2f", change));

            // Show receipt dialog
            JOptionPane.showMessageDialog(this,
                    "Your order: " + item.name +
                    "\nPrice: P" + item.price +
                    "\nQuantity: " + quantity +
                    "\nVAT: P" + String.format("%.2f", vat) +
                    "\nTotal: P" + String.format("%.2f", total) +
                    "\nCash Given: P" + String.format("%.2f", cash) +
                    "\nChange: P" + String.format("%.2f", change),
                    "Receipt", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class MenuItem {
        String name;
        int price;

        MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new cafeteria().setVisible(true));
    }
}
