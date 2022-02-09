import { useState } from "react";

const SearchBar = (props) => {
  const queryName = {
    name: "name",
    time: "openingTime",
  };

  const [inputValue, setInputValue] = useState("");
  const [selectValue, setSelectValue] = useState(queryName["name"]);

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleSelectChange = (event) => {
    setSelectValue(event.target.value);

    // Set default value on query type change
    if (event.target.value === "name") setInputValue("");
    if (event.target.value === "time") setInputValue("11:30 AM");
  };

  return (
    <div className="row justify-content-md-center">
      <div className="col-lg-3 col-sm-12">
        <select
          class="form-select form-select-lg mb-3"
          aria-label=".form-select-lg example"
          value={selectValue}
          onChange={handleSelectChange}
        >
          <option value="name">Name</option>
          <option value="time">Opening Time</option>
        </select>
      </div>
      <div className="col-lg-7 col-sm-12">
        <SearchInput
          value={inputValue}
          queryName={selectValue}
          handleInputChange={handleInputChange}
        ></SearchInput>
      </div>
      <div className="col-lg-2 col-sm-12">
        <button
          type="button"
          className="search-btn btn btn-primary"
          disabled={inputValue === ""}
          onClick={() => {
            props.searchRestaurantSchedule(inputValue, queryName[selectValue]);
          }}
        >
          Search
        </button>
      </div>
    </div>
  );
};

const SearchInput = (props) => {
  return props.queryName === "name" ? (
    <div class="input-group flex-nowrap">
      <input
        value={props.value}
        onChange={props.handleInputChange}
        type="text"
        class="form-control search-input"
        placeholder="Resturant Name"
        aria-label="Username"
        aria-describedby="addon-wrapping"
      ></input>
    </div>
  ) : (
    <select
      class="form-select form-select-lg mb-3"
      aria-label=".form-select-lg example"
      value={props.value}
      onChange={props.handleInputChange}
    >
      <option value="11 AM">11 AM</option>
      <option value="11:30 AM">11:30 AM</option>
    </select>
  );
};

export default SearchBar;
