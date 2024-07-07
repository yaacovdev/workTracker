import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Register() {
    const navigate = useNavigate();
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [company, setCompany] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const handleSubmit = async (event) => {
        event.preventDefault();
        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }
        await axios
            .post("/users/register", {
                username: name,
                email,
                company,
                password,
                confirmPassword,
            })
            .then((response) => {
                navigate("/login");
            })
            .catch((error) => {
                console.error(error);
            });
    };
    return (
        <div className="container mx-auto p-4">
            <form
                method="post"
                action="/register"
                className="form"
                onSubmit={handleSubmit}
            >
                <h1 className="text-2xl font-bold mb-4">Register</h1>
                <div className="form-group space-y-4">
                    <label
                        htmlFor="name"
                        className="block text-sm font-medium text-gray-700"
                    >
                        Name
                    </label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        onChange={(e) => setName(e.target.value)}
                        className="form-control block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        placeholder="Enter name"
                        required
                    />

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
                        htmlFor="company"
                        className="block text-sm font-medium text-gray-700"
                    >
                        Company
                    </label>
                    <input
                        type="text"
                        id="company"
                        name="company"
                        onChange={(e) => setCompany(e.target.value)}
                        className="form-control block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        placeholder="Enter company"
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

                    <label
                        htmlFor="confirmPassword"
                        className="block text-sm font-medium text-gray-700"
                    >
                        Confirm Password
                    </label>
                    <input
                        type="password"
                        id="confirmPassword"
                        name="confirmPassword"
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        className="form-control block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        placeholder="Confirm password"
                        required
                    />

                    <button
                        type="submit"
                        className="btn btn-primary bg-cyan-500 text-white px-4 py-2 rounded-md shadow-sm hover:bg-cyan-600"
                    >
                        Register
                    </button>
                </div>
            </form>
        </div>
    );
}
