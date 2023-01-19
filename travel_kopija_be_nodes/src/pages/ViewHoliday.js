import { useState, useEffect} from "react";
import { useParams} from "react-router-dom";
import { HolidayAgencyMover } from "../components/HolidayAgencyMover";

export function ViewHoliday(props){
const[holiday,setHoliday] = useState({});

const params = useParams();

useEffect(() => {
    fetch('/api/v1/holidays/' + params.id)
        .then((response) => response.json())
        .then(setHoliday)
}, [params.id]);

    return(
       <div>
        <div><b>ID</b></div>
        <div>{holiday.id}</div>
        
        <div><b>Name</b></div>
        <div>{holiday.name}</div>

        <div><b>Type</b></div>
        <div>{holiday.type}</div>

        <div><b>Description</b></div>
        <div>{holiday.description}</div>

        <HolidayAgencyMover 
            id={params.id} 
            onHolidayChange={setHoliday}
            />
       </div> 
    )
}