//All works in checkout, need to make that page first
import { doc, updateDoc, getDoc } from "firebase/firestore";
const addPoints = async (userId, amount) => {
    const ref = doc(db, "users", userId);
    const snap = await getDoc(ref);
  
    const prevPoints = snap.data().points ?? 0;
    const earned = Math.floor(amount); // 1 point per $1
  
    await updateDoc(ref, { points: prevPoints + earned });
  };
  if (userId) {
    await addPoints(userId, total);
  }
  const [useReward, setUseReward] = useState(false);
  const rewardDiscount = 3; // Example $3 reward
  
  const finalTotal = useReward ? total - rewardDiscount : total;
/*
<label>
  <input
    type="checkbox"
    checked={useReward}
    onChange={() => setUseReward(!useReward)}
  />
  Redeem Reward (-$3)
</label>
<h2>Total: ${finalTotal.toFixed(2)}</h2>
*/      