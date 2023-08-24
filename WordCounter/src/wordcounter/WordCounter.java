/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordcounter;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {

    private JTextArea answerArea;
    private JTextArea textArea;

    public WordCounter() {
        setTitle("Words Counter");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane textScrollPane = new JScrollPane(textArea);

        JButton countBtn = new JButton("Words Count");
        countBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WordsCount();
            }
        });
        answerArea = new JTextArea(10, 30);
        answerArea.setEditable(false);
        JScrollPane answerScrollPane = new JScrollPane(answerArea);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(textScrollPane, BorderLayout.CENTER);
        inputPanel.add(countBtn, BorderLayout.SOUTH);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(answerScrollPane, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
        splitPane.setDividerLocation(0.5);

        add(splitPane);
        setVisible(true);
    }

    private void WordsCount() {
        String ipText = textArea.getText();
        if (ipText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text or provide a file to count words");
            return;
        }
        String[] words = ipText.split("\\s+|\\p{Punct}");
        Set<String> commonWords = new HashSet<>(
                Arrays.asList("a", "an", "the", "in", "on", "and", "is", "are", "it", "to"));
        Map<String, Integer> wordFrequencies = new HashMap<>();

        int totalWordsCount = 0;

        for (String word : words) {
            word = word.toLowerCase();
            if (!word.isEmpty() && !commonWords.contains(word)) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                totalWordsCount++;
            }
        }
        answerArea.append("Unique words and Frequencies:\n");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            answerArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounter());
    }
}
