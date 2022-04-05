import React from "react";
import "../styles/Navbar.css";
import { Link } from "react-router-dom";

function Navbar() {
	return (
		<div className="navbar">
			<Link to="/">Home</Link>
			<Link to="/calendar">Calendar</Link>
			<Link to="/profile">Profile</Link>
		</div>
	);
}

export default Navbar;
