import {useParams} from "react-router-dom";
import { useState, useEffect } from "react";
import { HOLIDAY_TYPES } from "../commons/constants";

export function UpdateHolidayPage(){

    const params = useParams();
    const [error, setError] = useState();

    const [holiday, setHoliday] = useState({
        name: "",
        type: "",
        destination: "",
    });

    useEffect(() => {
        fetch('/api/v1/holidays/' + params.id)
        .then(response => response.json())
        .then(setHoliday);
}, []);


const updateHoliday = () => {
    fetch("/api/v1/holidays/" + params.id, {
        method: "PATCH",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(holiday)
    }).then(result => {
        if (!result.ok) {
            setError('Update failed');
        } else {
            setError();
        }
    });
};


    const updateProperty = (property, event) => {
        setHoliday({
            ...holiday,
            [property]: event.target.value
        });
    };


    return(
        <div>
            <h3>Update Holiday</h3>

            <fieldset>
                <legend>{params.id}</legend>

                {error && (<div className='error'>{error}</div>)}

                <label>Name</label>
                <input value={holiday.name} onChange={(e) => updateProperty('name', e)}></input>

                <label>Type</label>
                <select value={holiday.type} onChange={(e) => updateProperty('type', e)}>
                {Object.entries(HOLIDAY_TYPES)
                    .map(([key, value]) => <option key={key} value={key}>{value}</option>)}
                </select>

                <label>Destination</label>
                <input value={holiday.destination} onChange={(e) => updateProperty('destination', e)}></input>

                <button onClick={updateHoliday}>Update</button>
            </fieldset>

        </div>
    )
}