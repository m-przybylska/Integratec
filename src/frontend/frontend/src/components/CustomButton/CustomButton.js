import React, { PureComponent } from "react";
import "./CustomButton.scss";
import * as TestingData from "../../assets/data/TestingData";

class CustomButton extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      hasError: false,
      buttonClassName: "",
      contentsList: [],
      showList: false,
      currentValue: this.props.contentSelected,
    };
    this.wrapperRef = React.createRef();
    this.handleClickOutside = this.handleClickOutside.bind(this);
  }

  componentWillMount = () => {
    this.setState({ currentValue: this.props.contentSelected });
  };
  componentDidMount() {
    document.addEventListener("mousedown", this.handleClickOutside);
  }

  componentWillUnmount() {
    document.removeEventListener("mousedown", this.handleClickOutside);
  }

  handleClickOutside(event) {
    if (
      event.target.className != "CustomButton-Button-Category" ||
      event.target.className != "CustomButton-Button-Status" ||
      event.target.className != "CustomButton-Button-Priority"
    )
      this.setState({ showList: false });
    //console.log(event.target.className);
  }

  setDataFromType = () => {
    if (this.props.isTag == true) {
      switch (this.props.buttonType) {
        case "priority":
          this.setState({
            buttonClassName: "CustomButton-Tag-Priority",
          });
          break;
        case "category":
          this.setState({
            buttonClassName: "CustomButton-Tag-Category",
          });
          break;
        case "status":
          this.setState({
            buttonClassName: "CustomButton-Tag-Status",
          });
          break;
        default:
          break;
      }
    } else {
      switch (this.props.buttonType) {
        case "priority":
          this.setState({
            buttonClassName: "CustomButton-Button-Priority",
            contentsList: TestingData.prioritiesList,
          });
          break;
        case "category":
          this.setState({
            buttonClassName: "CustomButton-Button-Category",
            contentsList: TestingData.categoriesList,
          });
          break;
        case "status":
          this.setState({
            buttonClassName: "CustomButton-Button-Status",
            contentsList: TestingData.statusesList,
          });
          break;
        case "create":
          this.setState({
            buttonClassName: "CustomButton-Button-Create",
            contentsList: TestingData.createList,
          });
        default:
          break;
      }
    }
  };

  render() {
    this.setDataFromType();
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return (
      <div
        className={this.state.buttonClassName}
        onClick={() => this.setState({ showList: !this.state.showList })}
        ref={this.wrapperRef}
      >
        {this.state.currentValue
          ? this.state.currentValue
          : this.props.contentSelected}
        <div
          className={
            this.state.showList
              ? "CustomButton-List"
              : "CustomButton-List hidden"
          }
        >
          {this.state.contentsList
            ? this.state.contentsList.map((item) => {
                return (
                  <div
                    className="CustomButton-List-Item"
                    onClick={() => this.setState({ currentValue: item })}
                  >
                    {item}
                  </div>
                );
              })
            : null}
        </div>
      </div>
    );
  }
}

export default CustomButton;
