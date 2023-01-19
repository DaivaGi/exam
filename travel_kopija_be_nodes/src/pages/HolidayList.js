import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function HolidayListPage() {
  const [holidays, setHolidays] = useState([]);

  const fetchHolidays = async () => {
    fetch("/api/v1/holidays")
      .then((response) => response.json())
      .then((jsonResponse) => setHolidays(jsonResponse));
  };

  useEffect(() => {
    fetchHolidays();
  }, []);

  const removeHoliday = (id) => {
    fetch("/api/v1/holidays/" + id, {
      method: "DELETE",
      headers: JSON_HEADERS,
    }).then(fetchHolidays);
  };

  return (
    <div>
      <h3>Holiday List</h3>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Pavadinimas</th>
            <th>Tipas</th>
            <th>Kryptis</th>
          </tr>
        </thead>
        <tbody>
          {holidays.map((holiday) => (
            <tr key={holiday.id}>
              <td>
                <Link to={"/holiday/view/" + holiday.id}>{holiday.id}</Link>
              </td>
              <td>{holiday.name}</td>
              <td>{holiday.type}</td>
              <td>
                <button onClick={() => removeHoliday(holiday.id)}>
                  Remove
                </button>
                <Link to={"/holidays/update/" + holiday.id}>
                  <button>Update</button>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
