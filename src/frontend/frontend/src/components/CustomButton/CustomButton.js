import React, { PureComponent } from "react";
import "./CustomButton.scss";
import * as TestingData from "../../assets/data/TestingData";

class CustomButton extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			hasError: false,
			buttonClassName: "",
			contentsList: {},
		};
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
			<div className={this.state.buttonClassName}>
				{this.props.contentSelected}
			</div>
		);
	}
}

export default CustomButton;
