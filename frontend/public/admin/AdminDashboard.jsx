import React, { useState } from "react";
import MenuManager from "./MenuManager";
import CustomerRewardsManager from "./CustomerRewardsManager";
import OrderQueue from "./OrderQueue";
import Analytics from "./Analytics";
import "./Admin.css";

export default function AdminDashboard() {
  const [view, setView] = useState("menu");

  return (
    <div className="admin-container">
      <aside className="admin-sidebar">
        <h2>Admin Panel</h2>
        <button onClick={() => setView("menu")}>Menu Manager</button>
        <button onClick={() => setView("rewards")}>Customer Rewards</button>
        <button onClick={() => setView("queue")}>Order Queue</button>
        <button onClick={() => setView("analytics")}>Analytics</button>
      </aside>

      <main className="admin-main">
        {view === "menu" && <MenuManager />}
        {view === "rewards" && <CustomerRewardsManager />}
        {view === "queue" && <OrderQueue />}
        {view === "analytics" && <Analytics />}
      </main>
    </div>
  );
}
