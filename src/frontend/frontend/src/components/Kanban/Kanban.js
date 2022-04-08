import React, { PureComponent } from 'react';
import './Kanban.scss';
import CreatePopup from '../CreatePopup/CreatePopup';
import PopupBackGround from '../PopupBackGround/PopupBackGround';
import Request from '../Request/Request';
import PreviewPopup from '../PreviewPopup/PreviewPopup';
class Kanban extends PureComponent {
	constructor(props) {
		super(props);

		this.state = { previewPopupIsVisible: false };
	}

	render() {
		let requestList = [
			{
				name: 'Jan Kowalski',
				title: 'Engage Jupiter Express asdasdasdasdas',
				priority: 'Today',
				category: 'Kitchen',
			},
			{
				name: 'Andrzej Kowalski',
				title:
					'Engage Jupiter Express asdasdasdasdasddddddddddddddddddddddddddddddddddddddddddddd',
				priority: 'Taaaaaaaaaaaaaaaaaaaaaaa',
				category: 'aaaaaaaaaaaaaaaaaaaaaaaa',
			},
			{
				name: 'Maciej Kowalski',
				title: 'Engage Jupiter Express asdasdasdasdasd',
				priority: 'aaaaaaaaaaaaaaaa',
				category: 'Kitchen',
			},
			{
				name: 'Andrzej Kowalski',
				title: 'Engage Jupiter Express asdasdasdasdasd',
				priority: 'Taaaaaaaaaaaaaaaaaaaaaaa',
				category: 'aaaaaaaaaaaaaaaaaaaaaaaa',
			},
			{
				name: 'Maciej Kowalski',
				title: 'Engage Jupiter Express asdasdasdasdasd',
				priority: 'Today',
				category: 'aaaaaaaaaaaaa',
			},
		];
		return (
			<div className='Kanban'>
				<PopupBackGround
					setPopupVisibility={this.props.setPopupVisibility}
					popupIsVisible={this.props.popupIsVisible}
				/>
				{/* <CreatePopup popupIsVisible={this.props.popupIsVisible} /> //uncomment this */}
				<PreviewPopup popupIsVisible={this.props.popupIsVisible} />{' '}
				{/*TODO: Remove PreviewPopup ^ */}
				<div className='Kanban-Container'>
					<div className='Kanban-Container-Column'>
						<div className='Kanban-Container-Column-Title'>NEW REQUESTS</div>
						<div className='Kanban-Container-Column-Content'>
							{requestList.map((item) => {
								return <Request data={item} />;
							})}
						</div>
					</div>

					<div className='Kanban-Container-Column'>
						<div className='Kanban-Container-Column-Title'>TO DO</div>
						<div className='Kanban-Container-Column-Content'>
							{requestList.map((item) => {
								return <Request data={item} />;
							})}
						</div>
					</div>

					<div className='Kanban-Container-Column'>
						<div className='Kanban-Container-Column-Title'>IN PROGRESS</div>
						<div className='Kanban-Container-Column-Content'>
							{requestList.map((item) => {
								return <Request data={item} />;
							})}
						</div>
					</div>

					<div className='Kanban-Container-Column'>
						<div className='Kanban-Container-Column-Title'>DONE</div>
						<div className='Kanban-Container-Column-Content'>
							{requestList.map((item) => {
								return <Request data={item} />;
							})}
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default Kanban;
