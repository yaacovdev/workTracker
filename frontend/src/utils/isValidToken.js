export default function isValidToken(token) {
    if (!token) {
        return false;
    }

    try {
        const decodedToken = decodeToken(token);
        if (!decodedToken || !decodedToken.exp) {
            return false;
        }

        const tokenExpiration = decodedToken.exp;
        const currentTimestamp = Math.floor(Date.now() / 1000);

        return tokenExpiration > currentTimestamp;
    } catch (error) {
        console.error("Error decoding token:", error);
        return false;
    }
}

const decodeToken = (token) => {
    try {
        return JSON.parse(atob(token.split(".")[1]));
    } catch (error) {
        console.error("Error decoding token:", error);
        return null;
    }
};
