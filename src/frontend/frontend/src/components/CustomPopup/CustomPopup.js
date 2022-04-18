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
		return (
			<div
				className={
					this.props.popupType == "addTask"
						? this.props.popupIsVisible
							? "CustomPopup addTask"
							: "CustomPopup addTask hidden"
						: this.props.popupIsVisible
						? "CustomPopup"
						: "CustomPopup hidden"
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
				) : (
					<React.Fragment>
						<div className="CustomPopup-previewRequest-FirstPart">
							<div className="CustomPopup-previewRequest-FirstPart-User">
								<i className="las la-user" />
								<div className="CustomPopup-previewRequest-FirstPart-User-Name">
									{this.props.popupData.name}
								</div>
							</div>
							<div className="CustomPopup-previewRequest-FirstPart-Date">
								CREATED <br></br> 18.04.2022
							</div>
						</div>

						<div className="CustomPopup-previewRequest-SecondPart">
							<div className="CustomPopup-previewRequest-SecondPart-Subject">
								{this.props.popupData.title}
							</div>
							<div className="CustomPopup-previewRequest-SecondPart-Buttons">
								<CustomButton
									contentSelected={this.props.popupData.priority}
									buttonType="priority"
									isTag={false}
								/>
								<CustomButton
									contentSelected={this.props.popupData.category}
									buttonType="category"
									isTag={false}
								/>
								<CustomButton
									contentSelected={this.props.popupData.status}
									buttonType="status"
									isTag={false}
								/>
							</div>
						</div>

						<div className="CustomPopup-previewRequest-ThirdPart">
							<div className="CustomPopup-previewRequest-ThirdPart-Desc">
								{this.props.popupData.description}
							</div>

							<textarea
								className="CustomPopup-previewRequest-ThirdPart-Com"
								placeholder="Comment here..."
							></textarea>
						</div>
					</React.Fragment>
				)}
			</div>
		);
	}
}

export default CustomPopup;
