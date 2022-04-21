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
        </Router>
      </div>
    );
  }
}
export default App;
