/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_bmk;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author meirb
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button solve;
    @FXML
    private Button clean;
    @FXML
    private Button exit;
    @FXML
    private TextField textInputA;
    @FXML
    private TextField textInputB;
    @FXML
    private TextField textInputX;
    @FXML
    private TextField textInputD;
    @FXML
    private Label textResult;
    @FXML
    private TextField textInputC;

    @FXML
    private void solve(ActionEvent event) {
        double a, b, c, x, d, y;
        try {
            a = Double.parseDouble(textInputA.getText());
            b = Double.parseDouble(textInputB.getText());
            c = Double.parseDouble(textInputC.getText());
            x = Double.parseDouble(textInputX.getText());
            d = Double.parseDouble(textInputD.getText());
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введеных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textInputA.requestFocus();
            textResult.setText("В введённых значениях допущены ошибки");
            textInputA.setText("");
            textInputB.setText("");
            textInputX.setText("");
            textInputD.setText("");
            textInputC.setText("");
            return;
        }

        if (x <= 5) {
            y = ((a * a * c + b * b - d) / x);
        } else {
            y = (x * x + 5);
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            textResult.setText("Ответ: " + String.format(":%.2f", y));
        } else {
            textResult.setText("Нет ответа");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clean(ActionEvent event) {
        textResult.setText("Ответ: ");
        textInputA.setText("");
        textInputB.setText("");
        textInputX.setText("");
        textInputD.setText("");
        textInputC.setText("");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
