import TimeSelect from "./time-select";

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
    <TimeSelect
      value={props.value}
      handleInputChange={props.handleInputChange}
    ></TimeSelect>
  );
};

export default SearchInput;
