import React, { PureComponent } from 'react';
import './PreviewPopup.scss';

class PreviewPopup extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {};
	}

	render() {
		let request = {
			name: 'Jan Kowalski',
			date: 'Mar. 13 1:16 PM',
			subject:
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
			priority: 'Today',
			category: 'Kitchen',
			status: 'New',
			description:
				'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
			comment: '',
		};
		return (
			<div
				className={
					this.props.popupIsVisible ? 'PreviewPopup' : 'PreviewPopup hidden'
				}
			>
				<div className='PreviewPopup-FirstPart'>
					<div className='PreviewPopup-FirstPart-User'>
						<i className='las la-user' />
						<div className='PreviewPopup-FirstPart-User-Name'>
							{request.name}
						</div>
					</div>
					<div className='PreviewPopup-FirstPart-Date'>
						CREATED <br></br> {request.date}
					</div>
				</div>

				<div className='PreviewPopup-SecondPart'>
					<div className='PreviewPopup-SecondPart-Subject'>
						{request.subject}
					</div>
					<div className='PreviewPopup-SecondPart-Buttons'>
						<button className='PreviewPopup-SecondPart-Buttons-Button mint'>
							{request.priority}
						</button>
						<button className='PreviewPopup-SecondPart-Buttons-Button gelb'>
							{request.category}
						</button>
						<button className='PreviewPopup-SecondPart-Buttons-Button iteragenta'>
							{request.status}
						</button>
					</div>
				</div>

				<div className='PreviewPopup-ThirdPart'>
					<div className='PreviewPopup-ThirdPart-Desc'>
						{request.description}
					</div>

					<textarea
						className='PreviewPopup-ThirdPart-Com'
						placeholder='Comment here...'
					></textarea>
				</div>
			</div>
		);
	}
}

export default PreviewPopup;
