import "./App.css";
import Navbar from "./components/Navbar/Navbar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import React, { useState, useEffect, PureComponent } from "react";
import axios from "axios";
import Kanban from "./components/Kanban/Kanban";
import * as Constants from "./assets/data/Constants";

const AccountProfiles = () => {
	const [accountProfiles, setAccountProfiles] = useState([]);

	const fetchAccountProfiles = () => {
		axios.get(Constants.serverURL).then((res) => {
			setAccountProfiles(res.data);
		});
	};

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
};

const RequestsList = () => {
	const [requestsList, setRequestsList] = useState([]);

	const fetchRequestsList = () => {
		axios.get("http://localhost:8080/requests").then((res) => {
			setRequestsList(res.data);
		});
	};

	useEffect(() => {
		fetchRequestsList();
	}, []);

	return requestsList.map((request, index) => {
		return (
			<div key={index}>
				<a>
					Sender: {request.sender.login}
					Title: {request.title}, Priority:{" "}
					{request.requestPriority.requestPriority}, Category:{" "}
					{request.requestCategory.requestCategory}, Status:{" "}
					{request.requestStatus.requestStatus}
				</a>
			</div>
		);
	});
};

class App extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			popupIsVisible: false,
			popupType: "",
			popupData: {},
			popupColor: "iteragenta",
			requestsList: [],
		};
	}

	componentDidMount = () => {
		axios.get("http://localhost:8080/requests").then((res) => {
			// console.log(res);
			this.setState({ requestsList: res.data });
			console.log(this.state.requestsList);
		});
	};

	setPopup = (type, data, color) => {
		this.setState(
			{ popupType: type, popupData: data, popupColor: color },
			() => {
				this.setState({ popupIsVisible: !this.state.popupIsVisible });
			}
		);
	};

	render() {
		return (
			<div className="App">
				<Router>
					<Navbar setPopup={this.setPopup} />
					<Routes>
						<Route
							path="/"
							element={
								<Kanban
									popupIsVisible={this.state.popupIsVisible}
									popupType={this.state.popupType}
									popupData={this.state.popupData}
									popupColor={this.state.popupColor}
									setPopup={this.setPopup}
									requestsList={this.state.requestsList}
								/>
							}
						/>
					</Routes>
					{/* <button onClick={this.setRequestsList}>Click this</button> */}
					{/* <RequestsList /> */}
				</Router>
			</div>
		);
	}
}
export default App;
