import React from 'react';
import PropTypes from 'prop-types';
import { push } from 'react-router-redux';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import {
  increment,
  incrementAsync,
  decrement,
  decrementAsync
} from '../../modules/counter';

const Home = ({
  count, isIncrementing, isDecrementing, changePage, inc, dec, incAsync, decAsync
}) => (
  <div>
    <h1>Home</h1>
    <p>Count: {count}</p>

    <p>
      <button onClick={inc} disabled={isIncrementing}>
        Increment
      </button>
      <button onClick={incAsync} disabled={isIncrementing}>
        Increment Async
      </button>
    </p>

    <p>
      <button onClick={dec} disabled={isDecrementing}>
        Decrement
      </button>
      <button onClick={decAsync} disabled={isDecrementing}>
        Decrement Async
      </button>
    </p>

    <p>
      <button onClick={() => {
        console.log({ count, isDecrementing, changePage });
        changePage();
      }}
      >Go to about page via redux
      </button>
    </p>
  </div>
);

Home.propTypes = {
  count: PropTypes.number.isRequired,
  isIncrementing: PropTypes.bool.isRequired,
  isDecrementing: PropTypes.bool.isRequired,
  inc: PropTypes.func.isRequired,
  incAsync: PropTypes.func.isRequired,
  dec: PropTypes.func.isRequired,
  decAsync: PropTypes.func.isRequired,
  changePage: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  count: state.counter.count,
  isIncrementing: state.counter.isIncrementing,
  isDecrementing: state.counter.isDecrementing
});

const mapDispatchToProps = dispatch =>
  bindActionCreators(
    {
      inc: increment,
      incAsync: incrementAsync,
      dec: decrement,
      decAsync: decrementAsync,
      changePage: () => push('/about-us')
    },
    dispatch
  );

export default connect(mapStateToProps, mapDispatchToProps)(Home);
