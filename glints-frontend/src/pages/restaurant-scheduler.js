import { useDispatch, useSelector } from "react-redux";
import { loadRestaurantBy } from "../store/restaurant-scheduler";
import RestaurantInfo from "../components/restaurant-info";
import SearchBar from "../components/search-bar";
import { nanoid } from "@reduxjs/toolkit";

const RestaurantScheduler = () => {
    const dispatch = useDispatch();
    const restaurants = useSelector((state) => state.list);

    const searchRestaurantSchedule = (restaurantName, queryParamName) => {
        dispatch(loadRestaurantBy(restaurantName, queryParamName));
    }

    return (
        <div>
            <SearchBar searchRestaurantSchedule={searchRestaurantSchedule}></SearchBar>
            {
                restaurants.length === 0 || !restaurants ?
                <h1> No restaurant found for that search.</h1> :
                <div>
                    <h1>Schedule</h1>
                    {
                    restaurants instanceof Array ?
                    restaurants.map((restaurant) => (
                        <RestaurantInfo key={nanoid()} restaurants={restaurant}></RestaurantInfo>
                    )) :
                    <RestaurantInfo restaurants={restaurants}></RestaurantInfo>
                }
                </div>
}
        </div>
    );
};

export default RestaurantScheduler;
