import React, { useState } from "react";
import { Link } from "react-router-dom"; // Import Link
import "./Login.css";
import {useNavigate } from "react-router-dom";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");
  const navigate = useNavigate();
  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrorMsg("");

    try {
<<<<<<< HEAD:src/Pages/Login.jsx
      const response = await fetch("http://localhost:3000/login", {
=======
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
        alert(text + "Yessir");

    }else{
      const response = await fetch("http://localhost:8080/auth/login", {
>>>>>>> 968706e70a1753fae35b41afe210321ae4e7dc85:frontend/src/Pages/Login.jsx
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
<<<<<<< HEAD:src/Pages/Login.jsx
        body: JSON.stringify({ email, password }),
      });
      const text = await response.text();
      alert(text);
    } catch (err) {
      setErrorMsg(err.message);
=======
        body: JSON.stringify({password, email}),
      });
        const text = await response.text();
        alert(text);
        navigate("/Menu");
    } 
    }catch(err){
      setErrorMsg(err.message); 
>>>>>>> 968706e70a1753fae35b41afe210321ae4e7dc85:frontend/src/Pages/Login.jsx
    }
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2>Login</h2>

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
            Login
          </button>
        </form>

        <p className="switch-text">
          Don't have an account?
          <Link to="/register" className="switch-link">
             Register
          </Link>
        </p>
      </div>
    </div>
  );
}
