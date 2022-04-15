import React, { PureComponent } from "react";
import "./PreviewPopup.scss";
import * as TestingData from "../../assets/data/TestingData";

class PreviewPopup extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {};
	}

	render() {
		let request = TestingData.request;

		return (
			<div
				className={
					this.props.previewPopupIsVisible
						? "PreviewPopup"
						: "PreviewPopup hidden"
				}
			>
				<div className="PreviewPopup-FirstPart">
					<div className="PreviewPopup-FirstPart-User">
						<i className="las la-user" />
						<div className="PreviewPopup-FirstPart-User-Name">
							{request.name}
						</div>
					</div>
					<div className="PreviewPopup-FirstPart-Date">
						CREATED <br></br> {request.date}
					</div>
				</div>

				<div className="PreviewPopup-SecondPart">
					<div className="PreviewPopup-SecondPart-Subject">
						{request.subject}
					</div>
					<div className="PreviewPopup-SecondPart-Buttons">
						<button className="PreviewPopup-SecondPart-Buttons-Button mint">
							{request.priority}
						</button>
						<button className="PreviewPopup-SecondPart-Buttons-Button gelb">
							{request.category}
						</button>
						<button className="PreviewPopup-SecondPart-Buttons-Button iteragenta">
							{request.status}
						</button>
					</div>
				</div>

				<div className="PreviewPopup-ThirdPart">
					<div className="PreviewPopup-ThirdPart-Desc">
						{request.description}
					</div>

					<textarea
						className="PreviewPopup-ThirdPart-Com"
						placeholder="Comment here..."
					></textarea>
				</div>
			</div>
		);
	}
}

export default PreviewPopup;
