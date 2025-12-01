package com.coffeeshop.Database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreConnector {

    FirestoreConnector() throws IOException {
        initializeFirebase();
    }
    public static void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\jacob\\Downloads\\csma-94009-firebase-adminsdk-fbsvc-ac7b3ab4e9.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://csma-94009.firebaseio.com") // Optional, but good practice for RTDB/other services
                .build();

        if (FirebaseApp.getApps().isEmpty()) { // Check if already initialized
            FirebaseApp.initializeApp(options);
        }
        System.out.println("Firebase has been initialized!");
    }

    public static Firestore getFirestoreInstance() {
        return FirestoreClient.getFirestore();
    }

    public static void main(String[] args) {
        try {
            initializeFirebase();
            Firestore db = getFirestoreInstance();
            System.out.println("Firestore instance obtained: " + db);
            // You can now start performing operations with 'db'
        } catch (IOException e) {
            System.err.println("Error initializing Firebase: " + e.getMessage());
        }
    }
}
