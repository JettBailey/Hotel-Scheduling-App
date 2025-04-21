package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {

    public List<String> getWelcomeMessages() {
        List<String> messages = Collections.synchronizedList(new ArrayList<>());

        Thread englishThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.ENGLISH);
            messages.add(bundle.getString("welcome"));
        });

        Thread frenchThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.CANADA_FRENCH);
            messages.add(bundle.getString("welcome"));
        });

        englishThread.start();
        frenchThread.start();

        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
