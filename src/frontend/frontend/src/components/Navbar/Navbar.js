import React, { PureComponent } from "react";
import "./Navbar.scss";
import logo from "../../assets/images/logo.svg";

class Navbar extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div className="Navbar">
        <div className="Navbar-leftSide">
          <img src={logo} className="Navbar-leftSide-logo" />
        </div>
        <div className="Navbar-rightSide">
          <div className="Navbar-rightSide-option">my requests</div>
          <div
            className="Navbar-rightSide-option"
            onClick={() => this.props.setPopup("addTask", null, "iteragenta")}
          >
            add task
          </div>
          <div className="Navbar-rightSide-option">my account</div>
          <div className="Navbar-rightSide-option">settings</div>
          <div className="Navbar-rightSide-option">logout</div>
        </div>
      </div>
    );
  }
}

export default Navbar;
