import { useState } from "react";

const SearchBar = (props) => {
    const queryName = {
        name: 'name',
        time: 'openingTime'
    }

    const [inputValue, setInputValue] = useState('');
    const [selectValue, setSelectValue] = useState(queryName['name']);

    const handleInputChange = (event) => {
        setInputValue(event.target.value);
    }

    const handleSelectChange = (event) => {
        setSelectValue(event.target.value);
    }
    
    return (
        <div>
            <input type="text" value={inputValue} onChange={handleInputChange}></input>
            <select value={selectValue} onChange={handleSelectChange}>
                <option value="name">Name</option>
                <option value="time">Opening Time</option>
            </select>
            <button onClick={() => { props.searchRestaurantSchedule(inputValue, queryName[selectValue]) }}>Search</button>
        </div>
    )
}

export default SearchBar;