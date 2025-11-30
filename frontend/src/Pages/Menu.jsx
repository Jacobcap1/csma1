import React, { useEffect, useState } from "react";
import { collection, getDocs } from "firebase/firestore";
//import { db } from "../firebase-config";
import "./Menu.css";

export default function MenuPage({ addToCart }) {
  const [menuItems, setMenuItems] = useState([]);

  useEffect(() => {
    const loadMenu = async () => {
      const response = await fetch("http://localhost:8080/api/menu");
      //const menuCollection = collection(db, "menu");
      const data = await response.json();

      setMenuItems(data);
        //data.docs.map((doc) => ({ id: doc.id, ...doc.data() }))
     // );
    };

    loadMenu();
  }, []);

  return (
    <div className="menu-container">
      <h1 className="menu-title">Menu</h1>

      <div className="menu-grid">
        {menuItems.map((item) => (
          <div key={item.id} className="menu-card">
            <img
              src={item.image}
              alt={item.name}
              className="menu-image"
            />

            <div className="menu-info">
              <h3>{item.name}</h3>
              <p className="menu-category">{item.category}</p>
              <p className="menu-price">${item.price.toFixed(2)}</p>

              <button
                className="add-btn"
                onClick={async () => {
                  await fetch("http://localhost:8080/cart/add",{
                    method:"POST",
                    headers:{"Content-Type": "application/json"},
                    body: JSON.stringify(item)
                  });
                  addToCart(item);
                }}
                >
                Add to Cart
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
