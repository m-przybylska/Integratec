import React, { PureComponent } from 'react';
import './Request.scss';
import CustomButton from '../CustomButton/CustomButton';
// import * as TestingData from "../../assets/data/TestingData";

class Request extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {};
	}

	setClassName = () => {
		return 'Request ' + this.props.color;
	};

	render() {
		// const { name, title, priority, category } = this.props.data;
		const name = this.props.data.name;
		const surname = this.props.data.surname;
		const fullName = name + ' ' + surname;
		const title = this.props.data.title;
		const date = this.props.data.send_date;

		if (
			this.props.prioritiesList.length > 0 &&
			this.props.categoriesList.length > 0
		) {
			const priorityObj = this.props.prioritiesList.find((element) => {
				return (
					element.request_priority_id === this.props.data.request_priority_id
				);
			});
			const priorityName = priorityObj.request_priority;

			const categoryObj = this.props.categoriesList.find((element) => {
				return (
					element.request_category_id === this.props.data.request_category_id
				);
			});
			const categoryName = categoryObj.request_category;

			return (
				<div
					className={this.setClassName()}
					onClick={() =>
						this.props.setPopup(
							'previewRequest',
							this.props.data,
							this.props.color
						)
					}
				>
					<div className='Request-First-Part'>
						<div className='Request-User'>
							<i className='las la-user' />
							<div className='Request-User-Name'>{fullName}</div>
						</div>
						<div className='Request-Created'>
							<p className='Request-Created-Header'>CREATED</p>
							<p className='Request-Created-Date'>{date}</p>
						</div>
					</div>
					<div className='Request-Title'>{title}</div>
					<div className='Request-Tags'>
						<CustomButton
							contentSelected={priorityName}
							buttonType='priority'
							isTag={true}
						/>
						<CustomButton
							contentSelected={categoryName}
							buttonType='category'
							isTag={true}
						/>
					</div>
				</div>
			);
		} else {
			return null;
		}
	}
}

export default Request;
