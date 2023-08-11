//Temperature Convertor

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        String unit = scanner.next();
        double convertedTemperature;
        if (unit.equalsIgnoreCase("C")) {
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.println(temperature + "°C is equal to " + convertedTemperature + "°F");
        } else if (unit.equalsIgnoreCase("F")) {
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println(temperature + "°F is equal to " + convertedTemperature + "°C");
        } else {
            System.out.println("Invalid unit of measurement. Please enter C for Celsius or F for Fahrenheit.");
        }
    }
}



//Palindrome checker

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        for (int i = 0; i < cleanedInput.length() / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(cleanedInput.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(input + " is a palindrome!");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}


//Student Grade

import java.util.Scanner;

public class GradeAverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of grades to be entered: ");
        int numGrades = scanner.nextInt();
        double sum = 0;
        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            sum += grade;
        }
        double average = sum / numGrades;
        System.out.println("The average grade is: " + average);
    }
}


//Password Generator

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        System.out.print("Should the password include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");
        System.out.print("Should the password include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");
        System.out.print("Should the password include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");
        System.out.print("Should the password include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

        StringBuilder passwordCharacters = new StringBuilder();
        if (includeNumbers) {
            passwordCharacters.append(numbers);
        }
        if (includeLowercase) {
            passwordCharacters.append(lowercaseLetters);
        }
        if (includeUppercase) {
            passwordCharacters.append(uppercaseLetters);
        }
        if (includeSpecial) {
            passwordCharacters.append(specialCharacters);
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordCharacters.length());
            char c = passwordCharacters.charAt(index);
            password.append(c);
        }

        System.out.println("Your generated password is: " + password.toString());
    }
}

// Tic Tak Toe

import java.util.Scanner;

public class TicTacToe {

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY = '-';

    private static char[][] board = new char[3][3];
    private static int turn = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            initBoard();
            playGame(scanner);
            do {
                System.out.println("Do you want to play again? (y/n)");
                String input = scanner.nextLine();
                if (input.equals("y")) {
                    break;
                } else if (input.equals("n")) {
                    System.exit(0);
                }
            } while (true);
        }
    }

    private static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void playGame(Scanner scanner) {
        while (!isGameOver()) {
            printBoard();
            System.out.println("Player " + (turn == 1 ? "X" : "O") + ", please enter your move:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            makeMove(row, col);
        }

        printBoard();
        if (isWinner()) {
            System.out.println("Player " + (turn == 1 ? "X" : "O") + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    private static void makeMove(int row, int col) {
        if (board[row][col] != EMPTY) {
            System.out.println("This cell is already occupied!");
            return;
        }

        board[row][col] = (turn == 1 ? X : O);
        turn = (turn == 1 ? 2 : 1);
    }

    private static boolean isGameOver() {
        return isWinner() || isDraw();
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != EMPTY) {
                return true;
            }

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != EMPTY) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY) {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY) {
            return true;
        }

        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}


// Password Strenght Checker

import java.util.Scanner;

public class PasswordStrengthChecker {

    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;

    private static boolean containsUppercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsLowercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password:");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = containsUppercaseLetter(password);
        boolean hasLowercase = containsLowercaseLetter(password);
        boolean hasNumber = containsNumber(password);
        boolean hasSpecialCharacter = containsSpecialCharacter(password);

        String strength = "Weak";
        if (length >= MIN_LENGTH && length <= MAX_LENGTH) {
            if (hasUppercase && hasLowercase && hasNumber && hasSpecialCharacter) {
                strength = "Strong";
            } else if (hasUppercase && hasLowercase && (hasNumber || hasSpecialCharacter)) {
                strength = "Medium";
            }
        }

        System.out.println("Password strength: " + strength);
    }
}

// File Encryption

import java.io.*;

public class EncryptDecrypt {

    private static final int ENCRYPTION_KEY = 123456;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to encrypt (e) or decrypt (d) a file?");
        String choice = scanner.next();

