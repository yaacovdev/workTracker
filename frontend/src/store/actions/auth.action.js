import axios from "axios";
import Cookies from "js-cookie";
import isValidToken from "../../utils/isValidToken";

export const login = (email, password) => {
    return async (dispatch) => {
        dispatch({ type: "LOGIN_REQUEST" });

        try {
            const { data } = await axios.post("/users/login", {
                email,
                password,
            });

            Cookies.set("accessToken", data.accessToken);
            Cookies.set("refreshToken", data.refreshToken);

            dispatch({
                type: "LOGIN_SUCCESS",
                payload: data,
            });
        } catch (error) {
            dispatch({
                type: "LOGIN_FAILURE",
                payload: error.response.data,
            });
        }
    };
};

export const relogin = (accessToken, refreshToken) => {
    return async (dispatch) => {
        dispatch({ type: "LOGIN_REQUEST" });

        try {
            const accessToken = Cookies.get("accessToken");
            const refreshToken = Cookies.get("refreshToken");

            if (isValidToken(accessToken)) {
                dispatch({
                    type: "LOGIN_SUCCESS",
                    payload: { accessToken, refreshToken },
                });
            } else {
                Cookies.remove("accessToken");
                Cookies.remove("refreshToken");
            }
        } catch (error) {
            dispatch({
                type: "LOGIN_FAILURE",
                payload: error.response.data,
            });
        }
    };
};

export const logout = () => {
    return (dispatch) => {
        dispatch({ type: "LOGOUT" });
        Cookies.remove("accessToken");
        Cookies.remove("refreshToken");
    };
};
