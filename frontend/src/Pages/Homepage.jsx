import React from "react";
import "../App.css";
//import { Auth } from "../Components/auth";

export default function Homepage({ onStartOrder }) {
  return (
    <div className="landing-container">
      <h1 className="title">Welcome to BrewTime Coffee</h1>
      <p className="subtitle">Order ahead. Skip the line.</p>

      <button 
        className="btn-primary"
        onClick={onStartOrder}
      >
        Start Order
      </button>

    {/* <Auth /> */}
    </div>
  );
}
