import React, { PureComponent } from "react";
import "./Kanban.scss";
import PopupBackGround from "../PopupBackGround/PopupBackGround";
import * as TestingData from "../../assets/data/TestingData";
import CustomPopup from "../CustomPopup/CustomPopup";
import KanbanColumn from "../KanbanColumn/KanbanColumn";

class Kanban extends PureComponent {
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

	// componentDidMount = () => {
	// 	let statusNew = this.props.statusesList.find((element) => {
	// 		if (element.requestStatus === "new") return element.requestStatusId;
	// 	});

	// 	this.state.statusNewId = statusNew.requestStatusId;
	// };

	render() {
		const { requestsList, statusesList } = this.props;

		// this.props.setRequestsList();
		// let requestsList = this.props.requestsList;
		console.log(requestsList);
		console.log(statusesList);

		if (statusesList.length !== 0) {
			let statusNew = this.props.statusesList.find((element) => {
				if (element.requestStatus === "new") return element.requestStatusId;
			});

			console.log(statusNew.requestStatusId);

			let statusTodo = this.props.statusesList.find((element) => {
				if (element.requestStatus === "to do") return element.requestStatusId;
			});

			let statusInProgress = this.props.statusesList.find((element) => {
				if (element.requestStatus === "in progress")
					return element.requestStatusId;
			});

			let statusDone = this.props.statusesList.find((element) => {
				if (element.requestStatus === "done") return element.requestStatusId;
			});

			let newRequestsList = requestsList.filter(
				(item) => item.request_status_id == statusNew.requestStatusId
			);
			let todoRequestsList = requestsList.filter(
				(item) => item.request_status_id == statusTodo.requestStatusId
			);
			let inProgressRequestsList = requestsList.filter(
				(item) => item.request_status_id == statusInProgress.requestStatusId
			);
			let doneRequestsList = requestsList.filter(
				(item) => item.request_status_id == statusDone.requestStatusId
			);

			console.log(newRequestsList);
			console.log(todoRequestsList);
			console.log(inProgressRequestsList);
			console.log(doneRequestsList);

			return (
				<div className="Kanban">
					<PopupBackGround
						setPopup={this.props.setPopup}
						popupIsVisible={this.props.popupIsVisible}
					/>

					<CustomPopup
						popupIsVisible={this.props.popupIsVisible}
						popupType={this.props.popupType}
						popupData={this.props.popupData}
						popupColor={this.props.popupColor}
						categoriesList={this.props.categoriesList}
						prioritiesList={this.props.prioritiesList}
						statusesList={this.props.statusesList}
					/>
					<div className="Kanban-Container">
						<KanbanColumn
							columnType="new"
							contentList={newRequestsList}
							setPopup={this.props.setPopup}
							categoriesList={this.props.categoriesList}
							prioritiesList={this.props.prioritiesList}
							statusesList={this.props.statusesList}
						/>
						<KanbanColumn
							columnType="todo"
							contentList={todoRequestsList}
							setPopup={this.props.setPopup}
							categoriesList={this.props.categoriesList}
							prioritiesList={this.props.prioritiesList}
							statusesList={this.props.statusesList}
						/>
						<KanbanColumn
							columnType="progress"
							contentList={inProgressRequestsList}
							setPopup={this.props.setPopup}
							categoriesList={this.props.categoriesList}
							prioritiesList={this.props.prioritiesList}
							statusesList={this.props.statusesList}
						/>
						<KanbanColumn
							columnType="done"
							contentList={doneRequestsList}
							setPopup={this.props.setPopup}
							categoriesList={this.props.categoriesList}
							prioritiesList={this.props.prioritiesList}
							statusesList={this.props.statusesList}
						/>
					</div>
				</div>
			);
		} else {
			return null;
		}
	}
}

export default Kanban;
