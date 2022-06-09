import React, { PureComponent } from "react";
import Request from "../Request/Request";
import "./KanbanColumn.scss";

class KanbanColumn extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      hasError: false,
      color: "",
      title: "",
    };
  }

  setDataFromType = (type) => {
    switch (type) {
      case "new":
        this.setState({
          color: "grey",
          title: "New Requests",
        });
        break;
      case "todo":
        this.setState({ color: "iteragenta", title: "TODO" });
        break;
      case "progress":
        this.setState({
          color: "gelb",
          title: "In progress",
        });
        break;
      case "done":
        this.setState({ color: "mint", title: "Done" });
        break;
      default:
        break;
    }
  };

  componentDidMount() {
    this.setDataFromType(this.props.columnType);
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    // this.setDataFromType(this.props.columnType);

    return (
      <div className="KanbanColumn">
        <div
          className={
            this.props.columnType == "new"
              ? "KanbanColumn-Title"
              : "KanbanColumn-TitleWithBefore"
          }
        >
          {this.state.title}
        </div>
        <div className="KanbanColumn-Content">
          {this.props.contentList.map((item, i) => {
            return (
              <Request
                request_id={item.request_id}
                key={i}
                data={item}
                color={this.state.color}
                setPopup={this.props.setPopup}
                prioritiesList={this.props.prioritiesList}
                categoriesList={this.props.categoriesList}
                // statusesList={this.props.statusesList}
              />
            );
          })}
        </div>
      </div>
    );
  }
}

export default KanbanColumn;
