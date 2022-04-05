import React, { PureComponent } from "react";
import "./Kanban.scss";
import CreatePopup from "../CreatePopup/CreatePopup";
import PopupBackGround from "../PopupBackGround/PopupBackGround";
class Kanban extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div className="Kanban">
        {" "}
        <PopupBackGround
          setPopupVisibility={this.props.setPopupVisibility}
          popupIsVisible={this.props.popupIsVisible}
        />
        <CreatePopup popupIsVisible={this.props.popupIsVisible} />
      </div>
    );
  }
}

export default Kanban;
