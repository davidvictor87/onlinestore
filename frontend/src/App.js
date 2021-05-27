import React from 'react';
import './App.css';
import {Nav, Navbar, NavDropdown, MenuItem,  Tabs, ButtonToolbar, Button, Form, Table, ButtonGroup, Row, Col, Grid, Panel, FormGroup, FormControl} from 'react-bootstrap';
import * as bs from 'bootstrap/dist/css/bootstrap.css';
import Navi from './NavClass.js'
import { Route, BrowserRouter as Router,Switch} from 'react-router-dom';
import axios from 'axios';
import CA from './CallApi.js';
import Login from './Login.js';

class App 
extends React.Component
{
     render(){
        return(
               <Router>
                 <Route path='/' exact={true} component={Navi} />
                 <Route path='/s' exact={true} component={CA}/>
                 <Route path='/login' exact={true} component={Login}/>
               </Router>
        )
     }

};

export default App;