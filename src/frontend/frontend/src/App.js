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
      categoriesList: [],
      prioritiesList: [],
      statusesList: [],
    };
  }

  componentDidMount = () => {
    axios.get("http://localhost:8080/requests").then((res) => {
      // console.log(res);
      this.setState({ requestsList: res.data });
      console.log(this.state.requestsList);
    });

    axios.get("http://localhost:8080/statuses").then((res) => {
      // console.log(res);
      this.setState({ statusesList: res.data });
      console.log(this.state.statusesList);
    });

    axios.get("http://localhost:8080/categories").then((res) => {
      // console.log(res);
      this.setState({ categoriesList: res.data });
      console.log(this.state.categoriesList);
    });

    axios.get("http://localhost:8080/priorities").then((res) => {
      // console.log(res);
      this.setState({ prioritiesList: res.data });
      console.log(this.state.prioritiesList);
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

  postRequest = () => {
    axios
      .post("http://localhost:8080/requests", {
        comment: "comment",
        receiver_id: 1,
        request_category_id: 1,
        request_id: 1,
        request_priority_id: 1,
        request_status_id: null,
        send_date: "2022-05-11",
        sender_id: 1,
        text: "string",
        title: "string",
      })
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

  putRequest = () => {
    axios
      .put("http://localhost:8080/requests/1", {
        comment: "dziala",
        receiver: 1,
        requestCategory: 1,
        requestId: 1,
        requestPriority: 1,
        requestStatus: 1,
        sendDate: "2022-05-12",
        sender_id: 1,
        text: "string",
        title: "string",
      })
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
                  requestsList={this.state.requestsList}
                  categoriesList={this.state.categoriesList}
                  prioritiesList={this.state.prioritiesList}
                  statusesList={
                    this.state.statusesList ? this.state.statusesList : []
                  }
                />
              }
            />
          </Routes>
          <button onClick={this.postRequest}>Click this to post</button>
          <button onClick={this.putRequest}>Click this to put</button>
        </Router>
      </div>
    );
  }
}
export default App;
