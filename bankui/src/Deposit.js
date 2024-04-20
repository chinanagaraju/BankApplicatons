import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Deposit() {
    const initialFormData = {
        userName: '',
        accountNumber: '',
        balance: '',
        bankName: '',
        ifsc: '',
    };

    const [formData, setFormData] = useState(initialFormData);
    const navigate = useNavigate();

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    async function handleResponse(response) {
        const { message } = response.data;
        
        if (message === "Balance updated successfully") {
            alert(message);
            setFormData(initialFormData);
            navigate('/Home');
        } else {
            alert(message);
        }
    }

    async function handleDeposit(event) {
        event.preventDefault(); 

        try {
            const response = await axios.put(
                "http://localhost:8080/Bank/Deposit",
                formData,
                {
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );
            handleResponse(response);
        } catch (error) {
            alert("Failed to process the request. Please try again.");
            console.error(error);
        }
    }

    return (
        <div className="container-Deposit" id="deposit">
            <div className="log-card">
                <h1>Deposit Page</h1>
            </div>
            <form className="Form-Login" onSubmit={handleDeposit}>
                <div className="form-login">
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
                <div className="form-login">
                    <label htmlFor="accountNumber">Account Number</label>
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
                <div className="form-login">
                    <label htmlFor="balance">Balance</label>
                    <input
                        type="number"
                        className="form-control"
                        id="balance"
                        name="balance"
                        placeholder="Enter balance"
                        value={formData.balance}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-login">
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
                <div className="form-login">
                    <label htmlFor="ifsc">IFSC</label>
                    <input
                        type="text"
                        className="form-control"
                        id="ifsc"
                        name="ifsc"
                        placeholder="Enter IFSC"
                        value={formData.ifsc}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-log">
                    <button type="submit" className="btn-control">Deposit</button>
                </div>
            </form>
        </div>
    );
}

export default Deposit;
