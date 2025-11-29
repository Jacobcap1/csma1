package Database;
import Classes.Account;
import Classes.Order;
import com.google.cloud.firestore.*;
import com.google.api.core.ApiFuture;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DBMGR {
    private static Firestore db;

    public DBMGR() throws IOException {
        FirestoreConnector fc = new FirestoreConnector();
        this.db = fc.getFirestoreInstance();
        }

public boolean emailExists(String email) throws Exception {
        if (db == null){
            System.out.println(email);
            return false;}
        else {
        String emailToSearch = email;
        System.out.println(email);
        String collectionName = "Customers";
        String emailFieldName = "Email";
        CollectionReference usersRef = db.collection(collectionName);
        Query query = usersRef.whereEqualTo(emailFieldName,emailToSearch);
        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot snapshot = future.get();
            System.out.println(snapshot.size());
        if (snapshot.size() == 0){
            System.out.println("Email Doesn't exist");
            return true;//email not found. User can create account
    }
    System.out.println("User has an account already");
    return false;//email found. User can log in

}
    }
    public String getFirestoreTimestamp() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ISO_INSTANT);
    }

   public String storeOrderInDB(Order o){
        if (db == null)
        {
            return ("Firestore instance not called");
        }
        else{
            Map<String,Object> orderData = new HashMap<>();
            orderData.put("Date",getFirestoreTimestamp());
            orderData.put("Name", o.getName());
            orderData.put("Items",o.getItems());
           orderData.put("Price",o.getPrice());
           orderData.put("Phone Number",o.getNumber());
           orderData.put("Credit Card Number", o.getCCNumber());
           orderData.put("CVC", o.getCVC());
           orderData.put("Expiration", o.getExpDate());
      
            try{
                ApiFuture<DocumentReference> future = db.collection("OrderHistory").add(orderData);
                DocumentReference docRef = future.get();
                System.out.println("Doc written with id:"+ docRef.getId());

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("THats a problem");
                return "Error writing Order to Database" + e.getMessage();
            }

        return "Order stored in memory";
        }
    }
    public String storeAccountInDB(String password, String email) {
        if (db == null) {
            return ("Firestore instance not initialized. Call setFirestoreInstance() first.");}
        else{
        Map<String, Object> userData = new HashMap<>();
        // userData.put("FirstName",fName);
        // userData.put("LastName",lName);
        userData.put("Email", email);
        userData.put("Password",password);
        userData.put("DateJoined", getFirestoreTimestamp()); // Add a timestamp
        userData.put("CustomerID", java.util.UUID.randomUUID().toString());
        userData.put("Points", 0);

        try{
            ApiFuture<DocumentReference> future = db.collection("Customers").add(userData);
            DocumentReference docRef = future.get();
            System.out.println("Doc written with id:"+ docRef.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error writing Account to Database" + e.getMessage();
        }
            return"success";

        }
    }

    public String verifyUser(String email, String password) throws Exception {
        if (db == null) {
            return ("Firestore instance not initialized. Call setFirestoreInstance() first.");}
        else{
            if(!emailExists(email)) {//this means user has an email already registered
                String collectionName = "Customers";
                String passwordFieldName = "Password";
                String emailFieldName = "Email";

                ApiFuture<QuerySnapshot> future =
                        db.collection(collectionName).whereEqualTo(emailFieldName, email).get();

                QuerySnapshot snapshot = future.get();

                DocumentSnapshot doc = snapshot.getDocuments().get(0);
                String passwordInDatabase = doc.getString(passwordFieldName);

                if (password.equals(passwordInDatabase)) {
                    String accountEmail = doc.getString("Email");
                    String fName = doc.getString("FirstName");
                    String lName = doc.getString("LastName");
                    double points = doc.getDouble("Points");
                    //create Account object
                    Account a = new Account(fName, lName, passwordInDatabase,points,accountEmail);
                    System.out.println(a.toString());
                    return "Correct Password";
                } else {
                    System.out.println("Incorrect");
                    return "Incorrect Password. Try again!";
                }
            }
            else {
                return "User doesn't have an account. Create account?";
            }
        }



}


}
