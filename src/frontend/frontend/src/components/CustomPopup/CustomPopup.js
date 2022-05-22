import React, { PureComponent } from 'react';
import './CustomPopup.scss';
import CustomButton from '../CustomButton/CustomButton';
import * as TestingData from '../../assets/data/TestingData';

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
		console.log(this.props.prioritiesList);
		console.log(this.props.categoriesList);
		console.log(this.props.statusesList);

		if (
			this.props.prioritiesList.length > 0 &&
			this.props.categoriesList.length > 0 &&
			this.props.statusesList.length > 0
		) {
			console.log(this.props.popupData);
			console.log(this.props.prioritiesList);
			console.log(this.props.categoriesList);
			console.log(this.props.statusesList);
			return (
				<div
					className={
						this.props.popupType == 'addTask'
							? this.props.popupIsVisible
								? `CustomPopup addTask ${this.props.popupColor}`
								: `CustomPopup addTask ${this.props.popupColor} hidden`
							: this.props.popupIsVisible
							? `CustomPopup ${this.props.popupColor}`
							: `CustomPopup ${this.props.popupColor} hidden`
					}
				>
					{this.props.popupType == 'addTask' ? (
						<React.Fragment>
							{console.log(this.props.popupData)}
							{console.log(this.props.prioritiesList)}
							{console.log(this.props.categoriesList)}
							{console.log(this.props.statusesList)}
							<div className='CustomPopup-addTask-FirstPart'>
								<input
									className='CustomPopup-addTask-FirstPart-Subject'
									placeholder='Subject...'
								></input>
								<textarea
									className='CustomPopup-addTask-FirstPart-Desc'
									placeholder='Add Description...'
								></textarea>
							</div>

							<div className='CustomPopup-addTask-SecondPart'>
								<CustomButton
									contentSelected='priority'
									prioritiesList={this.props.prioritiesList}
									categoriesList={this.props.categoriesList}
									statusesList={this.props.statusesList}
									buttonType='priority'
									isTag={false}
								/>
								<CustomButton
									contentSelected='category'
									prioritiesList={this.props.prioritiesList}
									categoriesList={this.props.categoriesList}
									statusesList={this.props.statusesList}
									buttonType='category'
									isTag={false}
								/>
								<CustomButton
									contentSelected='create'
									prioritiesList={this.props.prioritiesList}
									categoriesList={this.props.categoriesList}
									statusesList={this.props.statusesList}
									buttonType='create'
									isTag={false}
								/>
							</div>
						</React.Fragment>
					) : Object.keys(this.props.popupData).length !== 0 ? (
						<React.Fragment>
							{console.log(this.props.popupData)}
							{console.log(this.props.prioritiesList)}
							{console.log(this.props.categoriesList)}
							{console.log(this.props.statusesList)}

							<div className='CustomPopup-previewRequest-FirstPart'>
								<div className='CustomPopup-previewRequest-FirstPart-User'>
									<i className='las la-user' />
									<div className='CustomPopup-previewRequest-FirstPart-User-Name'>
										{this.props.popupData.name}
									</div>
								</div>
								<div className='CustomPopup-previewRequest-FirstPart-Date'>
									CREATED <br></br> {this.props.popupData.send_date}
								</div>
							</div>

							<div className='CustomPopup-previewRequest-SecondPart'>
								<div className='CustomPopup-previewRequest-SecondPart-Subject'>
									{this.props.popupData.title}
								</div>
								<div className='CustomPopup-previewRequest-SecondPart-Buttons'>
									<CustomButton
										contentSelected={this.props.popupData.request_priority_id}
										prioritiesList={this.props.prioritiesList}
										categoriesList={this.props.categoriesList}
										statusesList={this.props.statusesList}
										buttonType='priority'
										isTag={false}
									/>
									<CustomButton
										contentSelected={this.props.popupData.request_category_id}
										prioritiesList={this.props.prioritiesList}
										categoriesList={this.props.categoriesList}
										statusesList={this.props.statusesList}
										buttonType='category'
										isTag={false}
									/>
									<CustomButton
										contentSelected={this.props.popupData.request_status_id}
										prioritiesList={this.props.prioritiesList}
										categoriesList={this.props.categoriesList}
										statusesList={this.props.statusesList}
										buttonType='status'
										isTag={false}
									/>
								</div>
							</div>

							<div className='CustomPopup-previewRequest-ThirdPart'>
								<div className='CustomPopup-previewRequest-ThirdPart-Desc'>
									{this.props.popupData.text}
								</div>

								<textarea
									className='CustomPopup-previewRequest-ThirdPart-Com'
									placeholder={this.props.popupData.comment}
								></textarea>
							</div>
						</React.Fragment>
					) : null}
				</div>
			);
		} else {
			return null;
		}
	}
}

export default CustomPopup;
