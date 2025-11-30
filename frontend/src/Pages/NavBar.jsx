import React from "react";
import { Link, useNavigate } from "react-router-dom";
//import { auth } from "../firebase-config";
//import { signOut } from "firebase/auth";
import "./NavBar.css";

export default function Navbar({ user }) {
  const navigate = useNavigate();

  const handleLogout = async () => {
   // await signOut(auth);
    navigate("/login");
  };

  return (
    <nav className="sb-navbar">
      {/* LEFT SECTION */}
      <div className="sb-left">
        <img
          src="/logo.png" 
          alt="Logo"
          className="sb-logo"
        />

        <div className="sb-links">
          <Link to="/menu">MENU</Link>
          <Link to="/rewards">REWARDS</Link>
        </div>
      </div>

      {/* RIGHT SECTION */}
      <div className="sb-right">
        <div className="cart-button">
          <span className="cart-icon">🛒</span>
          <Link to="/cart">Cart</Link>
        </div>

        {user ? (
          <>
            <button className="sb-signin" onClick={handleLogout}>
              Logout
            </button>
          </>
        ) : (
          <>
            <Link to="/login">
              <button className="sb-signin">Sign in</button>
            </Link>
            <Link to="/register">
              <button className="sb-join">Join now</button>
            </Link>
          </>
        )}
      </div>
    </nav>
  );
}
