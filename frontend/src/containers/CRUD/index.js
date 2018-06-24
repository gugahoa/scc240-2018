import React from 'react';
import { push } from 'react-router-redux';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Table from '../../components/Table';

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
        <h1>{test}</h1>
        <Table />
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
