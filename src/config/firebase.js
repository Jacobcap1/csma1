import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore } from "firebase/firestore";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyBznyQ_NfwBDX5UncjoAUevIUX2fuwqtyg",
  authDomain: "csma-94009.firebaseapp.com",
  projectId: "csma-94009",
  storageBucket: "csma-94009.firebasestorage.app",
  messagingSenderId: "106950937832",
  appId: "1:106950937832:web:80f10e9f9a35fff40b4d5d",
  measurementId: "G-1QERP8Q4LP"
};

const app = initializeApp(firebaseConfig);
//export const auth = getAuth(app);

export const db = getFirestore(app)
const analytics = getAnalytics(app);
