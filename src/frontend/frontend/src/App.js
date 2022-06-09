import "./App.css";
import Navbar from "./components/Navbar/Navbar";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import React, { PureComponent } from "react";
import axios from "axios";
import Kanban from "./components/Kanban/Kanban";
import Login from "./components/Login/Login";
import * as Constants from "./assets/data/Constants";

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
      authorization: [],
      request_id: null,
    };
  }

  setAuthorization = (auth) => {
    window.localStorage.setItem("authorization", auth);
    console.log(auth);
    this.setState({ authorization: auth }, () => {
      console.log(window.localStorage.authorization);
      axios
        .get("http://localhost:8080/requests", {
          // withCredentials: true,
          // credentials: true,
          headers: {
            // "Content-Type": "application/json",
            Authorization: "Bearer" + " " + this.state.authorization,
          },
          // headers: {
          //   cookie: "JWT" + " " + this.state.authorization,
          // },
        })
        .then((res) => {
          console.log(res);
          this.setState({ requestsList: res.data });
          console.log(this.state.requestsList);
        })
        .catch((err) => {
          window.localStorage.setItem("authorization", null);
        });

      axios
        .get("http://localhost:8080/statuses", {
          headers: {
            Authorization: "Bearer" + " " + this.state.authorization,
          },
        })
        .then((res) => {
          // console.log(res);
          this.setState({ statusesList: res.data });
          console.log(this.state.statusesList);
        });

      axios
        .get("http://localhost:8080/categories", {
          headers: {
            Authorization: "Bearer" + " " + this.state.authorization,
          },
        })
        .then((res) => {
          // console.log(res);
          this.setState({ categoriesList: res.data });
          console.log(this.state.categoriesList);
        });

      axios
        .get("http://localhost:8080/priorities", {
          headers: {
            Authorization: "Bearer" + " " + this.state.authorization,
          },
        })
        .then((res) => {
          // console.log(res);
          this.setState({ prioritiesList: res.data });
          console.log(this.state.prioritiesList);
        });
    });
  };

  componentDidMount = () => {
    console.log(window.localStorage.authorization);
    axios
      .get("http://localhost:8080/requests", {
        // withCredentials: true,
        // credentials: true,
        headers: {
          // "Content-Type": "application/json",
          Authorization: "Bearer" + " " + window.localStorage.authorization,
        },
        // headers: {
        //   cookie: "JWT" + " " + window.localStorage.authorization,
        // },
      })
      .then((res) => {
        console.log(res);
        this.setState({ requestsList: res.data });
        console.log(this.state.requestsList);
      });

    axios
      .get("http://localhost:8080/statuses", {
        headers: {
          Authorization: "Bearer" + " " + window.localStorage.authorization,
        },
      })
      .then((res) => {
        // console.log(res);
        this.setState({ statusesList: res.data });
        console.log(this.state.statusesList);
      });

    axios
      .get("http://localhost:8080/categories", {
        headers: {
          Authorization: "Bearer" + " " + window.localStorage.authorization,
        },
      })
      .then((res) => {
        // console.log(res);
        this.setState({ categoriesList: res.data });
        console.log(this.state.categoriesList);
      });

    axios
      .get("http://localhost:8080/priorities", {
        headers: {
          Authorization: "Bearer" + " " + window.localStorage.authorization,
        },
      })
      .then((res) => {
        // console.log(res);
        this.setState({ prioritiesList: res.data });
        console.log(this.state.prioritiesList);
      });
  };

  setPopup = (type, data, color, request_id) => {
    this.setState(
      {
        popupType: type,
        popupData: data,
        popupColor: color,
        request_id: request_id,
      },
      () => {
        this.setState({ popupIsVisible: !this.state.popupIsVisible });
      }
    );
  };

  postRequest = () => {
    axios
      .post(
        "http://localhost:8080/requests",
        {
          comment: "comment",
          receiver_id: 1,
          request_category_id: 1,
          request_id: 21,
          request_priority_id: 1,
          request_status_id: 1,
          send_date: "2022-05-11",
          sender_id: 1,
          text: "Jakis opis",
          title: "Nudzi mi sie",
        },
        {
          headers: {
            Authorization: "Bearer" + " " + window.localStorage.authorization,
          },
        }
      )
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

  addNewRequest = (request) => {
    axios
      .post(
        "http://localhost:8080/requests",
        {
          comment: "",
          receiver_id: 1,
          request_category_id: request.request_category_id,
          request_id: this.state.requestsList.length + 1,
          request_priority_id: request.request_priority_id,
          request_status_id: 1,
          send_date: "2022-05-11",
          sender_id: parseInt(window.localStorage.user_id),
          text: request.text,
          title: request.title,
        },
        {
          headers: {
            Authorization: "Bearer" + " " + window.localStorage.authorization,
          },
        }
      )
      .then((res) => {
        console.log(res);
        console.log(res.data);
        window.location.reload(false);
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

  putRequest = (
    request_category_id,
    request_priority_id,
    request_status_id,
    text,
    title
  ) => {
    axios
      .put(
        `http://localhost:8080/requests/${this.state.request_id}`,
        {
          comment: "",
          receiver: 1,
          request_category_id: request_category_id,
          request_id: this.state.request_id,
          request_priority_id: request_priority_id,
          request_status_id: request_status_id,
          send_date: "2022-05-12",
          sender_id: parseInt(window.localStorage.user_id),
          text: text,
          title: title,
        },
        {
          headers: {
            Authorization: "Bearer" + " " + window.localStorage.authorization,
          },
        }
      )
      .then((res) => {
        console.log(res);
        console.log(res.data);
        window.location.reload(false);
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
    console.log(window.localStorage.authorization == "null");
    return (
      <div className="App">
        <Router>
          <Navbar setPopup={this.setPopup} />
          <Routes>
            <Route
              path="/login"
              element={<Login setAuthorization={this.setAuthorization} />}
            />
            <Route
              path="/"
              element={
                window.localStorage.authorization == "null" ? (
                  <Navigate replace to="/login" />
                ) : (
                  <Kanban
                    popupIsVisible={this.state.popupIsVisible}
                    popupType={this.state.popupType}
                    popupData={this.state.popupData}
                    popupColor={this.state.popupColor}
                    setPopup={this.setPopup}
                    requestsList={this.state.requestsList}
                    categoriesList={this.state.categoriesList}
                    prioritiesList={this.state.prioritiesList}
                    statusesList={this.state.statusesList}
                    addNewRequest={this.addNewRequest}
                    putRequest={this.putRequest}
                  />
                )
              }
            />
            <Route
              path="*"
              element={
                window.localStorage.authorization == "null" ? (
                  <Navigate replace to="/login" />
                ) : (
                  <Navigate replace to="/" />
                )
              }
            />
          </Routes>
        </Router>
      </div>
    );
  }
}
export default App;
