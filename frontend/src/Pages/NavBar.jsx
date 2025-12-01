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
       <Link to="/">
        <img
          src="/logo.png" 
          alt="Logo"
          className="sb-logo"
        />
       </Link>

        <div className="sb-links">
          <Link to="/menu">MENU</Link>
          <Link to="/rewards">REWARDS</Link>
          <Link to="/cart">CART</Link>
        </div>
      </div>

      {/* RIGHT SECTION */}
      <div className="sb-right">
        {user ? (
          <>
            <button className="sb-signin" onClick={handleLogout}>
              Logout
            </button>
          </>
        ) : (
          <>
            <Link to="/login">
              <button className="sb-signin">Login</button>
            </Link>
            <Link to="/register">
              <button className="sb-join">Register</button>
            </Link>
          </>
        )}
      </div>
    </nav>
  );
}
