import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Cart.css';

export default function Cart(){
const [cartData, setCartData] = useState(null);

  useEffect(() => {
    const fetchCart = async () => {
      try {
        const response = await fetch ("http://localhost:8080/cart");
        if (response.ok) {
          const data = await response.json();
          setCartData(data); // assume data is an array of DrinkDTOs
        } else {
          console.error("Failed to fetch cart from backend");
        }
      } catch (err) {
        console.error(err);
      }
    };

    fetchCart();
  }, []);
  if(!cartData){
    return <div>Loading Cart...</div>;
  }

  if (!cartData.items || cartData.items.length === 0) {
    return (
      <div className="cart-container">
        <h2 className="cart-title">Your Shopping Cart</h2>
        <div className="cart-empty">
          <p>Your cart is empty. Time to get some coffee!</p>
          <Link to="/menu" className="start-shopping-button">Start Shopping</Link>
        </div>
      </div>
    );
  }

  return (
    <div className="cart-container">
      <h2 className="cart-title">Your Shopping Cart</h2>
      <div className="cart-content">
        <div className="cart-items">
          {cartData.items.map((item, index) => (
            <div key={index} className="cart-item">
              <div className="item-details">
                <span className="item-name">{item.name}</span>
                <span className="item-price">${item.price}</span>
                <span className ="item-size">{item.size}</span>
                <p className="item-description">{item.description}</p>
              </div>
            </div>
          ))}
        </div>
        <div className="cart-summary">
          <div className="cart-total">
            <strong>Total:</strong>
            <span>${cartData.totalPrice}</span>
          </div>
          <Link to="/checkout" className="checkout-button">
            Proceed to Checkout
          </Link>
        </div>
      </div>
    </div>
  );
}

//       }
//     }
//   }
//   // const removeFromCart = (itemToRemove) => {
//   //   setCart(cart.filter(item => item.id !== itemToRemove.id));
//   // };

//   // const getTotalPrice = () => {
//   //   return cart.reduce((total, item) => total + item.price, 0).toFixed(2);
//   // };

//   return (
//     <div className="cart-container">
//       <h2 className="cart-title">Your Shopping Cart</h2>
//       {cart.length === 0 ? (
//         <div className="cart-empty">
//           <p>Your cart is empty. Time to get some coffee!</p>
//           <Link to="/menu" className="start-shopping-button">Start Shopping</Link>
//         </div>
//       ) : (
//         <div className="cart-content">
//           <div className="cart-items">
//             {cart.map((item) => (
//               <div key={item.id} className="cart-item">
//                 <div className="item-details">
//                   <span className="item-name">{item.name}</span>
//                   <span className="item-price">${item.price.toFixed(2)}</span>
//                 </div>
//                 <button onClick={() => removeFromCart(item)} className="remove-button">Remove</button>
//               </div>
//             ))}
//           </div>
//           <div className="cart-summary">
//             <div className="cart-total">
//               <strong>Total:</strong>
//               <span>${getTotalPrice()}</span>
//             </div>
//             <Link to="/checkout" className="checkout-button">
//               Proceed to Checkout
//             </Link>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// };

// export default Cart;
