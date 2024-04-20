import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Transfer() {
    const initialWithdrawState = {
        userName: '',
        accountNumber: '',
        withdraw: '',
        bankName: '',
        ifsc: ''
    };
    
    const initialDepositState = {
        userName: '',
        accountNumber: '',
        balance: '',
        bankName: '',
        ifsc: ''
    };
    
    const [withdraw, setWithdraw] = useState(initialWithdrawState);
    const [deposit, setDeposit] = useState(initialDepositState);
    const navigate = useNavigate();

    const handleWithdrawChange = (event) => {
        const { name, value } = event.target;
        setWithdraw({
            ...withdraw,
            [name]: value,
        });
    };

    const handleDepositChange = (event) => {
        const { name, value } = event.target;
        setDeposit({
            ...deposit,
            [name]: value,
        });
    };

    const handleTransfer = async (event) => {
        event.preventDefault();

        // Combine withdrawal and deposit data
        const requestData = {
            withdrawOperationDto: withdraw,
            accountDto: deposit
        };

        try {
            const response = await axios.put(
                'http://localhost:8080/Bank/transfer',
                requestData,
                {
                    headers: {
                        'Content-Type': 'application/json',
                    }
                }
            );
            handleResponse(response);
        } catch (error) {
            console.error('Error:', error);
            alert('Failed to process the transfer request. Please try again.');
        }
    };

    const handleResponse = (response) => {
        if (response.data.message) {
            alert(response.data.message);
            setWithdraw(initialWithdrawState);
            setDeposit(initialDepositState);
            navigate('/Home');
        } else {
            alert(response.data.message);
            console.log(response.data.message);
        }
    };

    return (
        <div className="container-transfer">
            <div className="log-card">
                <h1>Account to Account Transfer Page</h1>
            </div>
            <form className="Form-logi" onSubmit={handleTransfer}>
                {/* Withdrawal Section */}
            <div>
                <div className="Form-Login">
                    <h2>Withdrawal(from Account)</h2>
                    <label htmlFor="userName">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="userName"
                        name="userName"
                        placeholder="Enter username"
                        value={withdraw.userName}
                        onChange={handleWithdrawChange}
                    />
                    <label htmlFor="accountNumber">Account Number</label>
                    <input
                        type="number"
                        className="form-control"
                        id="accountNumber"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={withdraw.accountNumber}
                        onChange={handleWithdrawChange}
                    />
                    <label htmlFor="withdraw">Withdraw Amount</label>
                    <input
                        type="number"
                        className="form-control"
                        id="withdraw"
                        name="withdraw"
                        placeholder="Enter amount"
                        value={withdraw.withdraw}
                        onChange={handleWithdrawChange}
                    />
                    <label htmlFor="bankName">Bank Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="bankName"
                        name="bankName"
                        placeholder="Enter bank name"
                        value={withdraw.bankName}
                        onChange={handleWithdrawChange}
                    />
                    <label htmlFor="ifsc">IFSC Code</label>
                    <input
                        type="text"
                        className="form-control"
                        id="ifsc"
                        name="ifsc"
                        placeholder="Enter IFSC code"
                        value={withdraw.ifsc}
                        onChange={handleWithdrawChange}
                    />
                </div>
                </div>
                <div>
                <div className="Form-Login">
                    <h2>Deposit (To account)</h2>
                    <label htmlFor="userName">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="userName"
                        name="userName"
                        placeholder="Enter username"
                        value={deposit.userName}
                        onChange={handleDepositChange}
                    />
                    <label htmlFor="accountNumber">Account Number</label>
                    <input
                        type="number"
                        className="form-control"
                        id="accountNumber"
                        name="accountNumber"
                        placeholder="Enter account number"
                        value={deposit.accountNumber}
                        onChange={handleDepositChange}
                    />
                    <label htmlFor="bankName">Bank Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="bankName"
                        name="bankName"
                        placeholder="Enter bank name"
                        value={deposit.bankName}
                        onChange={handleDepositChange}
                    />
                    <label htmlFor="ifsc">IFSC Code</label>
                    <input
                        type="text"
                        className="form-control"
                        id="ifsc"
                        name="ifsc"
                        placeholder="Enter IFSC code"
                        value={deposit.ifsc}
                        onChange={handleDepositChange}
                    />
                </div>
                </div>
                
            
                                {/* Submit Button */}
                <div className="Form-Log">
                    <button type="submit" className="btn-control">Transfer</button>
                </div>
            </form>

           
        </div>
    );
}

export default Transfer;
