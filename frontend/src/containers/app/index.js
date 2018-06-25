import React from 'react';
import { Route, Link } from 'react-router-dom';
import Home from '../home';
import About from '../about';
import Header from './Header';
import CRUD from '../CRUD';

const App = () => (
  <div>
    <header>
      {/* <Link to="/">Home</Link>
      <Link to="/about-us">About</Link> */}
      <Header />
    </header>

    <main>
      {/* <Route exact path="/" component={Home} />
      <Route exact path="/about-us" component={About} /> */}
      <CRUD />
    </main>
  </div>
);

export default App;
