import React, { useEffect, useState } from "react";
import { collection, onSnapshot, updateDoc, doc } from "firebase/firestore";
import { db } from "../../firebase-config";

export default function OrderQueue() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    const unsub = onSnapshot(collection(db, "orders"), (snap) => {
      setOrders(snap.docs.map((d) => ({ id: d.id, ...d.data() })));
    });
    return unsub;
  }, []);

  const updateStatus = async (id, status) => {
    await updateDoc(doc(db, "orders", id), { status });
  };

  return (
    <div>
      <h1>Order Queue</h1>

      {orders.map((o) => (
        <div key={o.id} className="order-card">
          <h3>Order #{o.id}</h3>
          <p>Status: {o.status}</p>
          <button onClick={() => updateStatus(o.id, "In Progress")}>Prep</button>
          <button onClick={() => updateStatus(o.id, "Ready")}>Ready</button>
          <button onClick={() => updateStatus(o.id, "Completed")}>Complete</button>
        </div>
      ))}
    </div>
  );
}
