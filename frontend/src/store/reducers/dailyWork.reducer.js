const initsialState = {
    dailyWork: [],
};

export default function dailyWorkReducer(state = initsialState, action) {
    switch (action.type) {
        case 'GET_DAILY_WORK':
            return {
                ...state,
                dailyWork: action.payload,
            };
        default:
            return state;
    }
};
