import React, { PureComponent } from 'react';
import Tooltip from '@mui/material/Tooltip';
import './CustomButton.scss';
import * as TestingData from '../../assets/data/TestingData';

class CustomButton extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			hasError: false,
			buttonClassName: '',
			contentsList: [],
			showList: false,
			currentValue: this.props.contentSelected,
		};
		this.wrapperRef = React.createRef();
		this.handleClickOutside = this.handleClickOutside.bind(this);
	}

	componentWillMount = () => {
		this.setState({ currentValue: this.props.contentSelected });
	};
	componentDidMount() {
		this.setDataFromType();
		document.addEventListener('mousedown', this.handleClickOutside);
	}

	componentWillUnmount() {
		document.removeEventListener('mousedown', this.handleClickOutside);
	}

	handleClickOutside(event) {
		// console.log(event.target.className);
		if (
			event.target.className !== 'CustomButton-List-Item' &&
			(event.target.className !== 'CustomButton-Button-Category' ||
				event.target.className !== 'CustomButton-Button-Status' ||
				event.target.className !== 'CustomButton-Button-Priority')
		)
			this.setState({ showList: false });
	}

	setDataFromType = () => {
		if (this.props.isTag === true) {
			switch (this.props.buttonType) {
				case 'priority':
					this.setState({
						buttonClassName: 'CustomButton-Tag-Priority',
					});
					break;
				case 'category':
					this.setState({
						buttonClassName: 'CustomButton-Tag-Category',
					});
					break;
				case 'status':
					this.setState({
						buttonClassName: 'CustomButton-Tag-Status',
					});
					break;
				default:
					break;
			}
		} else {
			let stringsList = [];
			let contentSelectedObject = null;
			let contentSelectedString = '';
			switch (this.props.buttonType) {
				case 'priority':
					for (const item of this.props.prioritiesList) {
						stringsList.push(item.request_priority);
					}

					if (this.props.contentSelected === 'priority')
						contentSelectedString = 'priority';
					else {
						contentSelectedObject = this.props.prioritiesList.find(
							(element) => {
								if (element.request_priority_id === this.props.contentSelected)
									return element;
							}
						);
						contentSelectedString = contentSelectedObject.request_priority;
					}

					this.setState({
						buttonClassName: 'CustomButton-Button-Priority',
						contentsList: stringsList,
						currentValue: contentSelectedString,
					});
					break;
				case 'category':
					for (const item of this.props.categoriesList) {
						stringsList.push(item.request_category);
					}

					if (this.props.contentSelected === 'category')
						contentSelectedString = 'category';
					else {
						contentSelectedObject = this.props.categoriesList.find(
							(element) => {
								if (element.request_category_id === this.props.contentSelected)
									return element;
							}
						);

						contentSelectedString = contentSelectedObject.request_category;
					}

					this.setState({
						buttonClassName: 'CustomButton-Button-Category',
						contentsList: stringsList,
						currentValue: contentSelectedString,
					});
					break;
				case 'status':
					for (const item of this.props.statusesList) {
						stringsList.push(item.request_status);
					}

					if (this.props.contentSelected === 'status')
						contentSelectedString = 'status';
					else {
						contentSelectedObject = this.props.statusesList.find((element) => {
							if (element.request_status_id === this.props.contentSelected)
								return element;
						});

						contentSelectedString = contentSelectedObject.request_status;
					}

					this.setState({
						buttonClassName: 'CustomButton-Button-Status',
						contentsList: stringsList,
						currentValue: contentSelectedString,
					});
					break;
				case 'create':
					this.setState({
						buttonClassName: 'CustomButton-Button-Create',
						contentsList: TestingData.createList, // change this to...?
					});
					break;
				default:
					break;
			}
		}
	};

	render() {
		if (this.state.hasError) {
			return <h1>Something went wrong.</h1>;
		}

		return (
			<Tooltip title={this.state.currentValue} placement='top' arrow>
				<div
					className={this.state.buttonClassName}
					onClick={() => this.setState({ showList: !this.state.showList })}
					ref={this.wrapperRef}
				>
					{this.state.currentValue
						? this.state.currentValue
						: this.props.contentSelected}
					<div
						className={
							this.state.showList
								? 'CustomButton-List'
								: 'CustomButton-List hidden'
						}
					>
						{this.state.contentsList
							? this.state.contentsList.map((item, i) => {
									return (
										<div
											key={i}
											className='CustomButton-List-Item'
											onClick={() => this.setState({ currentValue: item })}
										>
											{item}
										</div>
									);
							  })
							: null}
					</div>
				</div>
			</Tooltip>
		);
	}
}

export default CustomButton;
