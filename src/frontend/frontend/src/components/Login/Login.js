import React, { PureComponent } from "react";
import "./Login.scss";
import logo from "../../assets/images/logo.svg";
import axios from "axios";
import { NavLink, Navigate } from "react-router-dom";

class Login extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      previewPopupIsVisible: false,
      inputUsername: "",
      inputPassword: "",
      username: "",
      redirect: false,
    };
    this.setPreviewPopupVisibility = this.setPreviewPopupVisibility.bind(this);
  }

  setPreviewPopupVisibility = () => {
    this.setState(
      { previewPopupIsVisible: !this.state.previewPopupIsVisible },
      () => console.log(this.state.previewPopupIsVisible)
    );
  };

  handleSignIn = () => {
    axios
      .post("http://localhost:8080/login", {
        username: this.state.inputUsername,
        password: this.state.inputPassword,
      })
      .then((res) => {
        console.log(res.data);
        this.props.setAuthorization(res.data.split(" ")[1]);
        window.localStorage.setItem("user_id", res.data.split(" ")[2]);
        this.setState(
          { username: res.data.split(" ")[0], redirect: true },
          () => {
            window.location.replace("/");
          }
        );
      })
      .catch((error) => {
        console.log(error);
      });
  };

  handleForgotPassword = () => {
    console.log("Clicked forgot password");
  };

  updateInputUsername(evt) {
    const val = evt.target.value;

    this.setState({
      inputUsername: val,
    });
  }

  updateInputPassword(evt) {
    const val = evt.target.value;

    this.setState({
      inputPassword: val,
    });
  }

  render() {
    // if (
    //   window.localStorage.username &&
    //   window.localStorage.username != "null"
    // ) {
    //   return <Navigate replace to={"/" + window.localStorage.username} />;
    // }
    return (
      <form className="Login">
        <div className="Login-Logo">
          <img src={logo} className="Navbar-leftSide-logo" alt="" />
        </div>
        <div className="Login-Authorization">
          <i className="las la-user" />
          <div className="Login-Authorization-Text">Authorization required</div>
        </div>
        <input
          className="Login-Input"
          placeholder="Username"
          value={this.state.inputUsername}
          onChange={(evt) => this.updateInputUsername(evt)}
        />
        <input
          className="Login-Input"
          placeholder="Password"
          type="password"
          value={this.state.inputPassword}
          onChange={(evt) => this.updateInputPassword(evt)}
        />
        <div className="Login-Buttons">
          <div
            to="/"
            className="Login-Buttons-SignIn"
            onClick={this.handleSignIn}
          >
            Sign in
          </div>
          <div
            className="Login-Buttons-ForgotPassword"
            onClick={this.handleForgotPassword}
          >
            Forgot password?
          </div>
        </div>
      </form>
    );
  }
}

export default Login;
