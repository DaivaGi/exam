import './Menu.css';
import { Link } from 'react-router-dom';

export function Menu() {
    return (<div className="Menu">
        <Link to='/'>Holiday List</Link>
        &nbsp;|&nbsp;
        <Link to='/create'>Create New Holiday</Link>
    </div>);
}