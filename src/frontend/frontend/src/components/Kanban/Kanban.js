import React, { PureComponent } from "react";
import "./Kanban.scss";

import PopupBackGround from "../PopupBackGround/PopupBackGround";
import Request from "../Request/Request";

import * as TestingData from "../../assets/data/TestingData";
import CustomPopup from "../CustomPopup/CustomPopup";

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
    let newRequestsList = TestingData.newRequestsList;
    let todoRequestsList = TestingData.todoRequestsList;
    let inProgressRequestsList = TestingData.inProgressRequestsList;
    let doneRequestsList = TestingData.doneRequestsList;

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
        />

        {/* <CreatePopup popupIsVisible={this.props.popupIsVisible} />
        <PreviewPopup
          previewPopupIsVisible={this.state.previewPopupIsVisible}
        /> */}
        {/*TODO: Remove PreviewPopup ^ */}
        {/*TODO: Maybe put those columns into a new component?*/}
        <div className="Kanban-Container">
          <div className="Kanban-Container-Column">
            <div className="Kanban-Container-Column-Title">NEW REQUESTS</div>
            <div className="Kanban-Container-Column-Content">
              {newRequestsList.map((item) => {
                return <Request data={item} setPopup={this.props.setPopup} />;
              })}
            </div>
          </div>

          <div className="Kanban-Container-Column">
            <div className="Kanban-Container-Column-Title">TO DO</div>
            <div className="Kanban-Container-Column-Content">
              {todoRequestsList.map((item) => {
                return <Request data={item} setPopup={this.props.setPopup} />;
              })}
            </div>
          </div>

          <div className="Kanban-Container-Column">
            <div className="Kanban-Container-Column-Title">IN PROGRESS</div>
            <div className="Kanban-Container-Column-Content">
              {inProgressRequestsList.map((item) => {
                return <Request data={item} setPopup={this.props.setPopup} />;
              })}
            </div>
          </div>

          <div className="Kanban-Container-Column">
            <div className="Kanban-Container-Column-Title">DONE</div>
            <div className="Kanban-Container-Column-Content">
              {doneRequestsList.map((item) => {
                return <Request data={item} setPopup={this.props.setPopup} />;
              })}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Kanban;
