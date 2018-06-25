import React from 'react';
import { push } from 'react-router-redux';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import TableComponent from '../../components/Table';
import FormComponent from '../../components/Form';

class CRUD extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      test: 'foo'
    };
  }

  componentDidMount() {
    console.log('mounted!');
  }

  render() {
    const { test } = this.state;
    return (
      <div>
        <TableComponent />
        <FormComponent />
      </div>
    );
  }
}

const mapStateToProps = () => ({
});

const mapDispatchToProps = dispatch =>
  bindActionCreators(
    {
    },
    dispatch
  );

export default connect(mapStateToProps, mapDispatchToProps)(CRUD);
