import React, { PureComponent } from "react";
import "./Request.scss";
import CustomButton from "../CustomButton/CustomButton";
// import * as TestingData from "../../assets/data/TestingData";

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
		const name = this.props.data.sender.name;
		const surname = this.props.data.sender.surname;
		const title = this.props.data.title;
		const priority = this.props.data.requestPriority;
		const category = this.props.data.requestCategory;
		const date = this.props.data.sendDate;

		// const categoryObj = this.props.categoriesList.find((element) => {
		// 	return element.requestCategoryId === this.props.data.requestCategory;
		// });

		// const categoryA = categoryObj.requestCategory;

		return (
			<div
				className={this.setClassName()}
				onClick={() =>
					this.props.setPopup(
						"previewRequest",
						this.props.data,
						this.props.color
					)
				}
			>
				<div className="Request-First-Part">
					<div className="Request-User">
						<i className="las la-user" />
						<div className="Request-User-Name">{name}</div>
					</div>
					<div className="Request-Created">
						<p className="Request-Created-Header">CREATED</p>
						<p className="Request-Created-Date">{date}</p>
					</div>
				</div>
				<div className="Request-Title">{title}</div>
				<div className="Request-Tags">
					<CustomButton
						contentSelected={priority}
						buttonType="priority"
						isTag={true}
					/>
					<CustomButton
						contentSelected={category}
						buttonType="category"
						isTag={true}
					/>
				</div>
			</div>
		);
	}
}

export default Request;
