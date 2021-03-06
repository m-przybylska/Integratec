import React, { PureComponent } from "react";
import "./PopupBackGround.scss";

class PopupBackGround extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div
        className={
          this.props.popupIsVisible
            ? "PopupBackGround"
            : "PopupBackGround hidden"
        }
        onClick={() => this.props.setPopup("", {}, "iteragenta")}
      ></div>
    );
  }
}

export default PopupBackGround;
