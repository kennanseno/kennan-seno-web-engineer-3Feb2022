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
  };

  return (
    <div className="container restaurant-scheduler">
      <SearchBar
        searchRestaurantSchedule={searchRestaurantSchedule}
      ></SearchBar>
      <div className="restaurant-info">
        {restaurants.length === 0 || !restaurants ? (
          <h1 className="no-result">No restaurant found for that search.</h1>
        ) : (
          <div>
            <h1>Schedule</h1>
            {restaurants instanceof Array ? (
              restaurants.map((restaurant) => (
                <RestaurantInfo
                  key={nanoid()}
                  restaurants={restaurant}
                ></RestaurantInfo>
              ))
            ) : (
              <RestaurantInfo restaurants={restaurants}></RestaurantInfo>
            )}
          </div>
        )}
      </div>
    </div>
  );
};

export default RestaurantScheduler;
