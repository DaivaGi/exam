import { useEffect, useState } from "react";

export function HolidayAgencyMover(props) {
    const [agencies, setAgencies] = useState([]);
    const [selectedAgency, setSelectedAgency] = useState('');

    useEffect(() => {
        fetch('/api/v1/agencies')
            .then(response => response.json())
            .then(setAgencies);
    }, []);

    const assignHolidayToAgency = () => {
        fetch(`/api/v1/holidays/${props.id}/addagency?holidayId=${selectedAgency}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then((holiday) => props.onHolidayChange(holiday));
    };

    return (<div>
        <select value={selectedAgency} onChange={(e) => setSelectedAgency(e.target.value)}>
            <option value=''>---</option>
            {
                agencies.map(
                    (agency) => (<option key={agency.id} value={agency.id}>{agency.name}</option>)
                )
            }
        </select>
        <button onClick={assignHolidayToAgency}>Assign</button>
    </div>);
}