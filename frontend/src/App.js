import React from 'react';
import './App.css';
import {Nav, Navbar, NavDropdown, MenuItem,  Tabs, ButtonToolbar, Button, Form, Table, ButtonGroup, Row, Col, Grid, Panel, FormGroup, FormControl} from 'react-bootstrap';
import * as bs from 'bootstrap/dist/css/bootstrap.css';
import Navi from './NavClass.js'
import { Route, BrowserRouter as Router,Switch} from 'react-router-dom';

class App 
extends React.Component
{
     render(){
        return(
           <Router>
               <Switch>
               <Route path='/' exact={true} component={Navi} />
               </Switch>
           </Router>
        )
     }
};

export default App;