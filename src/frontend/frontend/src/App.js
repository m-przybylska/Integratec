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

class App extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			popupIsVisible: false,
			popupType: "",
			popupData: {},
			popupColor: "iteragenta",
		};
	}

	setPopup = (type, data, color) => {
		this.setState(
			{ popupType: type, popupData: data, popupColor: color },
			() => {
				this.setState({ popupIsVisible: !this.state.popupIsVisible });
			}
		);
	};

	componentDidMount = () => {
		axios
			.get("http://localhost:8080/requests")
			.then((res) => {
				console.log(res.data);
				this.setState({ requestsList: res.data });
				console.log(this.state.requestsList);
			})
			.catch((error) => {
				if (error.response) {
					console.log(error.response);
				} else if (error.request) {
					console.log(error.request);
				} else if (error.message) {
					console.log(error.message);
				}
			});
	};

	// // Tablicę takich requestów chcę dostać z GET:
	// requestGET = {
	// 	title: "ciasteczka",
	// 	sender_id: 1,
	// 	sender_name: "Kate",
	// 	sender_surname: "Bond",
	// 	receiver_id: 2,
	// 	send_date: "03/07/2022",
	// 	text: "skonczyly sie ciasteczka:(",
	// 	comment: "komentarz",
	// 	request_category_id: 2,
	// 	request_priority_id: 1,
	// 	request_status_id: 1,
	// };

	// // A to chcę przekazać na backend w POST
	// requestPOST = {
	// 	title: "ciasteczka",
	// 	sender_id: 1,
	// 	receiver_id: 2,
	// 	send_date: "03/07/2022",
	// 	text: "skonczyly sie ciasteczka:(",
	// 	request_category_id: 2,
	// 	request_priority_id: 1,
	// 	request_status_id: 1,
	// };

	postRequest = () => {
		const newRequest = {
			comment: "string",
			receiver_id: 1,
			request_category_id: 1,
			request_id: 1,
			request_priority_id: 1,
			request_status_id: 1,
			send_date: "11-05-2022",
			sender_id: 1,
			text: "string",
			title: "string",
		};

		axios
			.post("http://localhost:8080/requests", { newRequest })
			.then((res) => {
				console.log(res);
				console.log(res.data);
			})
			.catch((error) => {
				if (error.response) {
					console.log(error.response);
				} else if (error.request) {
					console.log(error.request);
				} else if (error.message) {
					console.log(error.message);
				}
			});
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
								/>
							}
						/>
					</Routes>
					<button onClick={this.postRequest}>Click this</button>
				</Router>
			</div>
		);
	}
}
export default App;
