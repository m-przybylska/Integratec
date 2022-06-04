import React, { PureComponent } from 'react';
import './Login.scss';
import logo from '../../assets/images/logo.svg';

class Login extends PureComponent {
	constructor(props) {
		super(props);

		this.state = {
			previewPopupIsVisible: false,
			inputUsername: '',
			inputPassword: '',
		};
		this.setPreviewPopupVisibility = this.setPreviewPopupVisibility.bind(this);
	}

	setPreviewPopupVisibility = () => {
		this.setState(
			{ previewPopupIsVisible: !this.state.previewPopupIsVisible },
			() => console.log(this.state.previewPopupIsVisible)
		);
	};

	handleSignIn = () => {
		console.log(
			'Clicked sign in, username is: ',
			this.state.inputUsername,
			' password id: ',
			this.state.inputPassword
		);
	};

	handleForgotPassword = () => {
		console.log('Clicked forgot password');
	};

	updateInputUsername(evt) {
		const val = evt.target.value;

		this.setState({
			inputUsername: val,
		});
	}

	updateInputPassword(evt) {
		const val = evt.target.value;

		this.setState({
			inputPassword: val,
		});
	}

	render() {
		return (
			<form className='Login'>
				<div className='Login-Logo'>
					<img src={logo} className='Navbar-leftSide-logo' alt='' />
				</div>
				<div className='Login-Authorization'>
					<i className='las la-user' />
					<div className='Login-Authorization-Text'>Authorization required</div>
				</div>
				<input
					className='Login-Input'
					placeholder='Username'
					value={this.state.inputUsername}
					onChange={(evt) => this.updateInputUsername(evt)}
				/>
				<input
					className='Login-Input'
					placeholder='Password'
					type='password'
					value={this.state.inputPassword}
					onChange={(evt) => this.updateInputPassword(evt)}
				/>
				<div className='Login-Buttons'>
					<div className='Login-Buttons-SignIn' onClick={this.handleSignIn}>
						Sign in
					</div>
					<div
						className='Login-Buttons-ForgotPassword'
						onClick={this.handleForgotPassword}
					>
						Forgot password?
					</div>
				</div>
			</form>
		);
	}
}

export default Login;
