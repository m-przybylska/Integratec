import React, { PureComponent } from "react";
import "./CustomPopup.scss";
import CustomButton from "../CustomButton/CustomButton";
import * as TestingData from "../../assets/data/TestingData";

class CustomPopup extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			hasError: false,
		};
	}

	render() {
		if (this.state.hasError) {
			return <h1>Something went wrong.</h1>;
		}
		console.log(this.props.popupData);
		return (
			<div
				className={
					this.props.popupType == "addTask"
						? this.props.popupIsVisible
							? `CustomPopup addTask ${this.props.popupColor}`
							: `CustomPopup addTask ${this.props.popupColor} hidden`
						: this.props.popupIsVisible
						? `CustomPopup ${this.props.popupColor}`
						: `CustomPopup ${this.props.popupColor} hidden`
				}
			>
				{this.props.popupType == "addTask" ? (
					<React.Fragment>
						<div className="CustomPopup-addTask-FirstPart">
							<input
								className="CustomPopup-addTask-FirstPart-Subject"
								placeholder="Subject..."
							></input>
							<textarea
								className="CustomPopup-addTask-FirstPart-Desc"
								placeholder="Add Description..."
							></textarea>
						</div>

						<div className="CustomPopup-addTask-SecondPart">
							<CustomButton
								contentSelected="priority"
								buttonType="priority"
								isTag={false}
							/>
							<CustomButton
								contentSelected="category"
								buttonType="category"
								isTag={false}
							/>
							<CustomButton
								contentSelected="create"
								buttonType="create"
								isTag={false}
							/>
						</div>
					</React.Fragment>
				) : Object.keys(this.props.popupData).length !== 0 ? (
					<React.Fragment>
						{console.log(this.props.popupData)}
						<div className="CustomPopup-previewRequest-FirstPart">
							<div className="CustomPopup-previewRequest-FirstPart-User">
								<i className="las la-user" />
								<div className="CustomPopup-previewRequest-FirstPart-User-Name">
									{this.props.popupData.sender.name}
								</div>
							</div>
							<div className="CustomPopup-previewRequest-FirstPart-Date">
								CREATED <br></br> {this.props.popupData.sendDate}
							</div>
						</div>

						<div className="CustomPopup-previewRequest-SecondPart">
							<div className="CustomPopup-previewRequest-SecondPart-Subject">
								{this.props.popupData.title}
							</div>
							<div className="CustomPopup-previewRequest-SecondPart-Buttons">
								<CustomButton
									contentSelected={
										this.props.popupData.requestPriority.requestPriority
									}
									buttonType="priority"
									isTag={false}
								/>
								<CustomButton
									contentSelected={
										this.props.popupData.requestCategory.requestCategory
									}
									buttonType="category"
									isTag={false}
								/>
								<CustomButton
									contentSelected={
										this.props.popupData.requestStatus.requestStatus
									}
									buttonType="status"
									isTag={false}
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
							></textarea>
						</div>
					</React.Fragment>
				) : null}
			</div>
		);
	}
}

export default CustomPopup;
