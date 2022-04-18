import React, { PureComponent } from "react";
import "./CustomButton.scss";

class CustomButton extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			hasError: false,
			buttonClassName: "",
			isTag: true,
		};
	}

	setDataFromType = () => {
		console.log(this.props.isTag);
		if (this.props.isTag == "true") {
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
		} else if (this.props.isTag == "false") {
			console.log(this.props.buttonType);
			switch (this.props.buttonType) {
				case "priority":
					this.setState({
						buttonClassName: "CustomButton-Button-Priority",
					});
					break;
				case "category":
					this.setState({
						buttonClassName: "CustomButton-Button-Category",
					});
					break;
				case "status":
					this.setState({
						buttonClassName: "CustomButton-Button-Status",
					});
					break;
				case "create":
					this.setState({
						buttonClassName: "CustomButton-Button-Create",
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
