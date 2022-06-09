import React, { PureComponent } from "react";
import "./Request.scss";
import Tooltip from "@mui/material/Tooltip";
import CustomButton from "../CustomButton/CustomButton";

class Request extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {};
  }

  setClassName = () => {
    return "Request " + this.props.color;
  };

  render() {
    // const { name, title, priority, category } = this.props.data;
    const name = this.props.data.name;
    const surname = this.props.data.surname;
    const fullName = name + " " + surname;
    const title = this.props.data.title;
    const date_timestamp = this.props.data.send_date;
    const date = new Intl.DateTimeFormat("en-GB", {
      year: "numeric",
      month: "2-digit",
      day: "2-digit",
    }).format(date_timestamp);

    if (
      this.props.prioritiesList.length > 0 &&
      this.props.categoriesList.length > 0
    ) {
      const priorityObj = this.props.prioritiesList.find((element) => {
        return (
          element.request_priority_id === this.props.data.request_priority_id
        );
      });
      const priorityName = priorityObj.request_priority;

      const categoryObj = this.props.categoriesList.find((element) => {
        return (
          element.request_category_id === this.props.data.request_category_id
        );
      });
      const categoryName = categoryObj.request_category;

      return (
        <div
          className={this.setClassName()}
          onClick={() =>
            this.props.setPopup(
              "previewRequest",
              this.props.data,
              this.props.color,
              this.props.request_id
            )
          }
        >
          <div className="Request-First-Part">
            <div className="Request-User">
              <i className="las la-user" />
              <Tooltip title={fullName} placement="top" arrow>
                <div className="Request-User-Name">{fullName}</div>
              </Tooltip>
            </div>
            <div className="Request-Created">
              <p className="Request-Created-Header">CREATED</p>
              <p className="Request-Created-Date">{date}</p>
            </div>
          </div>
          <div className="Request-Title">{title}</div>
          <div className="Request-Tags">
            <CustomButton
              contentSelected={priorityName}
              buttonType="priority"
              isTag={true}
              prioritiesList={this.props.prioritiesList}
              categoriesList={this.props.categoriesList}
              statusesList={this.props.statusesList}
            />
            <CustomButton
              contentSelected={categoryName}
              buttonType="category"
              isTag={true}
              prioritiesList={this.props.prioritiesList}
              categoriesList={this.props.categoriesList}
              statusesList={this.props.statusesList}
            />
          </div>
        </div>
      );
    } else {
      return null;
    }
  }
}

export default Request;
