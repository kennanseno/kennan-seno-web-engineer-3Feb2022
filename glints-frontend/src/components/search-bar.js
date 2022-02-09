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
        
        // Set default value on query change
        if (event.target.value === 'name') setInputValue('')
        if (event.target.value === 'time') setInputValue('11:30 AM')
    }
    
    return (
        <div>
            <SearchInput value={inputValue} queryName={selectValue} handleInputChange={handleInputChange}></SearchInput>
            <select value={selectValue} onChange={handleSelectChange}>
                <option value="name">Name</option>
                <option value="time">Opening Time</option>
            </select>
            <button className="search-button" onClick={() => { props.searchRestaurantSchedule(inputValue, queryName[selectValue]) }}>Search</button>
        </div>
    )
}

const SearchInput = (props) => {
    return (
        props.queryName === 'name' ? 
            <input type="text" value={props.value} onChange={props.handleInputChange}></input> :
            <select value={props.value} onChange={props.handleInputChange}>
                <option value="11 AM">11 AM</option>
                <option value="11:30 AM">11:30 AM</option>
            </select>
        )
}

export default SearchBar;