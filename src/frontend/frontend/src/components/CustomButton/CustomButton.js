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
		};
	}

	setDataFromType = () => {
		if (this.props.isTag == true) {
			switch (this.props.buttonType) {
				case "priority":
					this.setState({
						buttonClassName: "CustomButton-Tag-Priority",
						// contentsList: this.props.prioritiesList,
					});
					break;
				case "category":
					this.setState({
						buttonClassName: "CustomButton-Tag-Category",
						// contentsList: this.props.categoriesList,
					});
					break;
				case "status":
					this.setState({
						buttonClassName: "CustomButton-Tag-Status",
						// contentsList: this.props.statusesList,
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
						// contentsList: this.props.prioritiesList,
						contentsList: TestingData.prioritiesList,
					});
					break;
				case "category":
					this.setState({
						buttonClassName: "CustomButton-Button-Category",
						// contentsList: this.props.categoriesList,
						contentsList: TestingData.categoriesList,
					});
					break;
				case "status":
					this.setState({
						buttonClassName: "CustomButton-Button-Status",
						// contentsList: this.props.statusesList,
						contentsList: TestingData.statusesList,
					});
					break;
				case "create":
					this.setState({
						buttonClassName: "CustomButton-Button-Create",
						contentsList: TestingData.createList, // change this to...?
					});
				default:
					break;
			}
		}
	};

	render() {
		if (this.state.hasError) {
			return <h1>Something went wrong.</h1>;
		}
		// console.log(this.props.prioritiesList);
		// if (
		// 	this.props.prioritiesList.length > 0 &&
		// 	this.props.categoriesList.length > 0 &&
		// 	this.props.statusesList.length > 0
		// ) {
		this.setDataFromType();

		const selectedContentObj = "";
		const selectedContentName = "";

		// switch (this.buttonType) {
		// 	case "priority":
		// 		selectedContentObj = this.contentsList.find((element) => {
		// 			return (
		// 				element.requestPriorityId === this.props.data.contentSelected
		// 			);
		// 		});
		// 		selectedContentName = selectedContentObj.requestPriority;
		// 		break;
		// 	case "category":
		// 		selectedContentObj = this.contentsList.find((element) => {
		// 			return (
		// 				element.requestPriorityId === this.props.data.contentSelected
		// 			);
		// 		});
		// 		selectedContentName = selectedContentObj.requestPriority;
		// 		break;
		// 	case "status":
		// 		selectedContentObj = this.contentsList.find((element) => {
		// 			return (
		// 				element.requestPriorityId === this.props.data.contentSelected
		// 			);
		// 		});
		// 		selectedContentName = selectedContentObj.requestPriority;
		// 		break;
		// 	case "create":
		// 		selectedContentObj = this.contentsList.find((element) => {
		// 			return (
		// 				element.requestPriorityId === this.props.data.contentSelected
		// 			);
		// 		});
		// 		selectedContentName = selectedContentObj.requestPriority;
		// 		break;
		// 	default:
		// 		break;
		// }

		return (
			<div
				className={this.state.buttonClassName}
				onClick={() => this.setState({ showList: !this.state.showList })}
			>
				{this.props.contentSelected}
				<div
					className={
						this.state.showList
							? "CustomButton-List"
							: "CustomButton-List hidden"
					}
				>
					{this.state.contentsList
						? this.state.contentsList.map((item) => {
								return <div className="CustomButton-List-Item">{item}</div>;
						  })
						: null}
				</div>
			</div>
		);
		// } else {
		// 	return null;
		// }
	}
}

export default CustomButton;
