import { useState } from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import  {Redirect} from 'react-router-dom';

function Login() {
    const initialFormState = {
        userName: "",
        accountNumber: "",
        bankName: "",
        password: ""
    };

    const [formData, setFormData] = useState(initialFormState);
    const navigate = useNavigate();

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleResponse = (response) => {
        const { data } = response;
       

        if (data.message==="you succesfully login") {
            setFormData(initialFormState);
            // return<Redirect to="/Home"/>
            navigate('/Home');
           
        } else {
            alert(data.message);
            setFormData(initialFormState);
        }
    };

    const handleLogin = async (event) => {
        event.preventDefault();
        
       
        if (!formData.userName || !formData.password || !formData.accountNumber || !formData.bankName) {
            alert("Please provide all required fields.");
            return;
        }

        try {
            const response = await axios.post("http://localhost:8080/Bank/login", formData, {
                headers: {
                    "Content-Type": "application/json",
                },
            });

            handleResponse(response);
        } catch (error) {
            console.error("Error during login request:", error);

            if (error.response) {
                // Server responded with a status other than 2xx
                const status = error.response.status;
                const errorData = error.response.data;

                // Provide specific feedback based on the error status and data
                if (status === 401) {
                    alert("Unauthorized access. Please check your credentials.");
                } else {
                    alert(`Error ${status}: ${errorData.message || 'Unknown error'}`);
                }
            } else {
                alert("Network error: Please check your connection.");
            }
        }
    };

    return (
        <div className="container-Login">
            <div className="log-card">
                <h1>User Login Page</h1>
            </div>
            <form className="Form-logi" onSubmit={handleLogin}>
                <div className="Form-Login">
                    <label htmlFor="user">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="user"
                        name="userName"
                        placeholder="Enter username"
                        value={formData.userName}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="Form-Login">
                    <label htmlFor="userpassword">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="userpassword"
                        name="password"
                        placeholder="Enter password"
                        value={formData.password}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="Form-Login">
                    <label htmlFor="account">Account Number</label>
                    <input
                        type="number"
                        className="form-control"
                        id="account"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={formData.accountNumber}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="Form-Login">
                    <label htmlFor="bank">Bank Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="bank"
                        name="bankName"
                        placeholder="Enter bank name"
                        value={formData.bankName}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="Form-Log">
                    <button type="submit" className="btn-control">Log In</button>
                    <button type="button" className="btn-control" onClick={() => navigate("/Registration")}>
                        Sign Up
                    </button>
                </div>
            </form>
        </div>
    );
}

export default Login;
