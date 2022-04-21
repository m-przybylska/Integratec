import React, { PureComponent } from "react";
import "./Kanban.scss";
import PopupBackGround from "../PopupBackGround/PopupBackGround";
import * as TestingData from "../../assets/data/TestingData";
import CustomPopup from "../CustomPopup/CustomPopup";
import KanbanColumn from "../KanbanColumn/KanbanColumn";

class Kanban extends PureComponent {
  constructor(props) {
    super(props);

    this.state = { previewPopupIsVisible: false };
    this.setPreviewPopupVisibility = this.setPreviewPopupVisibility.bind(this);
  }

  setPreviewPopupVisibility = () => {
    this.setState(
      { previewPopupIsVisible: !this.state.previewPopupIsVisible },
      () => console.log(this.state.previewPopupIsVisible)
    );
  };

  render() {
    let newRequestsList = TestingData.requestsList.filter(
      (item) => item.status == "new"
    );
    let todoRequestsList = TestingData.requestsList.filter(
      (item) => item.status == "todo"
    );
    let inProgressRequestsList = TestingData.requestsList.filter(
      (item) => item.status == "progress"
    );
    let doneRequestsList = TestingData.requestsList.filter(
      (item) => item.status == "done"
    );

    return (
      <div className="Kanban">
        <PopupBackGround
          setPopup={this.props.setPopup}
          popupIsVisible={this.props.popupIsVisible}
        />
        <CustomPopup
          popupIsVisible={this.props.popupIsVisible}
          popupType={this.props.popupType}
          popupData={this.props.popupData}
          popupColor={this.props.popupColor}
        />

        <div className="Kanban-Container">
          <KanbanColumn
            columnType="new"
            contentList={newRequestsList}
            setPopup={this.props.setPopup}
          />
          <KanbanColumn
            columnType="todo"
            contentList={todoRequestsList}
            setPopup={this.props.setPopup}
          />
          <KanbanColumn
            columnType="progress"
            contentList={inProgressRequestsList}
            setPopup={this.props.setPopup}
          />
          <KanbanColumn
            columnType="done"
            contentList={doneRequestsList}
            setPopup={this.props.setPopup}
          />
        </div>
      </div>
    );
  }
}

export default Kanban;
