import { combineReducers } from "redux";
import authReducer from "./reducers/auth.reducer";
import { configureStore } from "@reduxjs/toolkit";
import dailyWorkReducer from "./reducers/dailyWork.reducer";


const rootReducer = combineReducers({
    auth: authReducer,
    dailyWork: dailyWorkReducer,
});

export default configureStore({
    reducer: rootReducer,
    devTools: process.env.NODE_ENV !== "production",
});
