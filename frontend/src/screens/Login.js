import { useState } from "react";
import store from "../store";
import { login } from "../store/actions/auth.action";
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    const handleSubmit = async (event) => {
        event.preventDefault();
        store.dispatch(login(email, password));
        navigate("/dashboard");
    };
    return (
        <div className="container  mx-auto p-4">
            <form
                className="form"
                method="post"
                action="/login"
                onSubmit={handleSubmit}
            >
                <h1 className="text-2xl font-bold mb-4">Login</h1>
                <div className="form-group space-y-4">
                    <label
                        htmlFor="email"
                        className="block text-sm font-medium text-gray-700"
                    >
                        Email
                    </label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        onChange={(e) => setEmail(e.target.value)}
                        className="form-control block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        placeholder="Enter email"
                        required
                    />

                    <label
                        htmlFor="password"
                        className="block text-sm font-medium text-gray-700"
                    >
                        Password
                    </label>

                    <input
                        type="password"
                        id="password"
                        name="password"
                        onChange={(e) => setPassword(e.target.value)}
                        className="form-control block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        placeholder="Enter password"
                        required
                    />

                    <button
                        type="submit"
                        className="btn btn-primary bg-cyan-500 text-white px-4 py-2 rounded-md shadow-sm hover:bg-cyan-600"
                    >
                        Login
                    </button>
                </div>
            </form>
        </div>
    );
}