        if (choice.equals("e")) {
            System.out.println("Enter the file name or path:");
            String fileName = scanner.next();
            encryptFile(fileName);
        } else if (choice.equals("d")) {
            System.out.println("Enter the file name or path:");
            String fileName = scanner.next();
            decryptFile(fileName);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void encryptFile(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileName + ".encrypted");

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] encryptedBuffer = encrypt(buffer, bytesRead);
            outputStream.write(encryptedBuffer);
        }

        inputStream.close();
        outputStream.close();
    }

    private static void decryptFile(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName + ".encrypted");
        FileOutputStream outputStream = new FileOutputStream(fileName);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] decryptedBuffer = decrypt(buffer, bytesRead);
            outputStream.write(decryptedBuffer);
        }

        inputStream.close();
        outputStream.close();
    }

    private static byte[] encrypt(byte[] buffer, int length) {
        for (int i = 0; i < length; i++) {
            buffer[i] = (byte) (buffer[i] + ENCRYPTION_KEY);
        }

        return buffer;
    }

    private static byte[] decrypt(byte[] buffer, int length) {
        for (int i = 0; i < length; i++) {
            buffer[i] = (byte) (buffer[i] - ENCRYPTION_KEY);
        }

        return buffer;
    }
}


// Chat application

import java.io.*;
import java.net.*;

public class ChatClient {

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public String receiveMessage() throws IOException {
        String message = inputStream.readUTF();
        return message;
    }

    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ChatClient client = new ChatClient("localhost", 8080);

        while (true) {
            String message = client.receiveMessage();
            System.out.println(message);

            message = System.console().readLine();
            client.sendMessage(message);
        }

        client.close();
    }
}


// MulitThread Application

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {

    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Incrementer());
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Count: " + count);
    }

    private static class Incrementer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

// Desktop application

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField textField1;
    private TextField textField2;
    private Label labelResult;

    @Override
    public void start(Stage primaryStage) {
        textField1 = new TextField();
        textField2 = new TextField();
        labelResult = new Label("0");

        Button buttonAdd = new Button("+");
        Button buttonSubtract = new Button("-");
        Button buttonMultiply = new Button("*");
        Button buttonDivide = new Button("/");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Number 1:"), 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label("Number 2:"), 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(buttonAdd, 0, 2);
        gridPane.add(buttonSubtract, 1, 2);
        gridPane.add(buttonMultiply, 0, 3);
        gridPane.add(buttonDivide, 1, 3);
        gridPane.add(labelResult, 0, 4, 2, 1);

        buttonAdd.setOnAction(event -> {
            int number1 = Integer.parseInt(textField1.getText());
            int number2 = Integer.parseInt(textField2.getText());
            int result = number1 + number2;
            labelResult.setText(String.valueOf(result));
        });

        buttonSubtract.setOnAction(event -> {
            int number1 = Integer.parseInt(textField1.getText());
            int number2 = Integer.parseInt(textField2.getText());
            int result = number1 - number2;
            labelResult.setText(String.valueOf(result));
        });

        buttonMultiply.setOnAction(event -> {
            int number1 = Integer.parseInt(textField1.getText());
            int number2 = Integer.parseInt(textField2.getText());
            int result = number1 * number2;
            labelResult.setText(String.valueOf(result));
        });

        buttonDivide.setOnAction(event -> {
            int number1 = Integer.parseInt(textField1.getText());
            int number2 = Integer.parseInt(textField2.getText());
            int result = number1 / number2;
            labelResult.setText(String.valueOf(result));
        });

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// Currency convertor

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_URL = "https://api.exchangeratesapi.io/latest";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base currency:");
        String baseCurrency = scanner.nextLine();

        System.out.println("Enter the target currency:");
        String targetCurrency = scanner.nextLine();

        System.out.println("Enter the amount to convert:");
        String amountString = scanner.nextLine();
        float amount = Float.parseFloat(amountString);

        URL url = new URL(API_URL + "?base=" + baseCurrency + "&symbols=" + targetCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            System.err.println("Error: " + responseCode);
            return;
        }

        InputStream inputStream = connection.getInputStream();
        Scanner responseScanner = new Scanner(inputStream);

        String response = responseScanner.nextLine();
        JSONObject jsonObject = new JSONObject(response);

        float exchangeRate = jsonObject.getJSONObject("rates").getFloat(targetCurrency);
        float convertedAmount = amount * exchangeRate;

        System.out.println("The converted amount is " + convertedAmount + " " + targetCurrency);
    }
}
