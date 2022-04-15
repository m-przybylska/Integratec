import React, { PureComponent } from "react";
import "./PopupBackGround.scss";

class PopupBackGround extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {};
	}

	render() {
		return (
			<div
				className={
					this.props.popupIsVisible
						? "PopupBackGround"
						: "PopupBackGround hidden"
				}
				onClick={() => this.props.setPopupVisibility()}
			></div>
		);
	}
}

export default PopupBackGround;
