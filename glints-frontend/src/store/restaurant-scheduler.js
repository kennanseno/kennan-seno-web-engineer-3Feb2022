import { createSlice } from "@reduxjs/toolkit";
import { apiCallBegan } from "./api";

const slice = createSlice({
    name: "restaurants",
    initialState: {
        list: [],
        loading: false,
    },
    reducers: {
        restaurantInfoRequested: (posts, action) => {
            posts.loading = true;
        },

        restaurantInfoReceived: (posts, action) => {
            posts.list = action.payload;
            posts.loading = false;
        },

        restaurantInfoRequestFailed: (posts, action) => {
            posts.loading = false;
        },
    },
});

export default slice.reducer;

const { restaurantInfoRequested, restaurantInfoReceived, restaurantInfoRequestFailed } = slice.actions;
const path = "/restaurant";

export const loadRestaurantBy = (queryValue, queryParamName) => (dispatch) => {
    const url = path +`/search?${queryParamName}=${queryValue}`;
    const action = {
        url,
        onStart: restaurantInfoRequested.type,
        onSuccess: restaurantInfoReceived.type,
        onError: restaurantInfoRequestFailed.type,
    }

    return dispatch(
        apiCallBegan(action)
    );
};
