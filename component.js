import { db } from "./firebase";
import { collection, getDocs } from "firebase/firestore";

export async function loadUsers() {
  const snapshot = await getDocs(collection(db, "users"));
  snapshot.forEach((doc) => {
    console.log(doc.id, doc.data());
  });
}
