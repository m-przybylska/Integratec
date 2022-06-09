import React, { PureComponent } from "react";
import "./Kanban.scss";
import PopupBackGround from "../PopupBackGround/PopupBackGround";
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
    const { requestsList, statusesList } = this.props;

    if (statusesList.length !== 0) {
      let statusNew = this.props.statusesList.find((element) => {
        if (element.request_status === "new") return element.request_status_id;
      });

      let statusTodo = this.props.statusesList.find((element) => {
        if (element.request_status === "to do")
          return element.request_status_id;
      });

      let statusInProgress = this.props.statusesList.find((element) => {
        if (element.request_status === "in progress")
          return element.request_status_id;
      });

      let statusDone = this.props.statusesList.find((element) => {
        if (element.request_status === "done") return element.request_status_id;
      });

      let newRequestsList = requestsList.filter(
        (item) => item.request_status_id === statusNew.request_status_id
      );
      let todoRequestsList = requestsList.filter(
        (item) => item.request_status_id === statusTodo.request_status_id
      );
      let inProgressRequestsList = requestsList.filter(
        (item) => item.request_status_id === statusInProgress.request_status_id
      );
      let doneRequestsList = requestsList.filter(
        (item) => item.request_status_id === statusDone.request_status_id
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
            categoriesList={this.props.categoriesList}
            prioritiesList={this.props.prioritiesList}
            statusesList={this.props.statusesList}
            addNewRequest={this.props.addNewRequest}
            putRequest={this.props.putRequest}
            setPopup={this.props.setPopup}
          />
          {requestsList.length ? (
            <div className="Kanban-Container">
              <KanbanColumn
                columnType="new"
                contentList={newRequestsList}
                setPopup={this.props.setPopup}
                categoriesList={this.props.categoriesList}
                prioritiesList={this.props.prioritiesList}
                statusesList={this.props.statusesList}
              />
              <KanbanColumn
                columnType="todo"
                contentList={todoRequestsList}
                setPopup={this.props.setPopup}
                categoriesList={this.props.categoriesList}
                prioritiesList={this.props.prioritiesList}
                statusesList={this.props.statusesList}
              />
              <KanbanColumn
                columnType="progress"
                contentList={inProgressRequestsList}
                setPopup={this.props.setPopup}
                categoriesList={this.props.categoriesList}
                prioritiesList={this.props.prioritiesList}
                statusesList={this.props.statusesList}
              />
              <KanbanColumn
                columnType="done"
                contentList={doneRequestsList}
                setPopup={this.props.setPopup}
                categoriesList={this.props.categoriesList}
                prioritiesList={this.props.prioritiesList}
                statusesList={this.props.statusesList}
              />
            </div>
          ) : (
            <div className="Kanban no-requests">no requests</div>
          )}
        </div>
      );
    } else {
      return null;
    }
  }
}

export default Kanban;
