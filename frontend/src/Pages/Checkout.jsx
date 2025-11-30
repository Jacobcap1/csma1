import React from 'react';
import './Checkout.css';

const Checkout = ({ cart }) => {
  const handleCheckout = async (e) => {
    e.preventDefault();
   
      const orderData = {
        cart: cart,
          name: e.target[0].value,
          phone: e.target[1].value,
          cardNumber: e.target.cardnumber.value,
          exp: e.target.expiration.value,
          cvc: e.target.cvc.value
      };
    try{
      const response = await fetch("http://localhost:8080/api/orders/create", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(orderData),
      });
    
      if (response.ok) {
        alert("Order placed!");
      } else {
        const text = await response.text();
        alert("Failed to place order.");
      }
    }catch(err){
      alert("Error connectng to backend "+ err.message);
    }
  };
      
  
  

  return (
    <div className="checkout-container">
      <h2>Checkout</h2>
      <form className="checkout-form" onSubmit={handleCheckout}>
        <input name="name" type="text" placeholder="Full Name" required />
        <input name="phone" type="text" placeholder="Phone Number" required />
        <input name="cardNumber" type="text" placeholder="Card Number" required />
        <input name="expiration" type="text" placeholder="MM/YY" required />
        <input name="cvc" type="text" placeholder="CVC" required />
        <button type="submit" className="place-order-button">Place Order</button>
      </form>

      <div className="order-summary">
        <h3>Order Summary</h3>
        {cart.map((item, index) => (
          <div key={index}>
            {item.name} - ${item.price.toFixed(2)}
          </div>
        ))}
      </div>
    </div>
  );

};


export default Checkout;


//   return (
//     <div className="checkout-container">
//       <h2>Checkout</h2>
//       <div className="checkout-summary">
//         <div className="order-summary">
//           <h3>Order Summary</h3>
//           {cart.map((item, index) => (
//             <div key={index} className="summary-item">
//               <span>{item.name}</span>
//               <span>${item.price.toFixed(2)}</span>
//             </div>
//           ))}
//           <div className="summary-total">
//             <strong>Total:</strong> ${getTotalPrice()}
//           </div>
//         </div>
//         <form className="checkout-form" onSubmit={handleCheckout}>
//           <h3>Shipping & Payment</h3>
//           <input type="text" placeholder="Full Name" required />
//           <input type="text" placeholder="Card Number" required />
//           <div className="card-details">
//             <input type="text" placeholder="MM/YY" required />
//             <input type="text" placeholder="CVC" required />
//           </div>
//           <button type="submit" className="place-order-button">
//             Place Order
//           </button>
//         </form>
//       </div>
//     </div>
//   );
// };

// export default Checkout;
