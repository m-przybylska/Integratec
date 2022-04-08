import React, { PureComponent } from 'react';
import './PreviewPopup.scss';

class PreviewPopup extends PureComponent {
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
		return <div className='PreviewPopupWrapper'>Test content</div>;
	}
}

export default PreviewPopup;
