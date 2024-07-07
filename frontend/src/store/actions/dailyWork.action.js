import axios from 'axios';

export const getDailyWork = () => {
    return async (dispatch) => {
        try {
            const { data } = await axios.get('/work/daily/all');
            dispatch({
                type: 'GET_DAILY_WORK',
                payload: data,
            });
        } catch (error) {
            console.log(error);
        }
    };
}