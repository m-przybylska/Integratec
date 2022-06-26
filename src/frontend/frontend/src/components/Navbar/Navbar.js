import React, { PureComponent } from "react";
import "./Navbar.scss";
import logo from "../../assets/images/logo.svg";
import { NavLink } from "react-router-dom";

class Navbar extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  clearLocalStorage = () => {
    if (window.localStorage.authorization)
      window.localStorage.authorization = null;
    if (window.localStorage.username) window.localStorage.username = null;
    console.log(window.localStorage);
  };

  render() {
    return (
      <div className="Navbar">
        <div className="Navbar-leftSide">
          <img src={logo} className="Navbar-leftSide-logo" />
        </div>
        <div className="Navbar-rightSide">
          <div className="Navbar-rightSide-option">requests</div>
          <div
            className="Navbar-rightSide-option"
            onClick={() => this.props.setPopup("addTask", null, "iteragenta")}
          >
            add task
          </div>
          {/* <div className='Navbar-rightSide-option'>my account</div> */}
          {/* <div className='Navbar-rightSide-option'>settings</div> */}
          <NavLink
            className="Navbar-rightSide-option"
            to="/login"
            onClick={this.clearLocalStorage}
          >
            logout
          </NavLink>
        </div>
      </div>
    );
  }
}

export default Navbar;
