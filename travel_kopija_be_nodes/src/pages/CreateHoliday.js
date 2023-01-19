import { useState, useEffect } from "react";
import { useHref } from "react-router-dom";
import { HOLIDAY_TYPES } from "../commons/constants";

export function CreateHolidayPage(props) {
  const [name, setName] = useState("");
  const [type, setType] = useState("CRUISE");
  const [destination, setDestination] = useState("");

  const listUrl = useHref("/");

  const clear = () => {
    setName("");
    setType("CRUISE");
    setDestination("");
  };

  const applyResult = (result) => {
    if (result.ok) {
      clear();
    } else {
      window.alert("Nepavyko sukurti:" + result.status);
    }
  };

  const createHoliday = () => {
    fetch(
      "api/v1/holidays", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name,
        type,
        destination,
      })
    })
      .then(applyResult)
      .then(() => window.location = listUrl);
  };

  // useEffect(() => {
  //   if(name === ""){
  //     document.getElementById("name").style.background = "red";
  //   } else {
  //     document.getElementById("name").style.background = "green";
  //   }
  // });

  return (
    <fieldset id="create">
      <legend>Create New Holiday</legend>

      <div>
        <label htmlFor="name">Name</label>
        <input id="name" value={name} onChange={(e) => setName(e.target.value)}/>
      </div>
      <div>
        <label htmlFor="type">Type</label>
        <select value={type} onChange={(e) => setType(e.target.value)}>
          {Object.entries(HOLIDAY_TYPES).map(([key, value]) => 
            <option value={key}>{value}</option>
          )}
        </select>
      </div>

      <div>
        <label htmlFor="destination">Destination</label>
        <textarea
          id="destination"
          value={destination} onChange={(e) => setDestination(e.target.value)}
        />
      </div>

      <div>
        <button onClick={createHoliday}>Create</button>
      </div>
    </fieldset>
  );
}
