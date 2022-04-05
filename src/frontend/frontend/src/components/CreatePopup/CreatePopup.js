import React, { PureComponent } from "react";
import "./CreatePopup.scss";

class CreatePopup extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div
        className={
          this.props.popupIsVisible ? "CreatePopup" : "CreatePopup hidden"
        }
      >
        <div className="CreatePopup-FirstPart">
          <input
            className="CreatePopup-FirstPart-Subject"
            placeholder="Subject..."
          ></input>
          <textarea
            className="CreatePopup-FirstPart-Desc"
            placeholder="Add Description..."
          ></textarea>
        </div>

        <div className="CreatePopup-SecondPart">
          <button className="CreatePopup-SecondPart-Button mint">
            PRIORITY
          </button>
          <button className="CreatePopup-SecondPart-Button gelb">
            CATEGORY
          </button>
          <button className="CreatePopup-SecondPart-Button iteragenta">
            CREATE
          </button>
        </div>
      </div>
    );
  }
}

export default CreatePopup;
