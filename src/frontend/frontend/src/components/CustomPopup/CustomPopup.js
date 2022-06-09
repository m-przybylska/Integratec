import React, { PureComponent } from "react";
import "./CustomPopup.scss";
import CustomButton from "../CustomButton/CustomButton";
import axios from "axios";
import { format } from "date-fns";

class CustomPopup extends PureComponent {
  constructor(props) {
    super(props);

    this.state = this.getInitialState();
  }
  getInitialState = () => ({
    hasError: false,
    addTaskCategory: "",
    addTaskPriority: "",
    addTaskCreate: false,
    addTaskSubject: "",
    addTaskDescription: "",

    changes: 0,
    taskPriority: "",
    priorityChanged: 0,
    taskCategory: "",
    categoryChanged: 0,
    taskStatus: "",
    statusChanged: 0,
    taskDescription: "",
    descriptionChanged: 0,
  });
  resetState = () => {
    this.setState(this.getInitialState());
  };

  componentDidMount = () => {
    this.resetState();
  };
  updateAddTaskSubject = (e) => {
    const val = e.target.value;

    this.setState(
      {
        addTaskSubject: val,
      },
      () => console.log(this.state)
    );
  };

  updateAddTaskDescription = (e) => {
    const val = e.target.value;

    this.setState({
      addTaskDescription: val,
    });
  };

  updateAddTaskCategory = (val) => {
    this.setState({
      addTaskCategory: val,
    });
  };

  updateAddTaskPriority = (val) => {
    this.setState({
      addTaskPriority: val,
    });
  };

  updateAddTaskCreate = (val) => {
    this.setState({
      addTaskCreate: val,
    });
  };

  changeTaskPriority = (val) => {
    this.setState(
      {
        taskPriority: val,
      },
      () => {
        let contentSelectedObject = this.props.prioritiesList.find(
          (element) => {
            if (
              this.props.popupData.request_priority_id ===
              element.request_priority_id
            )
              return element;
          }
        );
        console.log(contentSelectedObject);
        contentSelectedObject.request_priority == val
          ? this.setState({
              changes:
                this.state.priorityChanged == 1
                  ? this.state.changes - 1
                  : this.state.changes,
              priorityChanged: 0,
            })
          : this.setState({
              changes:
                this.state.priorityChanged == 0
                  ? this.state.changes + 1
                  : this.state.changes,
              priorityChanged: 1,
            });
      }
    );
  };

  changeTaskCategory = (val) => {
    this.setState(
      {
        taskCategory: val,
      },
      () => {
        console.log(this.state);
        let contentSelectedObject = this.props.categoriesList.find(
          (element) => {
            if (
              this.props.popupData.request_category_id ===
              element.request_category_id
            )
              return element;
          }
        );
        contentSelectedObject.request_category == val
          ? this.setState({
              changes:
                this.state.categoryChanged == 1
                  ? this.state.changes - 1
                  : this.state.changes,
              categoryChanged: 0,
            })
          : this.setState({
              changes:
                this.state.categoryChanged == 0
                  ? this.state.changes + 1
                  : this.state.changes,
              categoryChanged: 1,
            });
      }
    );
  };

  changeTaskStatus = (val) => {
    this.setState(
      {
        taskStatus: val,
      },
      () => {
        console.log(this.props.popupData.request_status_id);
        let contentSelectedObject = this.props.statusesList.find((element) => {
          if (
            this.props.popupData.request_status_id === element.request_status_id
          )
            return element;
        });
        console.log(contentSelectedObject.request_status, val);
        contentSelectedObject.request_status == val
          ? this.setState(
              {
                changes:
                  this.state.statusChanged == 1
                    ? this.state.changes - 1
                    : this.state.changes,
              },
              () => this.setState({ statusChanged: 0 })
            )
          : this.setState(
              {
                changes:
                  this.state.statusChanged == 0
                    ? this.state.changes + 1
                    : this.state.changes,
              },
              () => this.setState({ statusChanged: 1 })
            );
      }
    );
  };

  changeTaskDescription = (e) => {
    const val = e.target.value;
    this.setState(
      {
        taskDescription: this.props.popupData.text + " " + val,
      },
      () => {
        console.log(this.state);
        val == ""
          ? this.setState(
              {
                changes:
                  this.state.descriptionChanged == 1
                    ? this.state.changes - 1
                    : this.state.changes,
              },
              () => this.setState({ descriptionChanged: 0 })
            )
          : this.setState(
              {
                changes:
                  this.state.descriptionChanged == 0
                    ? this.state.changes + 1
                    : this.state.changes,
              },
              () => this.setState({ descriptionChanged: 1 })
            );
      }
    );
  };
  saveChanges = () => {
    let categorySelectedObject = this.props.categoriesList.find((element) => {
      if (this.state.taskCategory == element.request_category) return element;
    });
    let statusSelectedObject = this.props.statusesList.find((element) => {
      if (this.state.taskStatus == element.request_status) return element;
    });
    let prioritySelectedObject = this.props.prioritiesList.find((element) => {
      if (this.state.taskPriority == element.request_priority) return element;
    });

    let request_category_id = categorySelectedObject
      ? categorySelectedObject.request_category_id
      : this.props.popupData.request_category_id;

    let request_priority_id = prioritySelectedObject
      ? prioritySelectedObject.request_priority_id
      : this.props.popupData.request_priority_id;

    let request_status_id = statusSelectedObject
      ? statusSelectedObject.request_status_id
      : this.props.popupData.request_status_id;

    let request_id = 1;

    let text = this.state.taskDescription
      ? this.state.taskDescription
      : this.props.popupData.text;
    let title = this.props.popupData.title;

    this.props.putRequest(
      request_category_id,
      request_priority_id,
      request_status_id,
      text,
      title
    );
    this.resetState();
  };

