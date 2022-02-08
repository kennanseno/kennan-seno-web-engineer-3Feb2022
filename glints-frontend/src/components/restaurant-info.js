const RestaurantInfo = (props) => {
    return (
         <div>
            Restaurant name: {props.restaurants.name}
            <Schedule schedules={props.restaurants.schedules}></Schedule>
        </div>
    )
}

const Schedule = (props) => {
    return (
        <div>
            {props.schedules?.map((schedule) => (
                <div key={schedule.id}>
                    Opening time: {schedule.openingTime}
                    <br/>
                    Closing time: {schedule.closingTime}
                </div>
            ))}
        </div>
    )
}

export default RestaurantInfo;