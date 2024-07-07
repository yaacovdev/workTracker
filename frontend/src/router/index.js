import Home from "../screens/Home";
import About from "../screens/About";
import Login from "../screens/Login";
import Register from "../screens/Register";
import Dashboard from "../screens/Dashboard";

export const routes = [
    {
        path: "/",
        element: <Home />,
    },
    {
        path: "/about",
        element: <About />,
    },
    {
        path: "/login",
        element: <Login />,
    },
    {
        path: "/register",
        element: <Register />,
    },
    {
        path: "/dashboard",
        element: <Dashboard />,
    },
    {
        path: "*",
        element: <h1>Not Found</h1>,
    },
];
