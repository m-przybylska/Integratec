import "./App.css";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import React, {useState, useEffect} from "react";
import axios from "axios"

const AccountProfiles = () => {
	const [accountProfiles, setAccountProfiles] = useState([]);

	const fetchAccountProfiles = () => {
		axios.get("http://localhost:8080/").then(res => {
			setAccountProfiles(res.data);
		});
	}
	
	useEffect(() => {
		fetchAccountProfiles();
	}, []);

	return accountProfiles.map((accountProfile, index) => {
		return (
			<div key={index}>
				<h1>{accountProfile.login}</h1>
				<h1>{accountProfile.password}</h1>
			</div>
		);
	});
}

function App() {
	return (
		<div className="App">
			<Router>
				<Navbar />
				<Routes>
					<Route path="/" element={<Home />} />
				</Routes>
			</Router>

			<h1 className="App-header">Hello World!</h1>
			<h1 className="App-header"><AccountProfiles /></h1>
		</div>
	);
}

export default App;
