import { useDispatch } from "react-redux";
import { useRoutes } from "react-router-dom";
import { useEffect } from "react";
import Cookies from "js-cookie";
import { relogin } from "./store/actions/auth.action";

// import router from "./router";
import Navbar from "./components/navbar";
import { routes } from "./router/index";

function App() {
    const dispatch = useDispatch();
    const routing = useRoutes(routes);

    useEffect(() => {
        const accessToken = Cookies.get("accessToken");
        const refreshToken = Cookies.get("refreshToken");

        if (accessToken && refreshToken) {
            dispatch(relogin(accessToken, refreshToken));
        }
    }, [dispatch]);
    return (
        <div className="App">
            <Navbar />
            {routing}
        </div>
    );
}

export default App;
