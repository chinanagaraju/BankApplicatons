import React from "react";
import { useNavigate } from "react-router-dom";

function Home() {
    const navigate = useNavigate();
    
    return (
        <div className="container-home">
            <form className="form-home">
                <h2>Welcome to the Bank</h2>
                <h3>Select an operation to perform</h3>
                <div className="button-group">
                    <button
                        type="button"
                        className="btn-home"
                        onClick={() => navigate("/Withdraw")}
                    >
                        Withdraw
                    </button>
                    <button
                        type="button"
                        className="btn-home"
                        onClick={() => navigate("/Deposit")}
                    >
                        Deposit
                    </button>
                    <button
                        type="button"
                        className="btn-home"
                        onClick={() => navigate("/Account")}
                    >
                        Account
                    </button>
                    
                    <button
                        type="button"
                        className="btn-home"
                        onClick={() => navigate("/Transfer")}
                    >
                       Transfer
                    </button>
                </div>
            </form>
        </div>
    );
}

export default Home;
