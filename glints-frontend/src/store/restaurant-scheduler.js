import { createSlice } from "@reduxjs/toolkit";
import { apiCallBegan } from "./api";

const slice = createSlice({
  name: "restaurants",
  initialState: {
    list: [],
    loading: false,
  },
  reducers: {
    restaurantInfoRequested: (restaurants, action) => {
      restaurants.loading = true;
    },

    restaurantInfoReceived: (restaurants, action) => {
      restaurants.list = action.payload;
      restaurants.loading = false;
    },

    restaurantInfoRequestFailed: (restaurants, action) => {
      restaurants.loading = false;
    },
  },
});

export default slice.reducer;

const {
  restaurantInfoRequested,
  restaurantInfoReceived,
  restaurantInfoRequestFailed,
} = slice.actions;
const path = "/restaurant";

export const loadRestaurantBy = (queryValue, queryParamName) => (dispatch) => {
  const url = path + `/search?${queryParamName}=${queryValue}`;
  const action = {
    url,
    onStart: restaurantInfoRequested.type,
    onSuccess: restaurantInfoReceived.type,
    onError: restaurantInfoRequestFailed.type,
  };

  return dispatch(apiCallBegan(action));
};
