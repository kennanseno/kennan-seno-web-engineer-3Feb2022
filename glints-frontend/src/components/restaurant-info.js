const RestaurantInfo = (props) => {
  return (
    <div className="restaurant-info-container">
      <h5>{props.restaurants.name}</h5>
      <Schedule schedules={props.restaurants.schedules}></Schedule>
    </div>
  );
};

const Schedule = (props) => {
  const getScheduleOpenDays = (schedule) => {
    let scheduledDays = "";
    const days = [
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday",
      "Sunday",
    ];

    const openDays = [];
    days.forEach((day) => {
      if (schedule[day.toLocaleLowerCase()]) {
        openDays.push(day);
      }
    });

    openDays.forEach((openDay, index) => {
      scheduledDays += openDay;
      if (openDays.length > 1 && index < openDays.length - 1) {
        scheduledDays += ", ";
      }
    });
    return scheduledDays;
  };

  return (
    <div className="schedule-container">
      {props.schedules?.map((schedule) => (
        <div key={schedule.id}>
          <p>
            {getScheduleOpenDays(schedule)}
            <br />
            {schedule.openingTime} - {schedule.closingTime}
          </p>
        </div>
      ))}
    </div>
  );
};

export default RestaurantInfo;
