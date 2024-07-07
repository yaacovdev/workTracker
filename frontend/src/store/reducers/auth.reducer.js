const initialState = {
    user: null,
    isAuthenticated: false,
    loading: false,
    error: null,
};

export default function authReducer(state = initialState, action) {
    switch (action.type) {
        case 'LOGIN_REQUEST':
            return {
                ...state,
                loading: true,
            };
        case 'LOGIN_SUCCESS':
            return {
                ...state,
                user: action.payload.user,
                isAuthenticated: true,
                loading: false,
            };
        case 'LOGIN_FAILURE':
            return {
                ...state,
                error: action.payload.errors,
                loading: false,
            };
        case 'LOGOUT':
            return {
                ...state,
                user: null,
                isAuthenticated: false,
            };
        default:
            return state;
    }
}