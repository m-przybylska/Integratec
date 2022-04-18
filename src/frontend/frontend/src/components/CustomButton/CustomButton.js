import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
//import { Test } from './CustomButton.styles';

class CustomButton extends PureComponent { 
  constructor(props) {
    super(props);

    this.state = {
      hasError: false,
    };
  }

  componentWillMount = () => {
    console.log('CustomButton will mount');
  }

  componentDidMount = () => {
    console.log('CustomButton mounted');
  }

  componentWillReceiveProps = (nextProps) => {
    console.log('CustomButton will receive props', nextProps);
  }

  componentWillUpdate = (nextProps, nextState) => {
    console.log('CustomButton will update', nextProps, nextState);
  }

  componentDidUpdate = () => {
    console.log('CustomButton did update');
  }

  componentWillUnmount = () => {
    console.log('CustomButton will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return (
      <div className="CustomButtonWrapper">
        Test content
      </div>
    );
  }
}

CustomButton.propTypes = {
  // bla: PropTypes.string,
};

CustomButton.defaultProps = {
  // bla: 'test',
};

export default CustomButton;
