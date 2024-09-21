/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Josue Royer Tanta Cieza 
 */
public class UserDatabase {

    private static final String FILENAME = "users.txt"; // Nombre del archivo donde se almacenan los datos de los usuarios
    public List<String> usernames = new ArrayList<>(); // Lista de nombres de usuario
    public List<String> passwords = new ArrayList<>(); // Lista de contraseñas
    public int usercount = 0; // Contador de usuarios

    public UserDatabase() { 
        loadUsers(); // Constructor que carga los usuarios desde el archivo al crear una instancia de la base de datos
    }

    public void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            // Abre el archivo y prepara para escribir los datos de usuarios
            for (int i = 0; i < usercount; i++) {
                writer.println(usernames.get(i) + "," + passwords.get(i)); // Escribe cada usuario y contraseña en el archivo
            }
        } catch (IOException e) {
            e.printStackTrace(); // Maneja las excepciones de E/S
        }
    }

    public void loadUsers() {
        File file = new File(FILENAME); // Crea un objeto File para "users.txt"
        if (!file.exists()) {
            try {
                file.createNewFile(); // crea un nuevo archivo "users.txt"
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            // Abre el archivo "users.txt"
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Agrega nombres de usuario y contraseñas a las listas y aumenta el contador de usuarios
                    usernames.add(parts[0]);
                    passwords.add(parts[1]);
                    usercount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
