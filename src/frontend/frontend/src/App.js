import "./App.css";
import Navbar from "./components/Navbar/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import React, { useState, useEffect, PureComponent } from "react";
import axios from "axios";
import Kanban from "./components/Kanban/Kanban";

const AccountProfiles = () => {
  const [accountProfiles, setAccountProfiles] = useState([]);

  const fetchAccountProfiles = () => {
    axios.get("http://localhost:8080/").then((res) => {
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

    this.state = { popupIsVisible: false };
  }

  setPopupVisibility = () => {
    this.setState({ popupIsVisible: !this.state.popupIsVisible });
  };

  render() {
    return (
      <div className="App">
        <Router>
          <Navbar setPopupVisibility={this.setPopupVisibility} />
          <Routes>
            <Route
              path="/"
              element={
                <Kanban
                  popupIsVisible={this.state.popupIsVisible}
                  setPopupVisibility={this.setPopupVisibility}
                />
              }
            />
          </Routes>
        </Router>
      </div>
    );
  }
}
export default App;
