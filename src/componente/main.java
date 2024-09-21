/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package componente;

/**
 *
 * @author Josue
 */
public class main {

    public static void main(String[] args) {
        UserDatabase userDatabase = new UserDatabase();
        Login loginFrame = new Login(userDatabase);
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
    }
}
