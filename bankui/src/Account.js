import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Account() {
   
    const initialState = {
        userName: "",
        mobile: "",
        accountNumber: "",
        balance: "",
        bankName: "",
        location: "",
        ifsc: "",
    };
   
    const [formData, setFormData] = useState(initialState);
    const navigate = useNavigate();

  
    const handleInput = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleResponse = (response) => {
   
        if (response.data.message) {
            alert(response.data.message);   
             setFormData(initialState);
             navigate('/Registration');
            
        } else {
            alert(response.data.message);
            setFormData(initialState);
        }
    };
    
    


    const handleAccount = async (event) => {
        event.preventDefault(); 
        try {
         
            const response = await axios.post(
                "http://localhost:8080/Bank/account",
                formData,
                {
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );

           
            handleResponse(response);
        } catch (error) {
           
            console.error("Error creating account:", error);
            alert("Request failed. Check console for details.");
        }
    };

    return (
        <div className="container-Account">
            <div className="log-card">
                <h1>Create Account</h1>
            </div>
            <form className="Form-acco" onSubmit={handleAccount}>
           
                <div className="Form-Login">
                    <label htmlFor="userName">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="userName"
                        name="userName"
                        placeholder="Enter username"
                        value={formData.userName}
                        onChange={handleInput}
                    />
                </div>

        
                <div className="Form-Login">
                    <label htmlFor="accountNumber">Account Number</label>
                    <input
                        type="number"
                        className="form-control"
                        id="accountNumber"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={formData.accountNumber}
                        onChange={handleInput}
                    />
                </div>

       
                <div className="Form-Login">
                    <label htmlFor="balance">Balance</label>
                    <input
                        type="number"
                        className="form-control"
                        id="balance"
                        name="balance"
                        placeholder="Enter balance"
                        value={formData.balance}
                        onChange={handleInput}
                    />
                </div>

                <div className="Form-Login">
                    <label htmlFor="bankName">Bank Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="bankName"
                        name="bankName"
                        placeholder="Enter bank name"
                        value={formData.bankName}
                        onChange={handleInput}
                    />
                </div>

                
                <div className="Form-Login">
                    <label htmlFor="location">Location</label>
                    <input
                        type="text"
                        className="form-control"
                        id="location"
                        name="location"
                        placeholder="Enter location"
                        value={formData.location}
                        onChange={handleInput}
                    />
                </div>

                <div className="Form-Login">
                    <label htmlFor="mobile">Mobile</label>
                    <input
                        type="number"
                        className="form-control"
                        id="mobile"
                        name="mobile"
                        placeholder="Enter mobile"
                        value={formData.mobile}
                        onChange={handleInput}
                    />
                </div>

            
                <div className="Form-Login">
                    <label htmlFor="ifsc">IFSC Code</label>
                    <input
                        type="text"
                        className="form-control"
                        id="ifsc"
                        name="ifsc"
                        placeholder="Enter IFSC code"
                        value={formData.ifsc}
                        onChange={handleInput}
                    />
                </div>

       
                <div className="Form-ac">
                    <button type="submit" className="btn-control">Create</button>
                </div>
                <a  id="links"href="/Login">Login Here</a>
            </form>
        </div>
    );
}

export default Account;
