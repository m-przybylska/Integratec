import React, { PureComponent } from 'react';

import './Request.scss';

class Request extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {};
	}

	render() {
		const { name, title, priority, category } = this.props.data;
		return (
			<div className='Request' onClick={() => this.props.setPopupVisibility()}>
				<div className='Request-User'>
					<i className='las la-user' />
					<div className='Request-User-Name'>{name}</div>
				</div>
				<div className='Request-Title'>{title}</div>
				<div className='Request-Tags'>
					<div className='Request-Tags-Priority'>{priority}</div>
					<div className='Request-Tags-Category'>{category}</div>
				</div>
			</div>
		);
	}
}

export default Request;
