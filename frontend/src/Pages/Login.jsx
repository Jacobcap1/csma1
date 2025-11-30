import React, { useState } from "react";
//import { auth } from "../config/firebase.js";
//import {createUserWithEmailAndPassword, signInWithEmailAndPassword,} from "firebase/auth";
import "./Login.css";

export default function LoginPage() {
  const [isRegister, setIsRegister] = useState(false);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrorMsg("");

    try {
     if (isRegister) {
  //       await createUserWithEmailAndPassword(auth, email, password);
  //       alert("Account created successfully!");
  //     } else {
  //       await signInWithEmailAndPassword(auth, email, password);
  //       alert("Logged in successfully!");
  //     }
  //   } catch (err) {
  //     setErrorMsg(err.message);
  //   }
  // };
      const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({password,email}),
      });
        const text = await response.text();
        alert(text);

    }else{
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({password, email}),
      });
        const text = await response.text();
        alert(text);
    } 
    }catch(err){
      setErrorMsg(err.message); 
    }
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2>{isRegister ? "Create Account" : "Login"}</h2>

        {errorMsg && <p className="error">{errorMsg}</p>}

        <form onSubmit={handleSubmit} className="login-form">
          <input
            className="login-input"
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            className="login-input"
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button className="login-button" type="submit">
            {isRegister ? "Register" : "Login"}
          </button>
        </form>

        <p className="switch-text">
          {isRegister ? "Already have an account?" : "Don't have an account?"}
          <span
            className="switch-link"
            onClick={() => setIsRegister(!isRegister)}
          >
            {isRegister ? " Login" : " Register"}
          </span>
        </p>
      </div>
    </div>
  );
}
