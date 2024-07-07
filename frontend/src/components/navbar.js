// src/components/Navbar.js
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
import { logout } from "../store/actions/auth.action";

import store from "../store";

const Navbar = () => {
    const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);

    const handleLogout = () => {
        store.dispatch(logout());
    };

    return (
        <nav className="bg-cyan-500 p-4">
            <ul className="flex space-x-4">
                <li>
                    <Link to="/" className="text-white">
                        Home
                    </Link>
                </li>
                <li>
                    <Link to="/about" className="text-white">
                        About
                    </Link>
                </li>
                {isAuthenticated && (
                    <li>
                        <Link to="/dashboard" className="text-white">
                            Dashboard
                        </Link>
                    </li>
                )}
                {isAuthenticated && (
                    <li>
                        <Link
                            to="/"
                            className="text-white"
                            onClick={handleLogout}
                        >
                            Logout
                        </Link>
                    </li>
                )}
                {!isAuthenticated && (
                    <li>
                        <Link to="/login" className="text-white">
                            Login
                        </Link>
                    </li>
                )}
                {!isAuthenticated && (
                    <li>
                        <Link to="/register" className="text-white">
                            Register
                        </Link>
                    </li>
                )}
            </ul>
        </nav>
    );
};

export default Navbar;
