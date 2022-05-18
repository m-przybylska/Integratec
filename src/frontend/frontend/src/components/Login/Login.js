import React, { PureComponent } from "react";
import "./Login.scss";
import PopupBackGround from "../PopupBackGround/PopupBackGround";
import * as TestingData from "../../assets/data/TestingData";
import CustomPopup from "../CustomPopup/CustomPopup";
import KanbanColumn from "../KanbanColumn/KanbanColumn";

class Login extends PureComponent {
	constructor(props) {
		super(props);

		this.state = { previewPopupIsVisible: false };
		this.setPreviewPopupVisibility = this.setPreviewPopupVisibility.bind(this);
	}

	setPreviewPopupVisibility = () => {
		this.setState(
			{ previewPopupIsVisible: !this.state.previewPopupIsVisible },
			() => console.log(this.state.previewPopupIsVisible)
		);
	};

	render() {
		return (
			<div className="Login">
				<div className="Login-Logo">Integratec</div>
				<div className="Login-Authorization">Integratec</div>
				<div className="Login-Username">Integratec</div>
				<div className="Login-Password">Integratec</div>
				<div className="Login-Buttons">
					<button>Zaloguj</button>
					<button>Nie pamietasz hasla?</button>
				</div>
			</div>
		);
	}
}

export default Login;
