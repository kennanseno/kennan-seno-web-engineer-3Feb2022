import { Provider } from "react-redux";
import configureStore from "./store/configureStore";
import Posts from "./components/restaurant-scheduler";
import "./App.css";

const store = configureStore();

 const App = () => {
    return (
        <Provider store={store}>
            <Posts />
        </Provider>
    );
}

export default App;
