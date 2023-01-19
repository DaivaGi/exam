import { HashRouter, Route, Routes } from 'react-router-dom';
import { Menu } from './components/Menu';
import {CreateHolidayPage} from "./pages/CreateHoliday";
import { HolidayListPage} from "./pages/HolidayList";
import { ViewHoliday } from './pages/ViewHoliday';
import { UpdateHolidayPage } from './pages/UpdateHoliday';
import './App.css';

function App() {
  return (
    <div className="App">
      <h2>Travel Agency</h2>
    <HashRouter>
      <Menu />
      <Routes>
        <Route path="/" element={<HolidayListPage />} />
        <Route path="/create" element={<CreateHolidayPage/>}/>
        <Route path='/holidays/view/:id' element={<ViewHoliday />} />
        <Route path='/holidays/update/:id' element={<UpdateHolidayPage />} />
      </Routes>

    </HashRouter>
    </div>
  );
}

export default App;