  render() {
    if (
      this.props.prioritiesList.length > 0 &&
      this.props.categoriesList.length > 0 &&
      this.props.statusesList.length > 0
    ) {
      return (
        <div
          className={
            this.props.popupType === "addTask"
              ? this.props.popupIsVisible
                ? `CustomPopup addTask ${this.props.popupColor}`
                : `CustomPopup addTask ${this.props.popupColor} hidden`
              : this.props.popupIsVisible
              ? `CustomPopup ${this.props.popupColor}`
              : `CustomPopup ${this.props.popupColor} hidden`
          }
        >
          {this.props.popupType === "addTask" ? (
            <React.Fragment>
              <div className="CustomPopup-addTask-FirstPart">
                <input
                  className="CustomPopup-addTask-FirstPart-Subject"
                  placeholder="Subject..."
                  onChange={(e) => this.updateAddTaskSubject(e)}
                ></input>
                <textarea
                  className="CustomPopup-addTask-FirstPart-Desc"
                  placeholder="Add Description..."
                  onChange={(e) => this.updateAddTaskDescription(e)}
                ></textarea>
              </div>

              <div className="CustomPopup-addTask-SecondPart">
                <CustomButton
                  contentSelected="priority"
                  prioritiesList={this.props.prioritiesList}
                  categoriesList={this.props.categoriesList}
                  statusesList={this.props.statusesList}
                  buttonType="priority"
                  isTag={false}
                  addTask={true}
                  updateAddTaskPriority={this.updateAddTaskPriority}
                />
                <CustomButton
                  contentSelected="category"
                  prioritiesList={this.props.prioritiesList}
                  categoriesList={this.props.categoriesList}
                  statusesList={this.props.statusesList}
                  buttonType="category"
                  isTag={false}
                  addTask={true}
                  updateAddTaskCategory={this.updateAddTaskCategory}
                />
                <CustomButton
                  contentSelected="create"
                  prioritiesList={this.props.prioritiesList}
                  categoriesList={this.props.categoriesList}
                  statusesList={this.props.statusesList}
                  buttonType="create"
                  isTag={false}
                  addTask={true}
                  updateAddTaskCreate={this.updateAddTaskCreate}
                />
              </div>
            </React.Fragment>
          ) : Object.keys(this.props.popupData).length !== 0 ? (
            <React.Fragment>
              <div className="CustomPopup-previewRequest-FirstPart">
                <div className="CustomPopup-previewRequest-FirstPart-User">
                  <i className="las la-user" />
                  <div className="CustomPopup-previewRequest-FirstPart-User-Name">
                    {this.props.popupData.name +
                      " " +
                      this.props.popupData.surname}
                  </div>
                </div>
                <div className="CustomPopup-previewRequest-FirstPart-Date">
                  CREATED <br></br>{" "}
                  {new Intl.DateTimeFormat("en-GB", {
                    year: "numeric",
                    month: "2-digit",
                    day: "2-digit",
                  }).format(this.props.popupData.send_date)}
                </div>
              </div>

              <div className="CustomPopup-previewRequest-SecondPart">
                <div className="CustomPopup-previewRequest-SecondPart-Subject">
                  {this.props.popupData.title}
                </div>
                <div className="CustomPopup-previewRequest-SecondPart-Buttons">
                  <CustomButton
                    contentSelected={this.props.popupData.request_priority_id}
                    prioritiesList={this.props.prioritiesList}
                    categoriesList={this.props.categoriesList}
                    statusesList={this.props.statusesList}
                    buttonType="priority"
                    isTag={false}
                    changeTaskPriority={this.changeTaskPriority}
                  />
                  <CustomButton
                    contentSelected={this.props.popupData.request_category_id}
                    prioritiesList={this.props.prioritiesList}
                    categoriesList={this.props.categoriesList}
                    statusesList={this.props.statusesList}
                    buttonType="category"
                    isTag={false}
                    changeTaskCategory={this.changeTaskCategory}
                  />
                  <CustomButton
                    contentSelected={this.props.popupData.request_status_id}
                    prioritiesList={this.props.prioritiesList}
                    categoriesList={this.props.categoriesList}
                    statusesList={this.props.statusesList}
                    buttonType="status"
                    isTag={false}
                    changeTaskStatus={this.changeTaskStatus}
                  />
                </div>
              </div>

              <div className="CustomPopup-previewRequest-ThirdPart">
                <div className="CustomPopup-previewRequest-ThirdPart-Desc">
                  {this.props.popupData.text}
                </div>

                <textarea
                  className="CustomPopup-previewRequest-ThirdPart-Com"
                  placeholder={this.props.popupData.comment}
                  onChange={(e) => this.changeTaskDescription(e)}
                ></textarea>
              </div>

              <div className="CustomPopup-previewRequest-FourthPart">
                <CustomButton
                  contentSelected={this.props.popupData.request_status_id}
                  prioritiesList={this.props.prioritiesList}
                  categoriesList={this.props.categoriesList}
                  statusesList={this.props.statusesList}
                  buttonType="save"
                  isTag={false}
                  isNotActive={this.state.changes ? false : true}
                  saveChanges={this.saveChanges}
                />
              </div>
            </React.Fragment>
          ) : null}
        </div>
      );
    } else {
      return null;
    }
  }
}

export default CustomPopup;
