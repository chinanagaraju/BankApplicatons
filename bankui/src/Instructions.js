import React from 'react';
import { useNavigate } from 'react-router-dom';

function Instructions() {
    const navigate=useNavigate();
    return (
        <div className='containers'>
            <h2>Instructions</h2>
            <ol>
                <li>Create an account.</li>
                <li>
                    Complete the registration process to create a user profile and set a password.
                </li>
                <li>Log in to your account using your username and password.</li>
                <li>
                    Ensure your login credentials match exactly to proceed.
                </li>
                <li>
                    Once logged in, you will be directed to the home page.
                    From here, you can select the operation you want to perform.
                </li>
                <li>Provide the necessary details for each operation as required.</li>
            </ol>
            <button type='button' onClick={()=>navigate('/Account')}>NEXT</button>
        </div>
    );
}

export default Instructions;
