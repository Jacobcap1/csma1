import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Homepage from './Pages/Homepage';
import Menu from './Pages/Menu';
import Cart from './Pages/Cart';
import Checkout from './Pages/Checkout';
//import Customize from './Pages/Customize';
import Login from './Pages/Login';
//import Rewards from './Pages/Rewards';
// import AdminDashboard from './Pages/admin/AdminDashboard';
// import MenuManager from './Pages/admin/MenuManager';
// import OrderQueue from './Pages/admin/OrderQueue';
// import RewardsManager from './Pages/admin/RewardsManager';
import NavBar from './Pages/NavBar';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <NavBar />

        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/menu" element={<Menu />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/checkout" element={<Checkout />} />
          {/* <Route path="/customize" element={<Customize />} /> */}
          <Route path="/login" element={<Login />} />
         {/*<Route path="/rewards" element={<Rewards />} />
          {/* <Route path="/admin" element={<AdminDashboard />} />
          <Route path="/admin/menu" element={<MenuManager />} />
          <Route path="/admin/orders" element={<OrderQueue />} />
          <Route path="/admin/rewards" element={<RewardsManager />} /> */}
        </Routes>
      </div>
    </Router>
 );
 }

 export default App;
