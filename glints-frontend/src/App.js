import { Provider } from "react-redux";
import configureStore from "./store/configureStore";
import "./App.css";
import RestaurantScheduler from "./pages/restaurant-scheduler";

const store = configureStore();

 const App = () => {
    return (
        <Provider store={store}>
            <RestaurantScheduler />
        </Provider>
    );
}

export default App;
