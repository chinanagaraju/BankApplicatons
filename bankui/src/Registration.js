import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function Registration() {

    const initialState = {
        userName: '',
        accountNumber: '',
        password: '',
        bankName: '',
        ifsc:'',
    };


    const [formData, setFormData] = useState(initialState);
    const [errors, setErrors] = useState({});
    

    const navigate = useNavigate();


    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

  
    const validateForm = () => {
        const newErrors = {};
        if (!formData.userName.trim()) newErrors.userName = 'Username is required.';
        if (!formData.accountNumber.trim()) newErrors.accountNumber = 'Account Number is required.';
        if (!formData.password) newErrors.password = 'Password is required.';
        if (!formData.bankName.trim()) newErrors.bankName = 'Bank Name is required.';
        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleResponse=(response)=>{
            if(response.data.message==="User profile successfully created."){
                alert(response.data.message);
                setFormData(initialState);
                navigate('/Login');
            }else{
                alert(response.data.message);
            }
     };
    const handleUser = async (event) => {
        event.preventDefault();

  
        if (!validateForm()) return;

        try {
           
            const response = await axios.post("http://localhost:8080/Bank/user", formData, {
                headers: {
                    "Content-Type": "application/json",
                },
            });

           
            handleResponse(response);
        } catch (error) {
         
            console.error("Registration error:", error);
            alert("An error occurred during registration. Please try again.");
        }
    };

    return (
        <div className="container1">
            <div className="log-card">
                <h1>User Registration Page</h1>
            </div>
            <form className="Form-id" onSubmit={handleUser}>
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
                        required
                    />
                    {errors.userName && <span className="error">{errors.userName}</span>}
                </div>
                <div className="Form-Login">
                    <label htmlFor="accountNumber">Account Number</label>
                    <input
                        type="text"
                        className="form-control"
                        id="accountNumber"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={formData.accountNumber}
                        onChange={handleInputChange}
                        required
                    />
                    {errors.accountNumber && <span className="error">{errors.accountNumber}</span>}
                </div>
                <div className="Form-Login">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        placeholder="Enter password"
                        value={formData.password}
                        onChange={handleInputChange}
                        required
                    />
                    {errors.password && <span className="error">{errors.password}</span>}
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
                        required
                    />
                    {errors.bankName && <span className="error">{errors.bankName}</span>}
                </div> <div className="Form-Login">
                    <label htmlFor="ifsc">Ifsc</label>
                    <input
                        type="text"
                        className="form-control"
                        id="ifsc"
                        name="ifsc"
                        placeholder="Enter password"
                        value={formData.ifsc}
                        onChange={handleInputChange}
                        required
                    />
                    {errors.ifsc && <span className="error">{errors.ifsc}</span>}
                </div>
                <div className="Form-Log">
                    <button type="submit" className="btn-control">Sign Up</button>
                    <button type="button" className="btn-control" onClick={() => navigate("/Login")}>
                        Login
                    </button>
                </div>
                <a href="/Account" className="link">Create Account</a>
            </form>
        </div>
    );
}

export default Registration;
