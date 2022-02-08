import { useDispatch, useSelector } from "react-redux";
import { loadRestaurantBy } from "../store/restaurant-scheduler";
import RestaurantInfo from "./restaurant-info";
import SearchBar from "./search-bar";

const RestaurantScheduler = () => {
    const dispatch = useDispatch();
    const restaurants = useSelector((state) => state.list);

    const searchRestaurantSchedule = (restaurantName, queryParamName) => {
        dispatch(loadRestaurantBy(restaurantName, queryParamName));
    }

    return (
        <div>
            <SearchBar 
                searchRestaurantSchedule={searchRestaurantSchedule}>         
            </SearchBar>
            {
                restaurants instanceof Array ?
                restaurants.map((restaurant) => (
                    <RestaurantInfo restaurants={restaurant}></RestaurantInfo>
                )) :
                <RestaurantInfo restaurants={restaurants}></RestaurantInfo>

            }
        </div>
    );
};

export default RestaurantScheduler;
