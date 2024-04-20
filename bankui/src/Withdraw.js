import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Withdraw() {
    const initialState = {
        userName: '',
        accountNumber: '',
        bankName: '',
        ifsc: '',
        withdraw: '',
    };

    const [formData, setFormData] = useState(initialState);
    const navigate = useNavigate();

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleResponse = async (response) => {
        
    
        if (response.data.message) {
          alert(response.data.message);
            setFormData(initialState);
            navigate('/Home'); 
        } else {
          
            console.error("Unexpected response message:", response.data.message);
            alert(response.data.message);
            setFormData(initialState);
        }
    };
    

    const handleWithdraw = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.put(
                "http://localhost:8080/Bank/withdraw",
                formData,
                {
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );
            await handleResponse(response);
        } catch (error) {
            alert("Failed to process the request. Please try again.");
            console.error("Error processing request:", error);
        }
    };

    return (
        <div className="container-withdraw" id="withdraw">
            <div className="log-card">
                <h1>Withdraw Page</h1>
            </div>
            <form className="Form-logi" onSubmit={handleWithdraw}>
                <div className="Form-Login">
                    <label htmlFor="userName">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="userName"
                        name="userName"
                        placeholder="Enter username"
                        value={formData.userName}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="Form-Login">
                    <label htmlFor="accountNumber">Account</label>
                    <input
                        type="number"
                        className="form-control"
                        id="accountNumber"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={formData.accountNumber}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="Form-Login">
                    <label htmlFor="withdraw">Withdraw</label>
                    <input
                        type="number"
                        className="form-control"
                        id="withdraw"
                        name="withdraw"
                        placeholder="Enter amount"
                        value={formData.withdraw}
                        onChange={handleInputChange}
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
                        onChange={handleInputChange}
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
                        onChange={handleInputChange}
                    />
                </div>
                <div className="Form-Log">
                    <button type="submit" className="btn-control">Withdraw</button>
                </div>
            </form>
        </div>
    );
}

export default Withdraw;
