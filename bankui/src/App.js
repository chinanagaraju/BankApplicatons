import { BrowserRouter, Route, Routes } from "react-router-dom";
import Account from "./Account";
import Deposit from "./Deposit";
import Transfer from "./Transfer";
import  Home from "./Home";
import Login from "./Login";
import Withdraw from "./Withdraw";
import Registration from "./Registration";
import WithdrawalForm from "./WithdrawalForm";
import Instructions from "./Instructions";

function App() {
  
  return (
    <div className="App">
<BrowserRouter>
<div>
<Routes>
   <Route path='/' element={<Instructions/>}/>
   <Route path='/Login' element={<Login/>}/>
   <Route path='/Home' element={<Home/>}/>
    <Route path='/Registration' element={<Registration/>}/>
    <Route path='/deposit' element={<Deposit/>}/>
    <Route path='/Withdraw' element={<Withdraw/>}/>
    <Route path='/Account' element={<Account/>}/>
    <Route path='/Transfer' element={<Transfer/>}/>
    <Route path='/WithdrawalForm' element={<WithdrawalForm/>}/>   
</Routes>
</div>
</BrowserRouter>      
</div>
  );
}

export default App;
